/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : leecx

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-09-19 20:33:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for data_dict
-- ----------------------------
DROP TABLE IF EXISTS `data_dict`;
CREATE TABLE `data_dict` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type_name` varchar(64) NOT NULL COMMENT '数据字典类型名称',
  `type_code` varchar(64) DEFAULT NULL COMMENT '数据字典类型代码',
  `ddkey` varchar(6) NOT NULL COMMENT '数据键',
  `ddvalue` varchar(12) NOT NULL COMMENT '数据值',
  `is_show` int(1) NOT NULL COMMENT '是否显示，1：显示；2：不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COMMENT='数据字典表';

-- ----------------------------
-- Records of data_dict
-- ----------------------------
INSERT INTO `data_dict` VALUES ('1', '性别', 'sex', '0', '女', '1');
INSERT INTO `data_dict` VALUES ('2', '性别', 'sex', '1', '男', '1');
INSERT INTO `data_dict` VALUES ('3', '性别', 'sex', '2', '保密', '1');
INSERT INTO `data_dict` VALUES ('4', '汽车类型', 'carType', '2', '公交车', '1');
INSERT INTO `data_dict` VALUES ('5', '汽车类型', 'carType', '1', '轿车', '1');
INSERT INTO `data_dict` VALUES ('6', '职业', 'job', '1', 'Java开发', '1');
INSERT INTO `data_dict` VALUES ('7', '职业', 'job', '2', '前端开发', '1');
INSERT INTO `data_dict` VALUES ('8', '职业', 'job', '3', '大数据开发', '1');
INSERT INTO `data_dict` VALUES ('9', '职业', 'job', '4', 'ios开发', '1');
INSERT INTO `data_dict` VALUES ('10', '职业', 'job', '5', 'Android开发', '1');
INSERT INTO `data_dict` VALUES ('11', '职业', 'job', '6', 'Linux系统工程师', '1');
INSERT INTO `data_dict` VALUES ('12', '职业', 'job', '7', 'PHP开发', '1');
INSERT INTO `data_dict` VALUES ('13', '职业', 'job', '8', '.net开发', '1');
INSERT INTO `data_dict` VALUES ('14', '职业', 'job', '9', 'C/C++', '1');
INSERT INTO `data_dict` VALUES ('15', '职业', 'job', '10', '学生', '0');
INSERT INTO `data_dict` VALUES ('16', '职业', 'job', '11', '其它', '1');
INSERT INTO `data_dict` VALUES ('17', '职业', 'job', '12', '全栈牛逼架构师', '1');
INSERT INTO `data_dict` VALUES ('18', '汽车类型', 'carType', '3', '海陆两用', '1');

-- ----------------------------
-- Table structure for demo_item
-- ----------------------------
DROP TABLE IF EXISTS `demo_item`;
CREATE TABLE `demo_item` (
  `id` varchar(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `amount` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of demo_item
-- ----------------------------
INSERT INTO `demo_item` VALUES ('170909FRA2NB7TR4', '红翼 red wing', '215000');
INSERT INTO `demo_item` VALUES ('170909FRB9DPXY5P', '红翼 9111', '210000');
INSERT INTO `demo_item` VALUES ('170909FRCAT15XGC', '红翼 875', '215000');
INSERT INTO `demo_item` VALUES ('170909FRF2P18ARP', 'cat', '185000');
INSERT INTO `demo_item` VALUES ('170909FRG6R75PZC', 'dog', '195000');
INSERT INTO `demo_item` VALUES ('170909FRHBS3K680', '马丁靴', '150000');
INSERT INTO `demo_item` VALUES ('170909FRPWA5HCPH', '天木兰 经典 船鞋', '65000');
INSERT INTO `demo_item` VALUES ('170909FRS6SBHH00', '天木兰 踢不烂', '65000');
INSERT INTO `demo_item` VALUES ('170909FRX22HKCDP', '其乐 袋鼠靴', '70000');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL COMMENT '用户名，登录名',
  `password` varchar(64) NOT NULL COMMENT '密码',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `age` int(3) DEFAULT NULL COMMENT '年龄',
  `sex` int(1) DEFAULT NULL COMMENT '性别\r\n0：女\r\n1：男\r\n2：保密 ',
  `job` int(10) DEFAULT NULL COMMENT '职业类型：\r\n1：Java开发\r\n2：前端开发\r\n3：大数据开发\r\n4：ios开发\r\n5：Android开发\r\n6：Linux系统工程师\r\n7：PHP开发\r\n8：.net开发\r\n9：C/C++\r\n10：学生\r\n11：其它',
  `face_image` varchar(255) DEFAULT NULL COMMENT '头像地址',
  `province` varchar(12) DEFAULT NULL COMMENT '省',
  `city` varchar(12) DEFAULT NULL COMMENT '市',
  `district` varchar(12) DEFAULT NULL COMMENT '区',
  `address` varchar(128) DEFAULT NULL COMMENT '详细地址',
  `auth_salt` varchar(16) DEFAULT NULL COMMENT '用于权限的“盐”',
  `last_login_ip` varchar(20) DEFAULT NULL COMMENT '最后一次登录IP',
  `last_login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `is_delete` int(1) NOT NULL,
  `regist_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='系统后台用户';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1709067GM45GAF5P', 'test0012', '123456', 'test001', '22', '0', '3', null, '上海市', '上海市市辖区', '静安区', '上海老薛', 'ZnjE', null, null, '0', '2017-09-06 10:35:28');
INSERT INTO `sys_user` VALUES ('1709077CW608DP00', 'lee', 'lee111', 'lee', '18', '1', '1', null, '湖北省', '武汉市', '江岸区', '111', '2ozb', null, null, '1', '2017-09-07 10:27:07');
INSERT INTO `sys_user` VALUES ('170908G65M59XWH0', 'test003', '888888', 'test003', '20', '0', '3', null, '上海市', '上海市市辖区', '黄浦区', '老薛家', 'tx5D', null, null, '1', '2017-09-08 21:19:40');
INSERT INTO `sys_user` VALUES ('170918GDXW2DNP4H', 'test001', 'test001', 'test0016', '18', '1', '9', null, '湖北省', '鄂州市', '华容区', '123', 'W5k4', null, null, '0', '2017-09-18 21:42:51');
