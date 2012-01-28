/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50150
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50150
File Encoding         : 65001

Date: 2011-11-14 21:41:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `demo`
-- ----------------------------
DROP TABLE IF EXISTS `demo`;
CREATE TABLE `demo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `publishdate` datetime DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of demo
-- ----------------------------
INSERT INTO demo VALUES ('1', 'HTTP://WWW.CHINASB.ORG', '2011-11-14 21:39:10', 'Chinasb');
INSERT INTO demo VALUES ('2', 'HTTP://WWW.ITEYE.COM', '2011-11-14 21:39:35', 'ITEYE');
INSERT INTO demo VALUES ('3', 'HTTP://APP.CHINASB.ORG', '2011-11-14 21:40:25', 'Google App Engine');
