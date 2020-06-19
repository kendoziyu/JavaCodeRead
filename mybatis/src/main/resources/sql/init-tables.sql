/**
 * 这里的SQL初始化了需要用的数据库及表
 */
 CREATE DATABASE IF NOT EXISTS test DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS `blog` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `title` VARCHAR(255) NOT NULL,
    `body` VARCHAR(2048) NOT NULL,
    `author_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS `user` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `age` VARCHAR(20) NOT NULL,
    `sex` VARCHAR(20) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `phone_number` VARCHAR(30) NOT NULL,
    `add_time` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

CREATE TABLE IF NOT EXISTS `comment` (
    `id` VARCHAR(100) NOT NULL,
    `body` VARCHAR(255) NOT NULL,
    `user_id` INT(11) NOT NULL,
    `blog_id` INT(11) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

