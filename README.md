

# 前言
此项目为仓库管理系统，是我大二下的实训课作业，虽然是从学期初开始写的，但是实际写项目的日子也就十多天（前面都没怎么动，果然只有临近ddl效率才高）。
到我写这篇博文的时候，实际上项目还有小部分功能未完成，当然如果你不是逐个试过去你是发现不了的（笑哭）。
说实话，我实在不想在未完成前写类似实验报告的文档，而且我也不喜欢写文档。我一直认为写项目根本不需要那么多死板的文档（反正也只是作业）。
有人可能又会奇怪我不喜欢写文档为啥写那么多博文？这个嘛，我写博文的目的也只是想把我那时那刻的情感和经验分享出来，我更倾向于那种随性的分享，不想循规蹈矩的写那些死板的文档，挺不喜欢那些老师每次要做项目都得要我们交各种图，各种功能业务表。话说我把项目部署到服务器上了，你点开看看用用不就行了，又不用你下载源码在自己电脑上跑起来？更何况，那些图对于那些幼稚园的项目还可以，毕竟不复杂，但是对于一个稍微大点的项目，光代码就一大堆，画那些业务图要画到猴年马月去？有这时间我拿来学习不香吗？（当然我是没时间的，年末要填一堆协会报表，还要准备实验室暑假集训...）。
更何况，围绕着一个增删改查的小项目大谈架构，这个我是非常鄙视的（初学者除外，因为没概念）。
....

好了，碎碎念了这么多，实在抱歉，下面是正文：

# 一、项目概述
## 1.项目需求

> 实现材料仓库的管理：提供材料出入库管理等实用功能。 材料入库管理：材料检验入库、入库查询、入库类别按月统计；
> 材料出库管理：材料库存查询、材料出库、出库查询、出库类别按月统计； 辅助管理：仓库系统的人员管理、基础表的管理。

当然啦，以上只是简单的需求，多的我也不展示了。

## 2.总述
此项目为Javaweb项目，前后端不分离，典型的单体架构，主要功能是对仓库转入转出等业务进行管理，并对数据进行可视化展示，同时有部分权限管理的功能（为什么这么说呢，因为我这部分做的并不严谨，如果后面有时间我会尽可能完善）。

## 3.技术栈选择
前端：layui、jquery、echarts、thymeleaf模板引擎
后端：mysql、maven、tomcat、mybatis、springMVC、spring、SpringBoot

注意：这里的前端页面我拿了gitee上的开源模板layui-mini，[地址](https://gitee.com/zhongshaofa/layuimini)。

## 4.环境介绍
数据库：mysql8.0
项目结构：maven
数据库连接池：Druid
前端框架：layui、jquery、echarts、thymeleaf模板引擎
后端框架：SpringBoot、SSM
语言：Java
jdk版本：8
编写的IDE：IDEA

## 5.效果图展示
为了更直观的展示项目，这里先放几张效果图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210617203249128.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/202106172032283.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619111451760.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)



