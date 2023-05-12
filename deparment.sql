SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;


DROP TABLE IF EXISTS `department`;
CREATE TABLE `department`  (
  `dept_id` int(11) NOT NULL,
  `dept_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`dept_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;


INSERT INTO `department` VALUES (1, 'Accounting');
INSERT INTO `department` VALUES (2, 'Painting');
INSERT INTO `department` VALUES (3, 'Cleaning');

SET FOREIGN_KEY_CHECKS = 1;
