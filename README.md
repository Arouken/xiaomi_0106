# xiaomi_0106
学习用 仿小米商城
只有用户，管理员，商品的增删改查
MySQL
java
jQuery
Ajax

CREATE TABLE `category` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(60) NOT NULL,
  `state` int(11) NOT NULL,
  `order_num` int(11) NOT NULL,
  `description` varchar(200) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`cid`),
  UNIQUE KEY `cname` (`cname`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8


CREATE TABLE `commodity` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cate_id` int(11) NOT NULL,
  `cname` varchar(60) NOT NULL,
  `color` varchar(30) NOT NULL,
  `size` varchar(50) NOT NULL,
  `price` double NOT NULL,
  `short_desc` varchar(100) NOT NULL,
  `full_desc` varchar(200) NOT NULL,
  `photo` varchar(50) NOT NULL,
  `ctype` int(11) NOT NULL,
  `model` varchar(60) NOT NULL,
  `create_date` date NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8

CREATE TABLE `users` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(30) CHARACTER SET utf8 NOT NULL,
  `gender` int(11) DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `address` varchar(30) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8 NOT NULL,
  `userpwd` varchar(20) CHARACTER SET utf8 NOT NULL,
  `photo` varchar(150) CHARACTER SET utf8 DEFAULT NULL,
  `manager` int(11) NOT NULL DEFAULT '0',
  `create_date` date DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `phone` (`phone`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_icelandic_ci
