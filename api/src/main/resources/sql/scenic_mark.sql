/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : scenic_mark

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-10-29 10:24:29
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `content` text COMMENT '内容',
  `publish_time` datetime NOT NULL COMMENT '发布时间',
  `score` int(11) DEFAULT NULL COMMENT '打分',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论表，某用户对某景点的评论与打分';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for main_trip
-- ----------------------------
DROP TABLE IF EXISTS `main_trip`;
CREATE TABLE `main_trip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sum_day` int(2) DEFAULT NULL COMMENT '总计天数',
  `count` int(11) NOT NULL DEFAULT '0' COMMENT '使用次数/热度',
  `name` varchar(255) DEFAULT NULL COMMENT '行程名',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='总行程表，一个总行程包括1个或多个单日行程。有多少个单日行程就是需要耗时多少天，总行程可以预设被用户直接选择。也可以由用户自己创建行程';

-- ----------------------------
-- Records of main_trip
-- ----------------------------
INSERT INTO `main_trip` VALUES ('1', '1', '1', '红色景点一日游', '0');
INSERT INTO `main_trip` VALUES ('8', '2', '0', '两日游', '0');

-- ----------------------------
-- Table structure for mark
-- ----------------------------
DROP TABLE IF EXISTS `mark`;
CREATE TABLE `mark` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `mark_date` date NOT NULL COMMENT '打卡时间',
  `order_rank` int(11) DEFAULT NULL COMMENT '打卡名次',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='打卡表，rank表示第几位打卡用户';

-- ----------------------------
-- Records of mark
-- ----------------------------
INSERT INTO `mark` VALUES ('1', '1', '1', '2019-10-26', null, '0');


-- ----------------------------
-- Table structure for picture
-- ----------------------------
DROP TABLE IF EXISTS `picture`;
CREATE TABLE `picture` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_deleted` tinyint(1) DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='图片表，url存储图片路径，type暂无用';

-- ----------------------------
-- Records of picture
-- ----------------------------
INSERT INTO `picture` VALUES ('1', 'https://p1.meituan.net/hoteltdc/96010fa1983fe7ddb9d10fbb6ffcb0cc4545002.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('2', 'https://p0.meituan.net/hotel/f41eb51111a36522e3dd6b4d9b379657120280.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('3', 'https://p1.meituan.net/hotel/b9d10a33f3ba1e64c7ab62e8d46043e7105341.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('4', 'https://p0.meituan.net/travel/6e1a163e6e4c4ef73c55167375e7692e470407.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('5', 'https://p1.meituan.net/travel/8ad946cfa1ff9c0d658cddce0873d99351442.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('6', 'https://p1.meituan.net/hotel/83c43edb63f9b80f541f8f089389f65c487545.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('7', 'https://p1.meituan.net/travel/e8735a3dbd1f6f81f1baefd2f242dbb4274246.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('8', 'https://p1.meituan.net/hotel/fcc05ec1902cbf21f2cf8e0629c61612816417.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('9', 'https://p0.meituan.net/hotel/d470cddd9b375a8078b0231c26bd9bd5409371.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('10', 'https://p0.meituan.net/travel/d538e3f27249955a02ad9d1add2d9b5e94423.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('11', 'https://p1.meituan.net/travel/46c51646e9f2d812a3b078f463ddbc9f583657.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('12', 'https://p1.meituan.net/hotel/5933a78c3bc0c5f7009ac8f9c86b9ddf536026.png.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('13', 'https://p0.meituan.net/hoteltdc/d030852238ac94cfac19ae4f57e41880660522.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('14', 'https://p0.meituan.net/hoteltdc/300f140b0564b3b0e2a9a78c23bd89df546977.jpg.webp@60q_1l_175w', null, '0');
INSERT INTO `picture` VALUES ('15', 'https://p1.meituan.net/travel/c5e41e6e751f423c4fdb8e0c6576ded1167689.jpg.webp@60q_1l_175w', null, '0');

-- ----------------------------
-- Table structure for picture_scenic
-- ----------------------------
DROP TABLE IF EXISTS `picture_scenic`;
CREATE TABLE `picture_scenic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture_id` int(11) NOT NULL COMMENT '图片id',
  `scenic_id` int(11) NOT NULL COMMENT '景点id',
  `is_major` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否首要展示图',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='某张图片归属于某个景点，每个景点只有一张展示图';

-- ----------------------------
-- Records of picture_scenic
-- ----------------------------
INSERT INTO `picture_scenic` VALUES ('1', '1', '1', '1', '0');
INSERT INTO `picture_scenic` VALUES ('2', '2', '2', '1', '0');
INSERT INTO `picture_scenic` VALUES ('3', '3', '3', '1', '0');
INSERT INTO `picture_scenic` VALUES ('4', '4', '4', '1', '0');
INSERT INTO `picture_scenic` VALUES ('5', '5', '5', '1', '0');
INSERT INTO `picture_scenic` VALUES ('6', '6', '6', '1', '0');
INSERT INTO `picture_scenic` VALUES ('7', '7', '7', '1', '0');
INSERT INTO `picture_scenic` VALUES ('8', '8', '8', '1', '0');
INSERT INTO `picture_scenic` VALUES ('9', '9', '9', '1', '0');
INSERT INTO `picture_scenic` VALUES ('10', '10', '10', '1', '0');
INSERT INTO `picture_scenic` VALUES ('11', '11', '11', '1', '0');
INSERT INTO `picture_scenic` VALUES ('12', '12', '12', '1', '0');
INSERT INTO `picture_scenic` VALUES ('13', '13', '13', '1', '0');
INSERT INTO `picture_scenic` VALUES ('14', '14', '14', '1', '0');
INSERT INTO `picture_scenic` VALUES ('15', '15', '15', '1', '0');

-- ----------------------------
-- Table structure for scenic
-- ----------------------------
DROP TABLE IF EXISTS `scenic`;
CREATE TABLE `scenic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL COMMENT '名称',
  `introduction` varchar(255) DEFAULT NULL COMMENT '介绍',
  `open_time` varchar(50) DEFAULT NULL COMMENT '开放时间',
  `price` decimal(10,2) DEFAULT NULL COMMENT '门票价格',
  `suggested_time` varchar(255) DEFAULT NULL COMMENT '建议游玩时间',
  `longitude` decimal(10,7) NOT NULL COMMENT '经度',
  `latitude` decimal(10,7) NOT NULL COMMENT '维度',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `phone` char(11) DEFAULT NULL COMMENT '电话',
  `score` int(11) DEFAULT NULL COMMENT '评分',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of scenic
