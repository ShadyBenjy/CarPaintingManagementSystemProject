SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee`  (
  `emp_id` int(11) NOT NULL,
  `emp_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `emp_surname` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `gender` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `birthday` varchar(75) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`emp_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `employee` VALUES (1,'Mike','Luke','Male','21/07/2000');
INSERT INTO `employee` VALUES (2, 'Lisa', 'Udoye','Female', '15/11/1999');
INSERT INTO `employee` VALUES (3, 'Lucas','Sulemane','Male', '11/09/1998');

SET FOREIGN_KEY_CHECKS = 1;