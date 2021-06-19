package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.pojo.RestResponse;
import com.dreamchaser.depository_manage.pojo.StatusInfo;
import com.dreamchaser.depository_manage.security.bean.LoginRealms;
import com.dreamchaser.depository_manage.security.bean.LoginType;
import com.dreamchaser.depository_manage.security.bean.UserToken;
import com.dreamchaser.depository_manage.security.bean.VerificationCode;
import com.dreamchaser.depository_manage.security.pool.VerificationCodePool;
import com.dreamchaser.depository_manage.service.UserService;
import com.dreamchaser.depository_manage.utils.CrudUtil;
import com.dreamchaser.depository_manage.utils.Md5;
import com.dreamchaser.depository_manage.utils.ObjectFormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static com.dreamchaser.depository_manage.utils.CrudUtil.deleteHandle;


/**
 * 用户的相关接口
 * @author 金昊霖
 */
@RestController
public class UserController {
    @Autowired
    private LoginRealms loginRealms;
    @Autowired
    private UserService userService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    /**
     * 注册用户（通常为手机或者邮箱注册）
     * @param map 参数列表，包括账号（手机注册就是phone，邮箱就是email）、密码
     * @return 成功则返回凭证，否则返回验证失败
     */
    @PostMapping("/register")
    public RestResponse register(@RequestBody Map<String,Object>map){
        String principal;
        Object password=map.get("pwd");
        Object code=map.get("code");
        UserToken userToken;
        //判断必要参数是否满足
        if (password==null||code==null){
            return CrudUtil.ID_MISS_RESPONSE;
        }

        //从map中获取对应参数
        if (map.get("email")!=null){
            principal=String.valueOf(map.get("email"));
            userToken=new UserToken(LoginType.EMAIl_PASSWORD,principal,String.valueOf(password));
        }else {
            return CrudUtil.ID_MISS_RESPONSE;
        }
        //验证码正确且成功插入数据
        if (checkCode(principal,String.valueOf(code))){
            //对密码进行加密然后存储用户信息
            map.put("pwd",Md5.crypt(String.valueOf(map.get("pwd"))));
            //如果用户记录插入成功
            if (userService.insertUser(map)==1){
                String token= Md5.crypt(userToken.getPrincipal()+userToken.getInstant());
                //返回凭证
                return new RestResponse().setData(token);
            }
        }else {
            //验证码错误
            return CrudUtil.CODE_ERROR;
        }
        return new RestResponse().setStatus(450).setStatusInfo(new StatusInfo("注册失败，系统繁忙，请稍后再试！","注册失败"));
    }

    /**
     * 验证是否有此账号，然后发送验证码
     * @param map 主要认证主体，如账号，邮箱，qq的openID，wechat的code等
     * @return restResponse，附带凭证token
     */
    @PostMapping("/sendCode")
    public RestResponse sendCode(@RequestBody Map<String,Object> map){
        if (userService.findUserByCondition(map)==null){
            String principal;
            if (map.containsKey("phone")){
                principal=String.valueOf(map.get("phone"));

            }else if (map.containsKey("email")){
                principal=String.valueOf(map.get("email"));
            }else {
                return CrudUtil.ID_MISS_RESPONSE;
            }
            //创建一个验证码
            VerificationCode v=new VerificationCode();
            //将验证码存入验证码等待池
            VerificationCodePool.addCode(principal,v);
            //发送邮箱验证码
            sendEmail(principal,v.getCode());
            return new RestResponse();
        }
        return new RestResponse("",304,new StatusInfo("发送验证码失败，该账户已存在！","发送验证码失败，该账户已存在！"));
    }

    /**
     * 登录接口
     * @param map 登录信息
     *  loginType 登录方式，目前支持的有email,qq,wechat
     *  principal 主要认证主体，如账号，邮箱，qq的openID，wechat的code等
     *  credentials 类似于密码，如果是qq，wechat则不需要传改参数
     *  restResponse，附带凭证token
     */
    @PostMapping("/login")
    public RestResponse login(@RequestBody Map<String,String> map) {
        UserToken userToken=new UserToken(LoginType.getType(map.get("loginType"))
                ,map.get("principal"),map.get("credentials"));
        return login(userToken);
    }

    /**
     * 退出登录,删除令牌的操作依据在拦截器中完成
     * @return RESPONSE200
     */
    @GetMapping("/logout")
    public RestResponse logout() {
        return CrudUtil.RESPONSE200;
    }

