/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : demo

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-08-30 15:48:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` decimal(10,2) DEFAULT '0.00',
  `picture` varchar(100) DEFAULT 'default.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'G7 中原G7三合一浓醇咖啡固体饮料1200', '66.50', 'd754a932-aced-444f-becc-9e44c3cf16cf.jpg');
INSERT INTO `goods` VALUES ('2', '百草味东北松子200gx2袋 坚果炒货零', '42.90', '76247bfd-3524-4e1b-98f3-748aae3088e0.jpg');
INSERT INTO `goods` VALUES ('3', '奈津香 桂圆干500gx2袋莆田特产5A桂', '39.90', '3.jpg');
INSERT INTO `goods` VALUES ('4', '益达尊享护齿装草本40粒+冰柠40粒+西', '25.90', '4.jpg');
INSERT INTO `goods` VALUES ('5', '猴坑茶业2016新茶原产地手工太平猴魁特', '168.00', '5.jpg');
INSERT INTO `goods` VALUES ('6', '嘻鱿记 休闲零食 麻辣香辣奶香炭烧 5种', '39.80', '6.jpg');
INSERT INTO `goods` VALUES ('7', '荣业鸿福五分瘦腊肠 香港土特产香肠腊味', '126.80', '7.jpg');
INSERT INTO `goods` VALUES ('8', '蓓琳娜（BELLINA）3L PDO特级初榨橄榄油', '178.00', '8.jpg');
INSERT INTO `goods` VALUES ('10', '荣业鸿福五分瘦腊肠 香港土特产香肠腊味', '30.60', 'b454b44f-868e-4efe-ae17-91e9e6a58390.jpg');
INSERT INTO `goods` VALUES ('29', '博微移动办公', '98.90', null);
INSERT INTO `goods` VALUES ('30', 'zhaolu3', '22.39', null);
INSERT INTO `goods` VALUES ('31', '微移动办公', '1.10', null);
INSERT INTO `goods` VALUES ('34', 'asdf撒地方3333', '333.00', null);
INSERT INTO `goods` VALUES ('35', '修改撒地方', '34.30', null);
INSERT INTO `goods` VALUES ('36', '999', '999.00', '99f95379-0780-4713-af44-9a4fc29bb4ba.jpg');
INSERT INTO `goods` VALUES ('37', 'sdfaa', '99.90', '1fbe242b-f6ce-433d-8e8d-1907d4f8a22d.jpg');
INSERT INTO `goods` VALUES ('38', '的订单', '111.00', 'efa38827-06af-49b1-a07f-d5eef48f7349.jpg');
