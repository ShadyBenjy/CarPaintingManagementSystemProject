SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 1;

DROP TABLE IF EXISTS `car`;
CREATE TABLE `car`  (
  `car_id` int(11) NOT NULL,
  `cli_id` int(11) NOT NULL,
  `car_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `car_date` varchar(50) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  
  PRIMARY KEY (`car_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `car` VALUES (1, 1,'Ford','11/05/2022');
INSERT INTO `car` VALUES (2, 1, 'Audi R8', '11/05/2022');
INSERT INTO `car` VALUES (3, 2,'Toyota D4D', '13/05/2022');

SET FOREIGN_KEY_CHECKS = 2;