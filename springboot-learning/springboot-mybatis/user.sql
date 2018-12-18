/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50528
Source Host           : localhost:3306
Source Database       : ssm

Target Server Type    : MYSQL
Target Server Version : 50528
File Encoding         : 65001

Date: 2018-11-26 16:40:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ludeng', '21');
INSERT INTO `user` VALUES ('2', '33', '33');
INSERT INTO `user` VALUES ('3', '张三', '65');
INSERT INTO `user` VALUES ('4', '路灯', '23');
INSERT INTO `user` VALUES ('6', 'mixiu', '3');
INSERT INTO `user` VALUES ('8', '3', '35');
