SET NAMES utf8;
START TRANSACTION;

CREATE DATABASE library;
USE library;
# 图书列表
CREATE TABLE `books`(
                        `bookID` INT NOT NULL AUTO_INCREMENT COMMENT '书id',
                        `bookName` VARCHAR(100) NOT NULL COMMENT '书名',
                        `bookCounts` INT NOT NULL COMMENT '数量',
                        `detail` VARCHAR(200) NOT NULL COMMENT '描述',
                        KEY `bookID`(`bookID`)
)ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `books`(`bookID`,`bookName`,`bookCounts`,`detail`)VALUES
(1,'Java',1,'从入门到放弃'),
(2,'MySQL',10,'从删库到跑路'),
(3,'Linux',0,'从进门到进牢'),
(4,'深入了解Java虚拟机',5,'看了也不会'),
(5,'C艹',2,'面向对象编程');

# 用户资料表
CREATE TABLE `admin` (
    `user_id` INT PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR ( 15 ) NOT NULL,
    `password` VARCHAR ( 15 ) DEFAULT NULL
) ENGINE = INNODB DEFAULT CHARSET = utf8;
INSERT INTO `admin`
VALUES
( 1,'admin','123456'),
( 2,'zhangsan',123),
( 3 ,'wangwu',456);

# 借书情况表
CREATE TABLE `borrow_list` (
    `borrow_id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `username` VARCHAR ( 15 ) NOT NULL,
    `bookName` VARCHAR(100) NOT NULL,
    `number` INT NOT NULL
)ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT INTO `borrow_list`
VALUES
(1,'zhangsan','Linux',5);

COMMIT;