![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154411464.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154429912.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154440361.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154508537.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154523115.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154551492.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154607821.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618154619372.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

# 二、设计思路
该系统主要的就是模拟仓库出入库的流程，所以我把用户的角色氛围普通用户、审核员、仓管员和系统管理员。
普通用户可以填写出入库申请进行制单，然后相应的审核人进行审核，审核员可以指定该仓库的仓管员进行验收，或者审核不通过；当审核成功，货物成功到达仓库时，仓库员进行验收操作，如果验收通过，则成功入库或者出库，相应的库存信息也发生变化。
系统管理员可以管理网站用户，同时发布网站公告。（这个角色权限管理的部分我还没完成，目前所有用户都可以操作所有功能）
除此之外，我还对与一些出入库申请、库存、仓库等信息进行查询和可视化的操作，让仓库管理员可以更直观的看到仓库信息的变化。

# 三、数据库设计
## 1.数据库模型设计概览
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618162351335.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

## 2.数据库表设计

### ①depository

![\[外链图片转存失败,源站可能有防盗链机制,建议将图片保存下来直接上传(img-UoO8CZQH-1624005477122)(C:\Users\76756\AppData\Local\Temp\ksohtml25664\wps2.jpg)\]](https://img-blog.csdnimg.cn/20210618163940592.png)
 

 

**描述：** 该表存储仓库的信息，比如仓库名称，仓库地址和仓库介绍
 


**表结构：**

| **序号** | **字段名** | **数据类型** | **主键** | **非空** | **默认值** | **描述** |
| -------- | ---------- | ------------ | -------- | -------- | ---------- | -------- |
| 1        | id         | INT(10)      | 是       | 是       |            |       仓库id   |
| 2        | dname      | VARCHAR(255) | 否       | 是       |            | 仓库名称 |
| 3        | address    | VARCHAR(255) | 否       | 是       |            | 仓库地址 |
| 4        | introduce  | VARCHAR(255) | 否       | 是       |            | 仓库介绍 |

 

### ②仓库调度记录（depository_record）

![\[外链图片转存失败,源站可能有防盗链机制,建议将图片保存下来直接上传(img-W33QoFN3-1624005477125)(C:\Users\76756\AppData\Local\Temp\ksohtml25664\wps3.jpg)\]](https://img-blog.csdnimg.cn/20210618165600496.png)
 

 

**描述：** 该表记录仓库调度的记录，同时该表也是数据也可以看做一条条申请信息。

 

**表结构：**

| **序号** | **字段名**     | **数据类型** | **主键** | **非空** | **默认值** | **描述**                                                     |
| -------- | -------------- | ------------ | -------- | -------- | ---------- | ------------------------------------------------------------ |
| 1        | id             | INT(10)      | 是       | 是       |            | 记录id                                                       |
| 2        | application_id | INT(10)      | 否       | 否       |            | 申请编号(暂时无用)                                           |
| 3        | mname          | VARCHAR(255) | 否       | 是       |            | 产品名称                                                     |
| 4        | depository_id  | INT(10)      | 否       | 是       |            | 调度的仓库id                                                 |
| 5        | type           | INT(10)      | 否       | 是       | 0          | 调度记录类型（0出库，1入库)                                  |
| 6        | quantity       | DOUBLE(22)   | 否       | 否       |            | 数量                                                         |
| 7        | price          | DOUBLE(22)   | 否       | 否       |            | 价格                                                         |
| 8        | state          | VARCHAR(255) | 否       | 否       |            | 状态（待审核/审核未通过，未入库/出库/检验不通过，待验收/已入库/已出库） |
| 9        | applicant_id   | INT(10)      | 否       | 否       |            | 申请人id                                                     |
| 10       | apply_remark   | VARCHAR(255) | 否       | 否       |            | 申请备注                                                     |
| 11       | apply_time     | DATETIME     | 否       | 否       |            | 申请时间                                                     |
| 12       | reviewer_id    | INT(10)      | 否       | 否       |            | 审核人id                                                     |
| 13       | review_remark  | VARCHAR(255) | 否       | 否       |            | 审核结果备注                                                 |
| 14       | review_time    | DATETIME     | 否       | 否       |            | 审核时间                                                     |
| 15       | review_pass    | INT(10)      | 否       | 否       |            | 审核是否通过，0表示未通过，1表示通过                         |
| 16       | checker_id     | INT(10)      | 否       | 否       |            | 验货人id                                                     |
| 17       | check_remark   | VARCHAR(255) | 否       | 否       |            | 验收备注                                                     |
| 18       | check_time     | DATETIME     | 否       | 否       |            | 出入库时间（验货时间）                                       |
| 19       | check_pass     | INT(10)      | 否       | 否       |            | 验收是否通过                                                 |

 

## 3、产品信息记录（库存）（material）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618165646888.png)

 

 

**描述：** 产品信息记录（库存信息）

 

**表结构：**

| **序号** | **字段名**    | **数据类型** | **主键** | **非空** | **默认值** | **描述**   |
| -------- | ------------- | ------------ | -------- | -------- | ---------- | ---------- |
| 1        | id            | INT(10)      | 是       | 是       |            | 存储id     |
| 2        | depository_id | INT(10)      | 否       | 否       |            | 仓库名称   |
| 3        | mname         | VARCHAR(255) | 否       | 否       |            | 材料名称   |
| 4        | quantity      | DOUBLE(22)   | 否       | 否       |            | 数量       |
| 5        | price         | DOUBLE(22)   | 否       | 否       |            | 总金额     |
| 6        | type_id       | INT(10)      | 否       | 否       |            | 材料种类id |

 

## 4、material_type

![\[外链图片转存失败,源站可能有防盗链机制,建议将图片保存下来直接上传(img-MFjBERNq-1624005477128)(C:\Users\76756\AppData\Local\Temp\ksohtml25664\wps5.jpg)\]](https://img-blog.csdnimg.cn/20210618165636448.png)

 

 

**描述：**材料种类，我对材料进行了分类，这样统计起来也方便很多，另外建一个表是为了防止以后可能会对材料类型做的补充，同时节省存储空间。

 

**表结构：**

| **序号** | **字段名** | **数据类型** | **主键** | **非空** | **默认值** | **描述** |
| -------- | ---------- | ------------ | -------- | -------- | ---------- | -------- |
| 1        | id         | INT(10)      | 是       | 是       |            | 类型id   |
| 2        | tname      | VARCHAR(255) | 否       | 是       |            | 类型名称 |
| 3        | introduce  | VARCHAR(255) | 否       | 否       |            | 类型介绍 |

 

## 5、notice

![\[外链图片转存失败,源站可能有防盗链机制,建议将图片保存下来直接上传(img-bn2owLuH-1624005477130)(C:\Users\76756\AppData\Local\Temp\ksohtml25664\wps6.jpg)\]](https://img-blog.csdnimg.cn/20210618165627709.png)
 

 

**描述：**公告表，用于存储公告信息

 

**表结构：**

| **序号** | **字段名** | **数据类型** | **主键** | **非空** | **默认值** | **描述** |
| -------- | ---------- | ------------ | -------- | -------- | ---------- | -------- |
| 1        | id         | INT(10)      | 是       | 是       |            | 公告主键 |
| 2        | title      | VARCHAR(255) | 否       | 是       |            | 公告标题 |
| 3        | content    | VARCHAR(255) | 否       | 否       |            | 公告内容 |
| 4        | time       | DATETIME     | 否       | 是       |            | 发布时间 |

 

## 6、standing_book
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618165701826.png)


 

**描述：**台账表，作业要求里有要台账表，但我觉得这和仓库调度表没啥区别，所以这个表我虽然建了，但实际并未使用。

 

**表结构：**

| **序号** | **字段名**    | **数据类型** | **主键** | **非空** | **默认值** | **描述**                                                     |
| -------- | ------------- | ------------ | -------- | -------- | ---------- | ------------------------------------------------------------ |
| 1        | id            | INT(10)      | 是       | 是       |            | 台账记录id                                                   |
| 2        | type          | INT(10)      | 否       | 是       |            | 0表示调入，1表示调出（外部）;2表示调入（退料），3表示调出（领料）（内部调用） |
| 3        | quantity      | INT(10)      | 否       | 是       | 0          | 数量                                                         |
| 4        | price         | INT(10)      | 否       | 是       | 0          | 总价                                                         |
| 5        | material_name | VARCHAR(255) | 否       | 是       |            | 材料名称                                                     |

 

## 7、transfer_record

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618165709346.png)


 

**描述：**转移表，这个是用来关联转移操作的。

 

**表结构：**

| **序号** | **字段名** | **数据类型** | **主键** | **非空** | **默认值** | **描述**   |
| -------- | ---------- | ------------ | -------- | -------- | ---------- | ---------- |
| 1        | id         | INT(10)      | 是       | 是       |            | 转移记录id |
| 2        | from_id    | INT(10)      | 否       | 是       |            | 转出仓库记录id |
| 3        | to_id      | INT(10)      | 否       | 是       |            | 转入仓库记录id |

 

## 8、 user

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210618165717935.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


 

**描述：**用户表，这里的密码是经过加密存储的，所以就算黑客破解数据库了，那损失也不会太大。

 

**表结构：**

| **序号** | **字段名**    | **数据类型** | **主键** | **非空** | **默认值** | **描述**                                           |
| -------- | ------------- | ------------ | -------- | -------- | ---------- | -------------------------------------------------- |
| 1        | id            | INT(10)      | 是       | 是       |            | 用户id                                             |
| 2        | uname         | VARCHAR(255) | 否       | 是       |            | 用户名称                                           |
| 3        | authority     | VARCHAR(255) | 否       | 否       |            | 表示权限等级（游客/员工/审核员/仓管员/系统管理员） |
| 4        | pwd           | VARCHAR(255) | 否       | 否       |            | 用户登录密码（数据库存储的是加密后的）             |
| 5        | sex           | VARCHAR(255) | 否       | 是       |            | 性别                                               |
| 6        | depository_id | INT(10)      | 否       | 否       |            | 负责仓库，序号表示仓库id，0表示全部仓库            |
| 7        | entry_date    | DATE         | 否       | 是       |            | 入职日期                                           |
| 8        | email         | VARCHAR(255) | 否       | 否       |            | 邮箱                                               |
| 9        | phone         | VARCHAR(255) | 否       | 否       |            | 手机号                                             |

 

# 四、功能设计与展示
**功能设计概览图**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619113212863.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)



## 1.鉴权认证
这块如果要讲，如果要详细讲，东西会很多。这里只简要的提一下。
用户注册的时候，输入邮箱后点击发送验证码，服务器会先判断该用户邮箱是否已经被注册，如果没有则会向相应邮箱发送验证码，验证码有效时间默认为5分钟，有则返回提示信息告知用户该邮箱已被注册。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619104900945.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619104823309.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

而输入信息和验证码后系统会进行校验，如果成功就对密码进行MD5加密，然后存入用户信息表中。

而对于用户登录，我采用的是token机制，详情请看我另一篇博文[手把手教你用Java实现一套简单的鉴权服务（SpringBoot，SSM）（万字长文）](https://blog.csdn.net/qq_46101869/article/details/116424137)

## 2.仓库管理
### ①出入库申请流程
参与出入库申请的角色有三个——发起申请的普通用户，审核申请的审核人，仓库验收的仓管员。
普通用户发起申请（制单）->审核人审核申请->相应仓管员验收货物->入库或出库

用户能发起三种类型的申请——出库，入库，转移
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143112227.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061914312943.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


### ②出入库管理
#### 1.出入库查询
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619141555407.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

用户可以查看出入库申请记录，同时也可以选择**开始日期，仓库，材料名称**等来进行自己期望的查询，并可以点击**详情**查看详细信息。

> 注：这里表格的数据并不是一次全部给前端，而是前端根据自己的需求分页获取


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619141814247.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

也可以对记录进行 **（批量）删除**，
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619141901951.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

也可以进行**排序筛选**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619141952136.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619142025973.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

同时也支持对当前数据进行**导出打印**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619142048555.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619142127608.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619142104291.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

#### 2.可视化展示
出入库的信息将会以图表的信息展现出来，可以给管理者一个更直观的感受
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619142906853.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143034187.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)



### ③库存管理
#### 1.库存查询
这个和上面类似，不过这里因为字段较少就没有设置详情，同时为了库存安全，这里并未提供增删改功能，只能供用户查询信息。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143410935.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

不过也提供**筛选、导出和打印**的功能
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143706890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143724101.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061914373995.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

#### 2.可视化展示
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619143916276.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


### ④其他管理
这里我只写了仓库增加和材料类型增加
#### 1.材料种类添加
![在这里插入图片描述](https://img-blog.csdnimg.cn/202106191441383.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

#### 2.仓库创建
![](https://img-blog.csdnimg.cn/20210619144213820.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

## 3.个人管理
### ①我的任务
此处会显示登录用户的**未完成任务**和**已完成任务**。

> 注：这里采取流式加载来懒加载数据

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619145349527.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

点击加载更多会向服务器请求另外所需数据，如果没有则会显示“没有更多了”

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619145513976.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

点击未完成任务，则会进入审核/验收页面
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619145716326.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619145739377.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

审核的话需要指定对应仓库的仓管员负责验收任务，同时写下备注，点击审核通过或者不通过。
验收只要写备注以及验收通过或者不通过。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150212383.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


### ②我的申请
在这里可以查看自己提交的申请

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150320994.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

点击可以查看申请所处的流程阶段，实时查看自己的申请状况。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150409937.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/2021061915042685.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### ③个人信息管理
在这个页面，用户可以查看和修改自己的非敏感信息。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150543720.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150606999.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

如果你要对你的绑定邮箱和密码进行修改，则需要进行额外的流程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150711775.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150715563.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

## 4.网站管理
### ①公告
在这里可以发布公告
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150835312.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

同时在首页可以查看对应公告
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150923743.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619150933817.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

### ②人员管理
系统管理员可以查看对应的人员信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619151104245.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

可以筛选查询需要的信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619151134964.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

可以（批量）删除用户信息，也可以添加用户信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619151232896.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

或者编辑修改用户信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619151248461.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)

还可以导出打印用户信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619151348713.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)


# 五、代码结构
这里为了让更多人看懂代码，这里我讲讲我的代码结构和对应包的意义。
首先是典型的maven结构，main里面是源代码，。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619160606940.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
entity：数据库实体类，与数据库字段一一对应
pojo：封装实体类，用于封装数据库实体类给前端需要的数据
mapper：数据库层，专门与数据库打交道
service：业务层，封装业务逻辑
controller：控制层，控制对应数据和视图，以及做一些参数检查

aop：这里面放的是切面相关的类。这里我就放了一个日志切面类，用于记录日志的
config：配置包，放配置类。这里我放了springMVC的配置类
exception：异常类。这里我定义了自己的异常类MyException
exceptionHandler：异常处理类。这里我用于捕获抛出的异常，同时返回给前端对应的错误信息
intercepter：拦截器类。利用spring的拦截器，用于做用户鉴权与权限控制。
security：安全控制，这个包下我实现token机制，详情看我另一篇博文[手把手教你用Java实现一套简单的鉴权服务（SpringBoot，SSM）（万字长文）](https://blog.csdn.net/qq_46101869/article/details/116424137)
utils：工具类，封装了一些常用操作

# 六、做项目时遇到的问题

## 1.静态资源被拦截
在测试项目过程中在这里插入图片描述
，我发现返回的页面都未加载出css下的public.css文件，一开始以为是maven配置的原因导致没把对应的静态文件输出target目录中，但是看了后发现静态文件已经加载进target目录中。
于是查看对应报错信息是404未找到，
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619152848784.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ2MTAxODY5,size_16,color_FFFFFF,t_70)
可对应目录下有相应文件，于是我怀疑是被框架拦截了。
于是搜索相关信息，果然如此。

根据网络上的方法改来改去还是不行（主要是不明白为什么）。
认真思考推测问题的原因后，我把静态文件都放在了static目录下，同时在application.yml中加入了这句，
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619152259738.png)
就是告诉springMVC，static开头的是静态文件，你别给我拦截了。
然后我在引用静态文件时都采用static开头的写法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619152425603.png)

