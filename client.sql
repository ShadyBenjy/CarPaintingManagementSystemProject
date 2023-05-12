SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `client`;
CREATE TABLE `client`  (
  `cli_id` int(11) NOT NULL,
  `cli_name` varchar(150) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `cli_city` varchar(75) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  `cli_contact` varchar(100) CHARACTER SET utf8 COLLATE utf8_turkish_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cli_id`) USING BTREE
) ENGINE = MyISAM CHARACTER SET = utf8 COLLATE = utf8_turkish_ci ROW_FORMAT = Dynamic;

INSERT INTO `client` VALUES (1,'Jorge', 'Famagusta', 'jorgem@gmail.com');
INSERT INTO `client` VALUES (2, 'Philip', 'Nicosia', '5334555461');
INSERT INTO `client` VALUES (3, 'Mike', 'Girne', '5424356814');

SET FOREIGN_KEY_CHECKS = 1;