SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `attendance`;
CREATE TABLE `attendance`  (
  `att_id` int(11) NOT NULL,
  `emp_id` int(11) NOT NULL,
  `att_date` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`att_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `attendance` VALUES (1, 1,'19/04/2022');
INSERT INTO `attendance` VALUES (2, 2, '19/04/2022');
INSERT INTO `attendance` VALUES (3, 3, '19/04/2021');

SET FOREIGN_KEY_CHECKS = 2;