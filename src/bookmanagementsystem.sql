/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015 (8.0.15)
 Source Host           : localhost:3306
 Source Schema         : bookmanagementsystem

 Target Server Type    : MySQL
 Target Server Version : 80015 (8.0.15)
 File Encoding         : 65001

 Date: 20/12/2024 13:13:12
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books`  (
  `book_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `publish_date` date NULL DEFAULT NULL,
  `isbn` varchar(13) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `category` enum('Computer','Medicine','Literature','Law') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`book_id`) USING BTREE,
  UNIQUE INDEX `isbn`(`isbn` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES (1, '围城', '钱钟书', '1947-01-01', '9787532700001', '中国现代文学经典作品，描绘了知识分子的生活和爱情。', 'Literature');
INSERT INTO `books` VALUES (2, '活着', '余华', '1993-06-01', '9787532700002', '讲述了一个普通农民在动荡年代的生活经历。', 'Literature');
INSERT INTO `books` VALUES (3, 'The Pragmatic Programmer', 'Andrew Hunt, David Thomas', '1999-10-20', '9780201616224', 'A book on software development best practices.', 'Computer');
INSERT INTO `books` VALUES (4, '三体', '刘慈欣', '2008-05-01', '9787538723001', '科幻小说，讲述了人类与外星文明的首次接触。', 'Computer');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `role` enum('user','admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`user_id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'user1', 'password1', 'user');
INSERT INTO `users` VALUES (2, 'user2', 'password2', 'user');
INSERT INTO `users` VALUES (3, 'admin1', 'adminpassword1', 'admin');
INSERT INTO `users` VALUES (4, 'admin2', 'adminpassword2', 'admin');
INSERT INTO `users` VALUES (5, 'miao', '\\', 'user');

SET FOREIGN_KEY_CHECKS = 1;
