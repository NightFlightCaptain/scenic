/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost:3306
 Source Schema         : travel

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : 65001

 Date: 16/11/2019 21:04:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for essay
-- ----------------------------
DROP TABLE IF EXISTS `essay`;
CREATE TABLE `essay`  (
  `essay_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classify` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'others',
  `tag` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT 'journey',
  `author_id` int(11) NOT NULL,
  `author_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_url` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `create_time` datetime(0) DEFAULT NULL,
  `page_view` bigint(20) DEFAULT 0,
  `great_num` bigint(20) DEFAULT 0,
  `content` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`essay_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1000 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of essay
-- ----------------------------
INSERT INTO `essay` VALUES (9, '昙华林', 'others', 'journey', 1011, 'xiao li', NULL, '2019-11-16 12:19:52', 0, 1, '昙华林是一个好地方');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `user_account` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `head_img_addr` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gender` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `signature` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `wx_code` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `user_account`(`user_account`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 100 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '姜', '1', '123456', 'jianging', '女', '1', NULL);

-- ----------------------------
-- Table structure for user_essay_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_essay_collection`;
CREATE TABLE `user_essay_collection`  (
  `user_id` int(11) DEFAULT NULL,
  `essay_id` bigint(20) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_essay_collection
-- ----------------------------
INSERT INTO `user_essay_collection` VALUES (1, 9);

-- ----------------------------
-- Table structure for user_essay_great
-- ----------------------------
DROP TABLE IF EXISTS `user_essay_great`;
CREATE TABLE `user_essay_great`  (
  `user_id` int(11) DEFAULT NULL,
  `essay_id` bigint(20) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_essay_great
-- ----------------------------
INSERT INTO `user_essay_great` VALUES (1, 9);

-- ----------------------------
-- Table structure for user_view
-- ----------------------------
DROP TABLE IF EXISTS `user_view`;
CREATE TABLE `user_view`  (
  `user_id` int(11) DEFAULT NULL,
  `view_id` bigint(20) DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for view
-- ----------------------------
DROP TABLE IF EXISTS `view`;
CREATE TABLE `view`  (
  `view_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `classify` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT 'others',
  `view_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `location` varchar(256) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `opentime` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `introducation` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`view_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of view
-- ----------------------------
INSERT INTO `view` VALUES (1, '名胜古迹', '黄鹤楼', '114.306344,30.542289', '早上8：00-晚上5：00', '黄鹤楼介绍');

SET FOREIGN_KEY_CHECKS = 1;
