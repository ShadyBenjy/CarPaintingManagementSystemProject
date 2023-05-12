SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment`  (
  `pay_id` int(11) NOT NULL,
  `cli_id` int(11) NOT NULL,
  `pay_amount` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `pay_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
   PRIMARY KEY (`pay_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `payment` VALUES (1, 1,'1900tl','09/04/2021');
INSERT INTO `payment` VALUES (2, 2, '2000tl', '09/04/2021');
INSERT INTO `payment` VALUES (3, 2,'2100tl', '09/04/2021');

SET FOREIGN_KEY_CHECKS = 2;