做完之后问题成功解决！

## 2.layui框架动态表格分页的坑
这个也不算坑吧，可能也是我自己没理解，我误把count属性想成了这次请求返回的数据的数量，可实际上是所有数据的条数。仔细想想也确实该如此，不然前端怎么知道该分多少页呢？

## 3.部署的坑
部署的时候发现访问相应的网页，服务器上报模板未找到，搜了一下发现，返回的路径不该以/开头，当然这么说是不严谨的，这个取决于springMVC的配置
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210619164122109.png)

这里我配了/，所以路径前加/的话会有两个//，因此无法找到。

# 六、心得体会
项目从头到尾写下来，感觉锻炼最大的不是我的后端能力，而是我的前端能力！在写页面的过程中，我渐渐开始自己去读对应文档学习前端知识，去编写自己想要的页面，去实现自己想要的功能。最后回过头去看项目，感觉还算不错，而我也摸到了前端的一些门路（当然我前端菜鸟的身份依旧未变）。


最后，附上项目演示地址[演示地址](http://121.41.231.230:10010/index)，账号123456@qq.com,密码123456。

此项目已开源至gitee，想拿项目去玩玩的可以点击这里查看[添加链接描述](https://gitee.com/dreamchasers/depository_manage)，如果觉得还不错不要忘了star哦！

> 注：目前项目部分功能并未开发完全，由于期末要上交实验报告，所以介绍的博文我提前发出来了。由于期末很忙（一边准备期末考试，一边安排协会事宜，安排实验室暑假集训）短时间内也并不会去开发完善功能。还有就是我租的阿里云服务器快到期了，到时候估计会重新租个华为云的服务器，所以演示地址可能会失效，如果失效了记得@我一下。


**愿我们以梦为马，不负青春韶华！
与君共勉！**