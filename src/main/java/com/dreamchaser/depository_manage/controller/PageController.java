package com.dreamchaser.depository_manage.controller;

import com.dreamchaser.depository_manage.exception.MyException;
import com.dreamchaser.depository_manage.pojo.DepositoryRecordP;
import com.dreamchaser.depository_manage.security.bean.UserToken;
import com.dreamchaser.depository_manage.service.DepositoryRecordService;
import com.dreamchaser.depository_manage.service.DepositoryService;
import com.dreamchaser.depository_manage.service.NoticeService;
import com.dreamchaser.depository_manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 专门用来展示页面的controller
 *
 * @author Dreamchaser
 */
@Controller
public class PageController {

    @Autowired
    private DepositoryService depositoryService;
    @Autowired
    private UserService userService;
    @Autowired
    private DepositoryRecordService depositoryRecordService;
    @Autowired
    private NoticeService noticeService;

    @GetMapping("/login")
    public String login() {
        return "pages/user/login";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register() {
        return "pages/user/register";
    }

    @GetMapping("/welcome")
    public ModelAndView welcome() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/other/welcome");
        Map<String, Object> map = new HashMap<String, Object>(2) {
            {
                put("beigin", 0);
                put("size",6);
            }
        };
        mv.addObject("notices", noticeService.findNoticeByCondition(map));
        return mv;
    }

    @GetMapping("/depository_add")
    public String depository_add() {
        return "pages/other/depository_add";
    }

    @GetMapping("/materialType_add")
    public String materialType_add() {
        return "pages/other/materialType_add";
    }

    @GetMapping("/application_in")
    public ModelAndView application_in() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/application/application-in");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        mv.addObject("reviewers", userService.findReviewers());
        return mv;
    }

    @GetMapping("/application_out")
    public ModelAndView application_out() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/application/application-out");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        mv.addObject("reviewers", userService.findReviewers());
        return mv;
    }

    @GetMapping("/application_transfer")
    public ModelAndView application_transfer() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/application/application-transfer");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        mv.addObject("reviewers", userService.findReviewers());
        return mv;
    }

    @GetMapping("/table_in")
    public ModelAndView table_in() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/depository/table-in");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        return mv;
    }

    @GetMapping("/table_out")
    public ModelAndView table_out() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/depository/table-out");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        return mv;
    }

    @GetMapping("/table_user")
    public ModelAndView table_user() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/table-user");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        return mv;
    }

    @GetMapping("/table_stock")
    public ModelAndView table_stock() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/depository/table-stock");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        return mv;
    }

    @GetMapping("/my_task")
    public String my_task() {
        return "pages/application/my-task";
    }

    @GetMapping("/my_apply")
    public String my_apply() {
        return "pages/application/my-apply";
    }

    @GetMapping("/notice_edit")
    public String notice_edit() {
        return "pages/other/notice-edit";
    }

    @GetMapping("/chart_in")
    public String chart_in() {
        return "pages/chart/chart-in";
    }

    @GetMapping("/chart_out")
    public String chart_out() {
        return "pages/chart/chart-out";
    }

    @GetMapping("/chart_stock")
    public String chart_stock() {
        return "pages/chart/chart-stock";
    }

    @GetMapping("/user_password")
    public String user_password() {
        return "pages/user/user-password";
    }

    @GetMapping("/user_add")
    public ModelAndView user_add() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/user-add");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        return mv;
    }

    @GetMapping("/user_edit")
    public ModelAndView user_edit(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/user-edit");
        mv.addObject("depositories", depositoryService.findDepositoryAll());
        mv.addObject("user", userService.findUserPById(id));
        return mv;
    }

    @GetMapping("/form_step_look")
    public ModelAndView form_step_look(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/application/form-step-look");
        if (id != null) {
            mv.addObject("record", depositoryRecordService.findDepositoryRecordById(id));
        } else {
            throw new MyException("缺少必要参数！");
        }
        return mv;
    }

    @GetMapping("/application_review")
    public ModelAndView application_review(Integer id) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/application/application-review");
        DepositoryRecordP recordP = depositoryRecordService.findDepositoryRecordById(id);
        mv.addObject("record", recordP);
        mv.addObject("checkers", userService.findUsersByDepositoryId(recordP.getDepositoryId()));
        return mv;
    }

    @GetMapping("/account_look")
    public ModelAndView account_look(Integer id, HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/account-look");
        UserToken userToken = (UserToken) request.getAttribute("userToken");
        mv.addObject("user", userToken.getUser());
        return mv;
    }

    @GetMapping("/user_email")
    public ModelAndView user_email(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("pages/user/user-email");
        UserToken userToken = (UserToken) request.getAttribute("userToken");
        mv.addObject("email", userToken.getUser().getEmail());
        return mv;
    }
}
