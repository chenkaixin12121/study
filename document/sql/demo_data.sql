/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : 127.0.0.1:3306
 Source Schema         : easyexcel

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 08/11/2021 09:22:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for demo_data
-- ----------------------------
DROP TABLE IF EXISTS `demo_data`;
CREATE TABLE `demo_data`  (
  `string` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `date` datetime NULL DEFAULT NULL,
  `big_decimal` decimal(16, 2) NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of demo_data
-- ----------------------------
INSERT INTO `demo_data` VALUES ('字符串0', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串1', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串2', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串3', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串4', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串5', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串6', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串7', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串8', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');
INSERT INTO `demo_data` VALUES ('字符串9', '2021-11-06 15:43:25', 0.56, 'https://blog.ckx.ink/upload/2020/04/%E5%BE%AE%E4%BF%A1%E5%9B%BE%E7%89%87_20200424230314-953bf9e05fa94cf5bedc5acf2e25b8c5.jpg');

SET FOREIGN_KEY_CHECKS = 1;
