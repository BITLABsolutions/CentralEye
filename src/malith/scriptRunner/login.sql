create database if not exists centraldb;

use centraldb;


drop table if exists users;


CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `last_name` varchar(64) DEFAULT NULL,
  `first_name` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `password` varchar(256) DEFAULT NULL,
  `is_admin` tinyint DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (1,'Alpha','Joe','joe.alpha@foo.com','k4AXDX87vLHmzXC18klyPqt84vp6HlrPd+cnU4IggndUq8Vrikonz/pbdrXQUJlz',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (2,'Beta','Jane','jane.beta@foo.com','X70IvzjITvoh76FV2gBXPdnt6hYr6KgUoTm+fJcrhlGWpNigYQRY8Ql/+lI/rcdx',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (3,'Zeta','Becky','becky.zeta@foo.com','zO3IE+Yb23RpGiYWeSHkZzKVu0YXQ0/pY0omSWIyi1SexPuuEpdDxl2nlDerx2TM',0);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (4,'Charlie','Admin','charlie.admin@foo.com','C9VcMJhFKQCiK9WHQ2cM0DxbuRbpHt2o5/K8078ci5XQGkGg/Zfv5HCpG6wGwrR1',1);
INSERT INTO `users` (`id`,`last_name`,`first_name`,`email`,`password`,`is_admin`) VALUES (5,'Miracles','Percy','percy@foo.com','7LhDtE2xbCJHKcvH80XpSKUolWnlC0SokdX83ZiBfHSP7xHwTKm6KLwmxQeiXvvV',1);
