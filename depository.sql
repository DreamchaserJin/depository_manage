/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : depository

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 17/06/2021 20:47:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for depository
-- ----------------------------
DROP TABLE IF EXISTS `depository`;
CREATE TABLE `depository`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '仓库名称',
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '仓库地址',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '仓库介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depository
-- ----------------------------
INSERT INTO `depository` VALUES (1, '小商品仓库', '浙江省义乌市', '存放各种小商品');
INSERT INTO `depository` VALUES (2, '外芯仓库', '浙江省义乌市', '存放各类芯片，义乌高新科技的中转仓');
INSERT INTO `depository` VALUES (3, '家电仓库', '浙江省义乌市', '存放家电');
INSERT INTO `depository` VALUES (4, '服装仓库', '浙江省义乌市', '存放服装');

-- ----------------------------
-- Table structure for depository_record
-- ----------------------------
DROP TABLE IF EXISTS `depository_record`;
CREATE TABLE `depository_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '记录id',
  `application_id` int(11) NULL DEFAULT NULL COMMENT '申请编号(暂时无用)',
  `mname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '产品名称',
  `depository_id` int(11) NOT NULL COMMENT '调度的仓库id',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '调度记录类型（0出库，1入库)',
  `quantity` double NULL DEFAULT NULL COMMENT '数量',
  `price` double NULL DEFAULT NULL COMMENT '价格',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '状态（待审核/审核未通过，未入库/出库/检验不通过，待验收/已入库/已出库）',
  `applicant_id` int(11) NULL DEFAULT NULL COMMENT '申请人id',
  `apply_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '申请备注',
  `apply_time` datetime(0) NULL DEFAULT NULL COMMENT '申请时间',
  `reviewer_id` int(11) NULL DEFAULT NULL COMMENT '审核人id',
  `review_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '审核结果备注',
  `review_time` datetime(0) NULL DEFAULT NULL COMMENT '审核时间',
  `review_pass` int(11) NULL DEFAULT NULL COMMENT '审核是否通过，0表示未通过，1表示通过',
  `checker_id` int(11) NULL DEFAULT NULL COMMENT '验货人id',
  `check_remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '验收备注',
  `check_time` datetime(0) NULL DEFAULT NULL COMMENT '出入库时间（验货时间）',
  `check_pass` int(11) NULL DEFAULT NULL COMMENT '验收是否通过',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 42 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '仓库调度记录' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of depository_record
-- ----------------------------
INSERT INTO `depository_record` VALUES (9, 0, '童装', 4, 1, 10, 9, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '审核通过！', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (10, 0, '自研芯片', 1, 1, 10, 9, '待验收', 1, '材料进货', '2021-06-10 11:39:16', 2, '审核通过！', '2021-06-10 11:37:00', 1, 3, '验证通过', NULL, NULL);
INSERT INTO `depository_record` VALUES (11, 0, '手机', 1, 1, 10, 9, '已入库', 1, '材料进货', '2021-06-12 14:53:18', 2, '审核通过！', '2021-06-14 15:57:30', 1, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (12, 0, '衣服A', 4, 1, 123, 123, '待审核', 2, '材料进货', '2021-06-04 10:34:05', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (13, 0, '衣服A', 4, 0, 123, 12312, '待审核', 2, '材料领取', '2021-06-04 10:36:58', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (14, 0, '骁龙888', 2, 0, 123, 123, '待验收', 2, '材料领取', '2021-06-04 11:36:18', 2, '审核通过', '2021-06-14 16:10:23', 1, 2, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (15, 0, '麒麟9000', 2, 0, 10, 10000, '待审核', 2, '材料领取', '2021-06-05 11:42:50', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (19, 0, '麒麟9000', 2, 1, 10, 10000, '已入库', 2, '材料进货', '2021-06-12 14:52:28', 2, '审核通过', '2021-06-14 16:12:51', 1, 2, '验收通过', '2021-06-16 10:05:17', 1);
INSERT INTO `depository_record` VALUES (20, 0, '儿童服装b', 4, 0, 123, 123, '审核未通过', 2, '材料领取', '2021-06-12 14:52:31', 3, '缺少必要材料，审核不通过！', '2021-06-17 15:57:16', NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (24, 0, '骁龙870', 1, 0, 3, 1500, '待审核', 2, '材料出库', '2021-06-12 14:52:34', 2, '通过', '2021-06-12 17:09:26', 1, 2, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (26, 0, '骁龙870', 1, 0, 3, 1500, '待审核', 1, '材料进货', '2021-06-12 14:52:54', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (27, 0, '骁龙870', 1, 0, 3, 1500, '待审核', 1, '材料进货', '2021-06-12 14:52:58', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (28, 0, '天玑1200', 1, 0, 10, 1000, '待审核', 1, '材料进货', '2021-06-12 14:53:01', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (29, 0, '天玑1200+', 1, 0, 10, 1000, '待审核', 1, '材料进货', '2021-06-12 14:53:04', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (31, 0, '天玑1000', 1, 1, 10, 1000, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '2', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (32, 0, '天玑1000', 1, 1, 10, 1000, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '2', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (33, 0, '芯片b', 1, 1, 10, 800, '待审核', 1, '芯片必须尽快进厂', '2021-06-10 19:56:16', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (34, 0, '牛排', 3, 1, 120, 12030, '待审核', 1, '顶级牛排，老板要求', '2021-06-10 20:01:56', 3, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (35, 0, '天玑1200', 1, 1, 10, 1000, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '2', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (36, 0, '天玑1200', 1, 1, 10, 1000, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '2', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (37, 0, '天玑1200', 1, 1, 10, 1000, '已入库', 1, '材料进货', '2021-06-10 11:39:12', 3, '2', '2021-06-17 11:36:20', 1, 3, '验证通过', '2021-06-18 11:36:44', 1);
INSERT INTO `depository_record` VALUES (39, 0, '冰箱', 3, 0, 3, 6000, '审核未通过', 2, '材料领取', '2021-06-05 11:42:50', 2, '审核不通过！', '2021-06-14 16:21:29', 0, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (40, 0, '电扇', 2, 0, 5, 1000, '已出库', 2, '材料领取', '2021-06-04 11:36:18', 2, '审核通过', '2021-06-16 10:00:59', 1, 2, '审核通过', '2021-06-16 10:03:57', 1);
INSERT INTO `depository_record` VALUES (41, 0, '冰柜', 2, 0, 4, 4000, '待验收', 2, '材料领取', '2021-06-04 11:36:18', 2, '审核通过', '2021-06-14 16:10:23', 1, 2, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (42, 0, '衣服A', 4, 1, 123, 123, '待审核', 2, '材料进货', '2021-06-04 10:34:05', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (43, 0, '衣服A', 4, 1, 123, 123, '待审核', 2, '材料进货', '2021-06-04 10:34:05', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (44, 0, '衣服A', 4, 1, 123, 123, '待审核', 2, '材料进货', '2021-06-04 10:34:05', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `depository_record` VALUES (45, 0, '衣服A', 4, 1, 123, 123, '待审核', 2, '材料进货', '2021-06-04 10:34:05', 2, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for material
-- ----------------------------
DROP TABLE IF EXISTS `material`;
CREATE TABLE `material`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '存储id',
  `depository_id` int(11) NULL DEFAULT NULL COMMENT '仓库名称',
  `mname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '材料名称',
  `quantity` double NULL DEFAULT NULL COMMENT '数量',
  `price` double NULL DEFAULT NULL COMMENT '总金额',
  `type_id` int(11) NULL DEFAULT NULL COMMENT '材料种类id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '产品信息记录（库存）' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material
