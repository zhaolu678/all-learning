SSM框架整合（Spring+SpringMVC+MyBatis）
http://localhost:8080/ssm/

商品管理系统增删改查
重点：
1.ssm整合（引包，web.xml,applicationContext.xml,mybatisconfig.xml）
2.图片上传
3.分页
4.tomcat设置虚拟路径

-------------------初始化SQL：
SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `goods`
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` decimal(10,2) DEFAULT '0.00',
  `picture` varchar(100) DEFAULT 'default.jpg',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'G7 中原G7三合一浓醇咖啡固体饮料1200', '66.50', '1.jpg');
INSERT INTO `goods` VALUES ('2', '百草味东北松子200gx2袋 坚果炒货零', '42.90', '2.jpg');
INSERT INTO `goods` VALUES ('3', '奈津香 桂圆干500gx2袋莆田特产5A桂', '39.90', '3.jpg');
INSERT INTO `goods` VALUES ('4', '益达尊享护齿装草本40粒+冰柠40粒+西', '25.90', '4.jpg');
INSERT INTO `goods` VALUES ('5', '猴坑茶业2016新茶原产地手工太平猴魁特', '168.00', '5.jpg');
INSERT INTO `goods` VALUES ('6', '嘻鱿记 休闲零食 麻辣香辣奶香炭烧 5种', '39.80', '6.jpg');
INSERT INTO `goods` VALUES ('7', '荣业鸿福五分瘦腊肠 香港土特产香肠腊味', '126.80', '7.jpg');
INSERT INTO `goods` VALUES ('8', '蓓琳娜（BELLINA）3L PDO特级初榨橄榄油', '178.00', '8.jpg');
INSERT INTO `goods` VALUES ('10', '荣业鸿福五分瘦腊肠 香港土特产香肠腊味', '30.60', 'b454b44f-868e-4efe-ae17-91e9e6a58390.jpg');
-----------------------------------------


参考： http://www.cnblogs.com/best/p/5688040.html




