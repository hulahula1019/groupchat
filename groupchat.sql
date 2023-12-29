/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : groupchat

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 27/12/2023 18:26:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for imgroup
-- ----------------------------
DROP TABLE IF EXISTS `imgroup`;
CREATE TABLE `imgroup`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '内容',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '用户名',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '时间',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 27 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '群组聊天表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of imgroup
-- ----------------------------
INSERT INTO `imgroup` VALUES (27, '大家晚上好！', '流泪猫猫头', 'http://localhost:8080/files/1703604028629-流泪猫猫头.jpg', '2023-12-26 23:42:35', 'text');
INSERT INTO `imgroup` VALUES (28, '😀', '流泪猫猫头', 'http://localhost:8080/files/1703604028629-流泪猫猫头.jpg', '2023-12-26 23:42:38', 'text');
INSERT INTO `imgroup` VALUES (29, '你好呀', '今晚吃什么', 'http://localhost:8080/files/1703604271545-今晚吃什么.jpg', '2023-12-26 23:42:47', 'text');
INSERT INTO `imgroup` VALUES (30, '所以你今晚吃了什么', '最爱喝AD钙奶', 'http://localhost:8080/files/1703604987009-最爱喝AD钙奶.jpg', '2023-12-26 23:42:56', 'text');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '姓名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '性别',
  `age` int NULL DEFAULT NULL COMMENT '年龄',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '电话',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 46 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = '用户信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (46, '流泪猫猫头', '123456', '女', 25, '18899991111', 'http://localhost:8080/files/1703604028629-流泪猫猫头.jpg');
INSERT INTO `user` VALUES (47, '今晚吃什么', '123456', '女', 25, '18899992222', 'http://localhost:8080/files/1703604271545-今晚吃什么.jpg');
INSERT INTO `user` VALUES (48, '骰子第七面', '123456', '男', 20, '18899993333', 'http://localhost:8080/files/qy-default.png');
INSERT INTO `user` VALUES (49, '最爱喝AD钙奶', '123456', '女', 21, '18899994444', 'http://localhost:8080/files/1703604987009-最爱喝AD钙奶.jpg');
INSERT INTO `user` VALUES (50, '颓废烤肉', '123456', '男', 26, '18899995555', 'http://localhost:8080/files/qy-default.png');
INSERT INTO `user` VALUES (51, '伤脑筋哦', '123456', '男', 22, '18899996666', 'http://localhost:8080/files/1703605087201-伤脑筋哦.jpg');
INSERT INTO `user` VALUES (52, '鸭鸭我呀', '123456', '女', 19, '18899997777', 'http://localhost:8080/files/1703605117286-鸭鸭我呀.jpg');
INSERT INTO `user` VALUES (53, '墨西哥肉卷', '123456', '女', 23, '18899998888', 'http://localhost:8080/files/1703605134679-墨西哥肉卷.jpg');
INSERT INTO `user` VALUES (54, '朱朱吉吉', '123456', '女', 23, '18899999999', 'http://localhost:8080/files/1703605173189-朱朱吉吉.jpg');
INSERT INTO `user` VALUES (55, '躺下去的小狗', '123456', '男', 22, '18899990000', 'http://localhost:8080/files/1703605204420-躺下去的小狗.jpg');

SET FOREIGN_KEY_CHECKS = 1;