-- ----------------------------
INSERT INTO `material` VALUES (1, 2, '天玑1000', 100, 100000, 1);
INSERT INTO `material` VALUES (2, 2, '天玑1200', 10, 10000, 1);
INSERT INTO `material` VALUES (3, 2, '麒麟9000', 10, 10000, 1);
INSERT INTO `material` VALUES (4, 2, '自研芯片', 10, 10000, 1);
INSERT INTO `material` VALUES (5, 4, '衣服A', 10, 500, 7);
INSERT INTO `material` VALUES (6, 1, '牛排', 10, 1000, 7);
INSERT INTO `material` VALUES (7, 3, '冰箱', 10, 30000, 6);
INSERT INTO `material` VALUES (8, 3, '冰柜', 10, 10000, 6);
INSERT INTO `material` VALUES (9, 3, '电扇', 10, 2000, 6);
INSERT INTO `material` VALUES (10, 2, '骁龙870', 10, 10000, 6);
INSERT INTO `material` VALUES (11, 2, '骁龙870', 10, 15000, 1);

-- ----------------------------
-- Table structure for material_type
-- ----------------------------
DROP TABLE IF EXISTS `material_type`;
CREATE TABLE `material_type`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类型id',
  `tname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '类型名称',
  `introduce` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '类型介绍',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of material_type
-- ----------------------------
INSERT INTO `material_type` VALUES (1, '芯片类', '各种芯片');
INSERT INTO `material_type` VALUES (4, '海产品类', '各种海产品');
INSERT INTO `material_type` VALUES (5, '电子元器件', '各类电子元器件');
INSERT INTO `material_type` VALUES (6, '家电', '各种家电');
INSERT INTO `material_type` VALUES (7, '服装类', '各类服装');
INSERT INTO `material_type` VALUES (9, '小商品', '小商品');

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '公告主键',
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '公告标题',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '公告内容',
  `time` datetime(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '发布时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES (1, '公告测试', '公告测试', '2021-06-14 20:22:18');
INSERT INTO `notice` VALUES (2, '网站公告测试1', '网站公告测试1', '2021-06-14 20:23:53');
INSERT INTO `notice` VALUES (3, '网站公告测试2', '网站公告测试2', '2021-06-14 20:25:55');
INSERT INTO `notice` VALUES (4, '网站开发公告', '网站开发中', '2021-06-17 11:27:10');
INSERT INTO `notice` VALUES (5, '公告测试', '公告测试', '2021-06-14 20:22:18');
INSERT INTO `notice` VALUES (6, '网站开发公告', '网站开发中', '2021-06-17 11:27:10');

-- ----------------------------
-- Table structure for standing_book
-- ----------------------------
DROP TABLE IF EXISTS `standing_book`;
CREATE TABLE `standing_book`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '台账记录id',
  `type` int(11) NOT NULL COMMENT '0表示调入，1表示调出（外部）;2表示调入（退料），3表示调出（领料）（内部调用）',
  `quantity` int(11) NOT NULL DEFAULT 0 COMMENT '数量',
  `price` int(11) NOT NULL DEFAULT 0 COMMENT '总价',
  `material_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '材料名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of standing_book
