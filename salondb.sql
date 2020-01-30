/*
Navicat MySQL Data Transfer

Source Server         : UAT-Localhost
Source Server Version : 80012
Source Host           : localhost:3306
Source Database       : salondb

Target Server Type    : MYSQL
Target Server Version : 80012
File Encoding         : 65001

Date: 2020-01-29 18:54:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for category_master
-- ----------------------------
DROP TABLE IF EXISTS `category_master`;
CREATE TABLE `category_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of category_master
-- ----------------------------

-- ----------------------------
-- Table structure for salon_master
-- ----------------------------
DROP TABLE IF EXISTS `salon_master`;
CREATE TABLE `salon_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `salon_name` varchar(30) NOT NULL,
  `users_pk` int(11) DEFAULT NULL,
  `address` text,
  `contact1` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact2` varchar(15) DEFAULT NULL,
  `description` text,
  `home_service_flag` tinyint(2) DEFAULT '0',
  `active_deactive` tinyint(4) DEFAULT '0',
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL,
  `salon_type` tinyint(11) NOT NULL DEFAULT '1',
  PRIMARY KEY (`pk`),
  UNIQUE KEY `unique_constr_1` (`contact1`) USING BTREE,
  KEY `fk4` (`users_pk`),
  CONSTRAINT `fk4` FOREIGN KEY (`users_pk`) REFERENCES `users` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salon_master
-- ----------------------------

-- ----------------------------
-- Table structure for salon_service_mapping
-- ----------------------------
DROP TABLE IF EXISTS `salon_service_mapping`;
CREATE TABLE `salon_service_mapping` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `salon_master_pk` int(11) NOT NULL,
  `service_master_pk` int(11) NOT NULL,
  `service_cost` int(11) NOT NULL,
  `home_service_flag` tinyint(4) NOT NULL DEFAULT '0',
  `active_deactive` tinyint(4) DEFAULT '1',
  PRIMARY KEY (`pk`),
  KEY `fk1` (`salon_master_pk`) USING BTREE,
  KEY `fk2` (`service_master_pk`) USING BTREE,
  CONSTRAINT `fk1` FOREIGN KEY (`salon_master_pk`) REFERENCES `salon_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk2` FOREIGN KEY (`service_master_pk`) REFERENCES `service_master` (`pk`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of salon_service_mapping
-- ----------------------------

-- ----------------------------
-- Table structure for service_master
-- ----------------------------
DROP TABLE IF EXISTS `service_master`;
CREATE TABLE `service_master` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `service_name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `description` text,
  `image_path` varchar(255) DEFAULT NULL,
  `category_master_pk` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk5` (`category_master_pk`),
  CONSTRAINT `fk5` FOREIGN KEY (`category_master_pk`) REFERENCES `category_master` (`pk`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of service_master
-- ----------------------------

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `last_name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `email` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact1` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `contact2` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `active_deactive` int(11) DEFAULT '0',
  `gender` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`pk`),
  UNIQUE KEY `unique_constr` (`email`) USING BTREE,
  UNIQUE KEY `unique_constr_1` (`contact1`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('5', 'Sonal', 'Agarwal', 's@gmail.com', '7894566549', '', '0', 'Female', 'Sonal', '2');
INSERT INTO `users` VALUES ('6', 'Pankaj', 'Garg', 'p@gmail.com', '789456235', '', '0', 'Male', 'Pankaj', '1');
