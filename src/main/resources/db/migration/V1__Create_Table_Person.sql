CREATE TABLE `tb_person` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adress` varchar(100) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `last_name` varchar(80) NOT NULL,
  PRIMARY KEY (`id`)
);
