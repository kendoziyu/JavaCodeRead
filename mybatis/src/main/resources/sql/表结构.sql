/*
 Navicat Premium Data Transfer

 Source Server         : root_47.99
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : 47.99.214.246:3899
 Source Schema         : luban2

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 09/05/2020 09:56:50
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `age` int(3) DEFAULT NULL,
  `sex` enum('男','女') COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone_number` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `greetings`;
CREATE TABLE `greetings` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `words` VARCHAR(255) COLLATE utf8_bin NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

DROP TABLE IF EXISTS `blog`;
CREATE TABLE `blog` (
    `blog_id` INT(11) NOT NULL AUTO_INCREMENT,
    `blog_name` VARCHAR(255) COLLATE utf8_bin NOT NULL,
    `blog_state` INT(1) NOT NULL DEFAULT 0,
    `add_time` TIMESTAMP NOT NULL,
    `update_time` TIMESTAMP NULL,
    PRIMARY KEY (`blog_id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;