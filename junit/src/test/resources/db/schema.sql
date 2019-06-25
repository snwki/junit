DROP TABLE IF EXISTS `crm_package`;
CREATE TABLE `user`  (
  `user_id` int(11) IDENTITY PRIMARY KEY,
  `user_name` varchar(255) ,
  `password` varchar(255)
);