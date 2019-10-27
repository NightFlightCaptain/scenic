/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : scenic_mark

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 27/10/2019 13:45:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '内容',
  `publish_time` datetime(0) NOT NULL COMMENT '发布时间',
  `score` int(11) DEFAULT NULL COMMENT '打分',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '评论表，某用户对某景点的评论与打分' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for main_trip
-- ----------------------------
DROP TABLE IF EXISTS `main_trip`;
CREATE TABLE `main_trip`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sum_day` int(2) DEFAULT NULL COMMENT '总计天数',
  `count` int(11) NOT NULL DEFAULT 0 COMMENT '使用次数/热度',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '行程名',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '总行程表，一个总行程包括1个或多个单日行程。有多少个单日行程就是需要耗时多少天，总行程可以预设被用户直接选择。也可以由用户自己创建行程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of main_trip
-- ----------------------------
INSERT INTO `main_trip` VALUES (1, 1, 1, '红色景点一日游', 0);
INSERT INTO `main_trip` VALUES (8, 2, 0, '两日游', 0);

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `mark_date` date NOT NULL COMMENT '打卡时间',
  `order_rank` int(11) DEFAULT NULL COMMENT '打卡名次',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '打卡表，rank表示第几位打卡用户' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES (1, 1, 1, '2019-10-26', NULL, 0);

-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '图片表，url存储图片路径，type暂无用' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES (1, 'http://store.is.autonavi.com/showpic/4dbd4c716c2a5462b9b53dac8e05f43c', NULL, 0);
INSERT INTO `picture` VALUES (2, 'http://store.is.autonavi.com/showpic/47473d2a279548fd9b96bc79b869082f', NULL, 0);
INSERT INTO `picture` VALUES (3, 'http://store.is.autonavi.com/showpic/e88011d8219a82bb611d0092dc0d9b5d', NULL, 0);

-- ----------------------------
-- Table structure for picture_scenic
-- ----------------------------
DROP TABLE IF EXISTS `picture_scenic`;
CREATE TABLE `picture_scenic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture_id` int(11) NOT NULL COMMENT '图片id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `is_major` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否首要展示图',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '某张图片归属于某个景点，每个景点只有一张展示图' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of picture_scenic
-- ----------------------------
INSERT INTO `picture_scenic` VALUES (1, 1, 1, 1, 0);
INSERT INTO `picture_scenic` VALUES (2, 2, 2, 1, 0);
INSERT INTO `picture_scenic` VALUES (3, 3, 3, 1, 0);

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '名称',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '介绍',
  `open_time` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '开放时间',
  `price` decimal(10, 2) DEFAULT NULL COMMENT '门票价格',
  `suggested_time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '建议游玩时间',
  `longitude` decimal(10, 7) NOT NULL COMMENT '经度',
  `latitude` decimal(10, 7) NOT NULL COMMENT '维度',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `phone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `score` int(11) DEFAULT NULL COMMENT '评分',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES (1, '辛亥革命武昌起义纪念馆', '辛亥革命武昌起义纪念馆', '早上8：00-晚上5：00', 20.00, '1小时', 114.3063440, 30.5422890, NULL, NULL, NULL, 0);
INSERT INTO `scenic` VALUES (2, '八路军武汉办事处旧址纪念馆1层', '八路军武汉办事处旧址纪念馆1层', '早上8：00-晚上5：00', 20.00, '2小时', 114.3094030, 30.6061520, NULL, NULL, NULL, 0);
INSERT INTO `scenic` VALUES (3, '新跃石门峰名人公园武汉抗战纪念园', '新跃石门峰名人公园武汉抗战纪念园', '早上8：00-晚上5：00', 20.00, '3小时', 114.4802630, 30.5149970, NULL, NULL, NULL, 0);

-- ----------------------------
-- Table structure for single_trip
-- ----------------------------
DROP TABLE IF EXISTS `single_trip`;
CREATE TABLE `single_trip`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_trip_id` int(11) NOT NULL COMMENT '主行程',
  `scenic_order` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '景点路线',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '单日行程表，属于一个总行程，景点按照id顺序连成一个字符串表示游览顺序' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of single_trip
-- ----------------------------
INSERT INTO `single_trip` VALUES (1, 1, '1', 0);
INSERT INTO `single_trip` VALUES (16, 8, '1', 0);
INSERT INTO `single_trip` VALUES (17, 8, '2,3', 0);

-- ----------------------------
-- Table structure for trip
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `main_trip_id` int(11) DEFAULT NULL COMMENT '路线id',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `is_deleted` tinyint(1) UNSIGNED ZEROFILL NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户行程表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of trip
-- ----------------------------
INSERT INTO `trip` VALUES (1, 1, 1, NULL, NULL, 0);
INSERT INTO `trip` VALUES (3, 1, 8, NULL, NULL, 0);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `telephone` char(11) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电话',
  `email` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮箱',
  `sex` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `head_portrait` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `solt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密钥',
  `is_deleted` tinyint(1) NOT NULL DEFAULT 0 COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'normal', 'normal', 'E7021DC88F9006DBFA67E2D5D33B297B', NULL, NULL, NULL, NULL, NULL, '1f900', 0);
INSERT INTO `user` VALUES (2, 'normal2', 'normal', 'AED685514996CF5C8B2F03CC41925CEB', NULL, NULL, NULL, NULL, NULL, '2058e', 0);

SET FOREIGN_KEY_CHECKS = 1;