-- ----------------------------
INSERT INTO `scenic` VALUES ('1', '辛亥革命武昌起义纪念馆', '武昌起义后军政府的所在地', '早上8：00-晚上5：00', '39.00', '2小时', '114.3063760', '30.5421810', '辛亥革命武昌起义纪念馆', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('2', '刘少奇故居', '刘少奇在武汉从事革命活动时的住房', '早上8：00-晚上5：00', '39.00', '2小时', '114.2956610', '30.5913600', '刘少奇故居', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('3', '姚家山旅游风景区', '群山起伏，地势险要', '早上8：00-晚上5：00', '39.00', '2小时', '114.1946350', '31.2489580', '姚家山旅游风景区', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('4', '辛亥革命博物馆', '是武汉市为纪念辛亥革命·武昌首义100周年而兴建的一座专题博物馆', '早上8：00-晚上5：00', '39.00', '2小时', '114.3054470', '30.5366710', '辛亥革命博物馆', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('5', '毛泽东同志旧居', '这里成为进行革命传统教育的重要基地，也成为吸引海内外游客的著名景点', '早上8：00-晚上5：00', '39.00', '2小时', '114.2993600', '30.5510700', '毛泽东同志旧居', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('6', '武汉革命博物馆', '典藏武汉红色文化，展示革命风采', '早上8：00-晚上5：00', '39.00', '2小时', '114.3004280', '30.5538070', '武汉革命博物馆', '13063254952', '5', '0');
INSERT INTO `scenic` VALUES ('7', '首义广场', '辛亥革命第一枪打响的地方', '早上8：00-晚上5：00', '39.00', '2小时', '114.3054980', '30.5374150', '首义广场', '13063254952', '5', '0');
INSERT INTO `scenic` VALUES ('8', '辛亥革命纪念园', '具有纪念意义的专题纪念馆', '早上8：00-晚上5：00', '39.00', '2小时', '114.4782510', '30.5142080', '辛亥革命纪念园', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('9', '黄冈天台山景区', '佛宗道源，山水灵秀，红色圣山', '早上8：00-晚上5：00', '39.00', '2小时', '114.6476530', '31.4864680', '黄冈天台山景区', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('10', '八七会议会址纪念馆', '全国重点文物保护单位。', '早上8：00-晚上5：00', '39.00', '2小时', '114.2998400', '30.5865960', '八七会议会址纪念馆', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('11', '中共中央机关旧址纪念馆', '中华人民共和国烈士纪念日', '早上8：00-晚上5：00', '39.00', '2小时', '114.2986300', '30.5878880', '中共中央机关旧址纪念馆', '13063254952', '5', '0');
INSERT INTO `scenic` VALUES ('12', '黄麻起义和鄂豫皖苏区纪念园', '为纪念黄麻起义和鄂豫皖苏区在革命斗争中牺牲的烈士而建', '早上8：00-晚上5：00', '39.00', '2小时', '114.6249180', '31.2891260', '黄麻起义和鄂豫皖苏区纪念园', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('13', '八路军武汉办事处旧址纪念馆', '中共领导人在这里工作', '早上8：00-晚上5：00', '39.00', '2小时', '114.3095400', '30.6062180', '八路军武汉办事处旧址纪念馆', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('14', '施洋烈士陵园', '是您参观游览好去处', '早上8：00-晚上5：00', '39.00', '2小时', '114.3363100', '30.5325050', '施洋烈士陵园', '13063254952', '4', '0');
INSERT INTO `scenic` VALUES ('15', '汉口辛亥首义烈士陵园', '陵园树木常青，庄严肃穆，缅怀前人。', '早上8：00-晚上5：00', '39.00', '2小时', '114.2942920', '30.5976150', '汉口辛亥首义烈士陵园', '13063254952', '4', '0');

-- ----------------------------
-- Table structure for single_trip
-- ----------------------------
DROP TABLE IF EXISTS `single_trip`;
CREATE TABLE `single_trip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `main_trip_id` int(11) NOT NULL COMMENT '主行程',
  `scenic_order` varchar(255) NOT NULL COMMENT '景点路线',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='单日行程表，属于一个总行程，景点按照id顺序连成一个字符串表示游览顺序';

-- ----------------------------
-- Records of single_trip
-- ----------------------------
INSERT INTO `single_trip` VALUES ('1', '1', '1', '0');
INSERT INTO `single_trip` VALUES ('16', '8', '1', '0');
INSERT INTO `single_trip` VALUES ('17', '8', '2,3', '0');

-- ----------------------------
-- Table structure for trip
-- ----------------------------
DROP TABLE IF EXISTS `trip`;
CREATE TABLE `trip` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户',
  `main_trip_id` int(11) DEFAULT NULL COMMENT '路线id',
  `start_date` date DEFAULT NULL COMMENT '开始时间',
  `end_date` date DEFAULT NULL COMMENT '结束时间',
  `is_deleted` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户行程表';

-- ----------------------------
-- Records of trip
-- ----------------------------
INSERT INTO `trip` VALUES ('1', '1', '1', null, null, '0');
INSERT INTO `trip` VALUES ('3', '1', '8', null, null, '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL COMMENT '账号',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `telephone` char(11) DEFAULT NULL COMMENT '电话',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `sex` char(2) DEFAULT NULL COMMENT '性别',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `head_portrait` varchar(50) DEFAULT NULL COMMENT '头像',
  `solt` varchar(255) DEFAULT NULL COMMENT '密钥',
  `is_deleted` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'normal', 'normal', 'E7021DC88F9006DBFA67E2D5D33B297B', null, null, null, null, null, '1f900', '0');
INSERT INTO `user` VALUES ('2', 'normal2', 'normal', 'AED685514996CF5C8B2F03CC41925CEB', null, null, null, null, null, '2058e', '0');
