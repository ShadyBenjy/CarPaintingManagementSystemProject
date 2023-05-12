SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `inventory`;
CREATE TABLE `inventory`  (
  `prod_id` int(11) NOT NULL,
  `dept_id` int(11) NOT NULL,
  `prod_code` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `prod_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  
  PRIMARY KEY (`prod_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `inventory` VALUES (1, 1,'I14','"Print ink');
INSERT INTO `inventory` VALUES (2, 1, 'C43','Blue paint');

SET FOREIGN_KEY_CHECKS = 1;