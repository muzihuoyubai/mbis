/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : mbis

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-05 11:51:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_lecture
-- ----------------------------
DROP TABLE IF EXISTS `t_lecture`;
CREATE TABLE `t_lecture` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `lecture_name` varchar(60) NOT NULL COMMENT '课程名称',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleName` varchar(128) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `sex` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `cnname` varchar(60) NOT NULL COMMENT '学生姓名',
  `sex` int(4) DEFAULT NULL COMMENT '性别',
  `selfcard_no` int(20) DEFAULT NULL COMMENT '学生证号',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_health_female
-- ----------------------------
DROP TABLE IF EXISTS `t_student_health_female`;
CREATE TABLE `t_student_health_female` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `check_date` varchar(60) DEFAULT NULL COMMENT '检查日期',
  `heart` varchar(60) DEFAULT NULL COMMENT '心',
  `liver` varchar(60) DEFAULT NULL COMMENT '肝',
  `spleen` varchar(60) DEFAULT NULL COMMENT '脾',
  `lung` varchar(60) DEFAULT NULL COMMENT '肺',
  `kidney` varchar(60) DEFAULT NULL COMMENT '肾',
  `uterus` varchar(60) DEFAULT NULL COMMENT '子宫',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_health_male
-- ----------------------------
DROP TABLE IF EXISTS `t_student_health_male`;
CREATE TABLE `t_student_health_male` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `check_date` varchar(60) DEFAULT NULL COMMENT '检查日期',
  `heart` varchar(60) DEFAULT NULL COMMENT '心',
  `liver` varchar(60) DEFAULT NULL COMMENT '肝',
  `spleen` varchar(60) DEFAULT NULL COMMENT '脾',
  `lung` varchar(60) DEFAULT NULL COMMENT '肺',
  `kidney` varchar(60) DEFAULT NULL COMMENT '肾',
  `prostate` varchar(60) DEFAULT NULL COMMENT '前列腺',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_lecture
-- ----------------------------
DROP TABLE IF EXISTS `t_student_lecture`;
CREATE TABLE `t_student_lecture` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `lecture_id` int(20) DEFAULT NULL,
  `grade` decimal(16,2) DEFAULT NULL COMMENT '评分',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for t_student_selfcard
-- ----------------------------
DROP TABLE IF EXISTS `t_student_selfcard`;
CREATE TABLE `t_student_selfcard` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `student_id` int(20) DEFAULT NULL COMMENT '学生编号',
  `cnative` varchar(60) DEFAULT NULL COMMENT '籍贯',
  `issue_date` datetime DEFAULT NULL COMMENT '发证日期',
  `end_date` datetime DEFAULT NULL COMMENT '结束日期',
  `note` varchar(1024) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