-- ----------------------------
INSERT INTO `standing_book` VALUES (18, 0, 10, 9, '');
INSERT INTO `standing_book` VALUES (19, 0, 10, 9, '');
INSERT INTO `standing_book` VALUES (20, 0, 10, 9, '');

-- ----------------------------
-- Table structure for transfer_record
-- ----------------------------
DROP TABLE IF EXISTS `transfer_record`;
CREATE TABLE `transfer_record`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '转移记录id',
  `from_id` int(11) NOT NULL COMMENT '转出仓库id',
  `to_id` int(11) NOT NULL COMMENT '转入仓库id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of transfer_record
-- ----------------------------
INSERT INTO `transfer_record` VALUES (20, 2, 20);
INSERT INTO `transfer_record` VALUES (25, 24, 25);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `uname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名称',
  `authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '表示权限等级（游客/员工/审核员/仓管员/系统管理员）',
  `pwd` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户登录密码（数据库存储的是加密后的）',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `depository_id` int(11) NULL DEFAULT NULL COMMENT '负责仓库，序号表示仓库id，0表示全部仓库',
  `entry_date` date NOT NULL COMMENT '入职日期',
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '邮箱',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Dreamchaser追梦', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '男', -1, '2021-05-26', '767564319@qq.com', '13173812312');
INSERT INTO `user` VALUES (2, '张三', '仓管员', 'e10adc3949ba59abbe56e057f20f883e', '男', 1, '2021-05-19', '123456@qq.com', '13173812310');
INSERT INTO `user` VALUES (3, '外芯仓库负责人李四', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '1234567@qq.com', '12345678912');
INSERT INTO `user` VALUES (10, '外芯仓库负责人李五', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '12367@qq.com', '12345678912');
INSERT INTO `user` VALUES (11, '外芯仓库负责人李六', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '1@qq.com', '12345678912');
INSERT INTO `user` VALUES (12, '外芯仓库负责人李七', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '12@qq.com', '12345678912');
INSERT INTO `user` VALUES (13, '服装仓库-王五', '仓管员', 'e10adc3949ba59abbe56e057f20f883e', '男', 4, '2021-05-18', '123@qq.com', '12345678912');
INSERT INTO `user` VALUES (15, '赵六', '仓管员', 'e10adc3949ba59abbe56e057f20f883e', '女', 3, '2021-05-18', '12345@qq.com', '12345678912');
INSERT INTO `user` VALUES (17, '李八', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '12345678@qq.com', '12345678912');
INSERT INTO `user` VALUES (19, '李九', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '1234567899@qq.com', '12345678912');
INSERT INTO `user` VALUES (20, '李十', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '12345678998@qq.com', '12345678912');
INSERT INTO `user` VALUES (21, '李二', '审核人', 'e10adc3949ba59abbe56e057f20f883e', '男', 2, '2021-05-18', '123456789987@qq.com', '12345678912');
INSERT INTO `user` VALUES (22, '金昊霖', '游客', 'e10adc3949ba59abbe56e057f20f883e', '男', -1, '2021-06-14', '1234567f@qq.com', '12345678851');
INSERT INTO `user` VALUES (23, 'King', '系统管理员', 'e10adc3949ba59abbe56e057f20f883e', '男', 4, '2021-06-14', '123saf@qq.com', '12345678912');

SET FOREIGN_KEY_CHECKS = 1;