    @GetMapping("/sys/users")
    public RestResponse findUsers(@RequestParam Map<String,Object> map) {
        return new RestResponse(userService.findUserPsByCondition(map),userService.findCount(),200);
    }
    @PostMapping("/sys/user")
    public RestResponse addUser(@RequestBody Map<String,Object> map) {
        //对密码进行加密
        map.put("pwd",Md5.crypt(String.valueOf(map.get("pwd"))));
        return CrudUtil.postHandle(userService.insertUser(map),1);
    }
    @PutMapping("/sys/user")
    public RestResponse updateUser(@RequestBody Map<String,Object> map) {
        if (map.containsKey("pwd")&&map.get("pwd")!=""){
            //对密码进行加密
            map.put("pwd",Md5.crypt(String.valueOf(map.get("pwd"))));
        }
        return CrudUtil.postHandle(userService.updateUser(map),1);
    }
    @DeleteMapping("/sys/user")
    public RestResponse deleteUser(@RequestBody Map<String,Object> map) {
        return deleteHandle(userService.deleteUserById(ObjectFormatUtil.toInteger(map.get("id"))),1);
    }
    @DeleteMapping("/sys/users")
    public RestResponse deleteUsers(@RequestBody Map<String,Object> map) {
        if (map.containsKey("ids")){
            List<Integer> ids=(List<Integer>) map.get("ids");
            return CrudUtil.deleteHandle(userService.deleteUserByIds(ids),ids.size());
        }else {
            return CrudUtil.ID_MISS_RESPONSE;
        }
    }

    @PutMapping("/user")
    public RestResponse updateSelf(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        map.put("id",userToken.getUser().getId());

        return CrudUtil.postHandle(userService.updateUserNoSensitive(map),1);
    }
    @PutMapping("/checkOldEmail")
    public RestResponse checkOldEmail(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        if (!map.containsKey("oldCode")){
            return CrudUtil.ID_MISS_RESPONSE;
        }
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        if (checkCode(userToken.getPrincipal(),  map.get("oldCode").toString())){
            return new RestResponse("验证成功！");
        }else {
            //验证码错误
            return CrudUtil.CODE_ERROR;
        }
    }
    @PutMapping("/updateEmail")
    public RestResponse updateEmail(@RequestBody Map<String,Object> map, HttpServletRequest request) {
        //参数检测
        if (!map.containsKey("email")||!map.containsKey("oldCode")||!map.containsKey("newCode")){
            return CrudUtil.ID_MISS_RESPONSE;
        }
        UserToken userToken= (UserToken) request.getAttribute("userToken");
        //必须同时检测,否则会出现漏洞
        if (checkCode(userToken.getPrincipal(),map.get("oldCode").toString())
                &&checkCode(map.get("email").toString(),  map.get("code").toString())){
            map.put("id",userToken.getUser().getId());
            return CrudUtil.putHandle(userService.updateUser(map),1);
        }else {
            //验证码错误
            return CrudUtil.CODE_ERROR;
        }

    }


    /**
     * 将生成的令牌拿去认证，如果认证成功则返回带有token凭证响应，否则返回用户密码错误的响应
     * @param userToken 未认证的令牌
     * @return restResponse 如果认证成功则返回带有token凭证响应，否则返回用户密码错误的响应
     */
    private RestResponse login(UserToken userToken) {
        String token=loginRealms.authenticate(userToken);
        if (token!=null){
            return new RestResponse(token);
        }else {
            return CrudUtil.NOT_EXIST_USER_OR_ERROR_PWD_RESPONSE;
        }
    }

    /**
     * 用于注册用户的方法，主要为号码验证和邮箱验证提供验证码核对的服务
     * @param principal 认证主体
     * @param code 验证码
     * @return 是否验证通过
     */
    private boolean checkCode(String principal,String code){
        if (code!=null){
            VerificationCode verificationCode=VerificationCodePool.getCode(principal);
            if (verificationCode!=null){
                return code.equals(verificationCode.getCode());
            }
        }
        return false;
    }

    /**
     * 发送带有验证码的邮件信息
     */
    private void sendEmail(String email,String code){
        //发送验证邮件
        try {
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            //主题
            mailMessage.setSubject("仓库管理系统的验证码邮件");

            //内容
            mailMessage.setText("欢迎使用仓库管理系统，您正在注册此账户。" +
                    "\n您收到的验证码是： "+code+" ，请不要将此验证码透露给别人。");

            //发送的邮箱地址
            mailMessage.setTo(email);
            //默认发送邮箱邮箱
            mailMessage.setFrom(fromEmail);

            //发送
            mailSender.send(mailMessage);
        }catch (Exception e){
            throw new MyException(e.toString());
        }
    }
}
