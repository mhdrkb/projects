-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.6.40-log


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema realstate
--

CREATE DATABASE IF NOT EXISTS realstate;
USE realstate;

--
-- Definition of table `areas`
--

DROP TABLE IF EXISTS `areas`;
CREATE TABLE `areas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `area_name` varchar(255) DEFAULT NULL,
  `city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKme0tu6jvrflho5lmhptod99w` (`city_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `areas`
--

/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` (`id`,`area_name`,`city_id`) VALUES 
 (1,'KOTBARI',4),
 (2,'MOHAMMADPUR',1),
 (3,'KURIL',1),
 (4,'DHANMONDI',1);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;


--
-- Definition of table `availability`
--

DROP TABLE IF EXISTS `availability`;
CREATE TABLE `availability` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `avail_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `availability`
--

/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` (`id`,`avail_name`) VALUES 
 (1,'RENT'),
 (2,'SELL');
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;


--
-- Definition of table `buildings`
--

DROP TABLE IF EXISTS `buildings`;
CREATE TABLE `buildings` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `available_for` varchar(255) DEFAULT NULL,
  `bath_rooms` int(11) NOT NULL,
  `bed_rooms` int(11) NOT NULL,
  `building_name` varchar(255) DEFAULT NULL,
  `built_in_date` datetime DEFAULT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `other_detailing` varchar(255) DEFAULT NULL,
  `other_features` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `registration_date` datetime DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `street_address` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) NOT NULL,
  `catagory_id` bigint(20) NOT NULL,
  `city_id` bigint(20) NOT NULL,
  `construction_id` bigint(20) NOT NULL,
  `housing_id` bigint(20) NOT NULL,
  `available_id` bigint(20) NOT NULL,
  `flat_size` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfjuogv4wbcy3yejn4bn1av8yv` (`area_id`),
  KEY `FK3lfvpx1ov1qv20gg0sdwuq2uv` (`available_id`),
  KEY `FK7mocoda9mc7lhv7g2xec15v4f` (`catagory_id`),
  KEY `FKlo0glu0v0nygab6yurlep9b2s` (`city_id`),
  KEY `FKl2ggon4m84b3ti7j4fjxpac4n` (`construction_id`),
  KEY `FK9oula87lk1exer0tjcb0068mw` (`housing_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `buildings`
--

/*!40000 ALTER TABLE `buildings` DISABLE KEYS */;
INSERT INTO `buildings` (`id`,`available_for`,`bath_rooms`,`bed_rooms`,`building_name`,`built_in_date`,`file_extension`,`file_name`,`file_path`,`file_size`,`other_detailing`,`other_features`,`price`,`registration_date`,`size`,`street_address`,`area_id`,`catagory_id`,`city_id`,`construction_id`,`housing_id`,`available_id`,`flat_size`) VALUES 
 (4,NULL,3,3,'Green Palace','2018-12-20 00:00:00','image/jpeg','new-b5.jpg','/img/new-b5.jpg',83881,'sdaffsdfsadff',NULL,'12000000','2019-04-08 13:19:40',NULL,'dfsafsdfsdsd',4,1,1,3,4,2,'1350'),
 (5,NULL,3,3,'Ma Villa','2017-03-01 00:00:00','image/jpeg','new-b4.jpg','/img/new-b4.jpg',98477,'sfgafsgadfgdfg',NULL,'10000000','2019-04-13 09:19:31',NULL,'hdbgdb',1,1,4,1,3,2,'1500'),
 (6,NULL,3,3,'Vhuiyan Villa','2019-02-06 00:00:00','image/jpeg','new-b1.jpg','/img/new-b1.jpg',103380,'ytjryjhryhn',NULL,'1700000.0','2019-04-13 10:09:58',NULL,'hjyrjhuryh',1,1,1,1,1,2,'1400'),
 (7,NULL,4,4,'Tareq Villa','2019-03-28 00:00:00','image/jpeg','new-b2.jpg','/img/new-b2.jpg',78732,'fsgsagvfsdgvdsfv',NULL,'1200000000','2019-04-13 10:10:25',NULL,'fgasgsfgvsdfgv',3,1,1,1,1,2,'1500'),
 (8,NULL,3,3,'Azad Villa','2018-08-30 00:00:00','image/jpeg','new-b5.jpg','/img/new-b5.jpg',83881,'hfjdrhngh',NULL,'10000000','2019-04-13 12:45:32',NULL,'House # 14, 4 A',4,1,1,3,4,2,'1400');
/*!40000 ALTER TABLE `buildings` ENABLE KEYS */;


--
-- Definition of table `catagories`
--

DROP TABLE IF EXISTS `catagories`;
CREATE TABLE `catagories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `catagory_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagories`
--

/*!40000 ALTER TABLE `catagories` DISABLE KEYS */;
INSERT INTO `catagories` (`id`,`catagory_name`) VALUES 
 (1,'RESIDENTIAL'),
 (2,'COMMERCIAL'),
 (3,'INDUSTRIAL');
/*!40000 ALTER TABLE `catagories` ENABLE KEYS */;


--
-- Definition of table `cities`
--

DROP TABLE IF EXISTS `cities`;
CREATE TABLE `cities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `city_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cities`
--

/*!40000 ALTER TABLE `cities` DISABLE KEYS */;
INSERT INTO `cities` (`id`,`city_name`) VALUES 
 (1,'DHAKA'),
 (2,'CHITTAGONG'),
 (3,'SYLHET'),
 (4,'COMILLA'),
 (5,'RANGPUR'),
 (6,'KHULNA'),
 (7,'RAJSHAHI'),
 (8,'COX\'S BAZAR'),
 (9,'BARISAL'),
 (10,'GOPALGANJ '),
 (11,'NARAYANGANJ'),
 (12,'KUAKATA'),
 (13,'BOGRA'),
 (14,'TONGI'),
 (15,'CHAPAI NAWABGANJ '),
 (16,'LAKSHAM');
/*!40000 ALTER TABLE `cities` ENABLE KEYS */;


--
-- Definition of table `city_area`
--

DROP TABLE IF EXISTS `city_area`;
CREATE TABLE `city_area` (
  `city_id` bigint(20) NOT NULL,
  `area_id` bigint(20) NOT NULL,
  PRIMARY KEY (`area_id`),
  KEY `FKpaccsrag2bpcl5f4v1cw38r0c` (`city_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `city_area`
--

/*!40000 ALTER TABLE `city_area` DISABLE KEYS */;
/*!40000 ALTER TABLE `city_area` ENABLE KEYS */;


--
-- Definition of table `construction_type`
--

DROP TABLE IF EXISTS `construction_type`;
CREATE TABLE `construction_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `const_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `construction_type`
--

/*!40000 ALTER TABLE `construction_type` DISABLE KEYS */;
INSERT INTO `construction_type` (`id`,`const_type_name`) VALUES 
 (1,'NEW BUILDING'),
 (2,'OLD BUILDING'),
 (3,'UNDER CONSTRUCTION');
/*!40000 ALTER TABLE `construction_type` ENABLE KEYS */;


--
-- Definition of table `housing_area`
--

DROP TABLE IF EXISTS `housing_area`;
CREATE TABLE `housing_area` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `housing_name` varchar(255) DEFAULT NULL,
  `area_id` bigint(20) NOT NULL,
  `city_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKmpqv6lojog9gfk1l4excibonu` (`area_id`),
  KEY `FK1ycnwx5u3f5bnj5ykl6v0utwb` (`city_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `housing_area`
--

/*!40000 ALTER TABLE `housing_area` DISABLE KEYS */;
INSERT INTO `housing_area` (`id`,`housing_name`,`area_id`,`city_id`) VALUES 
 (1,'MOHAMMADIA HOUSING LTD',2,1),
 (2,'XYZ',1,4),
 (3,'ABC',3,1),
 (4,'ZIGATOLA REALSTATE',4,1);
/*!40000 ALTER TABLE `housing_area` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`id`,`role_name`) VALUES 
 (1,'USER'),
 (2,'SUPERADMIN'),
 (3,'ADMIN'),
 (5,'AGENT'),
 (7,'CLIENT');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `birth_date` date NOT NULL,
  `confirmation_token` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `file_extension` varchar(255) DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_path` varchar(255) DEFAULT NULL,
  `file_size` bigint(20) DEFAULT NULL,
  `first_name` varchar(50) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `last_modified_date` datetime DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `regi_date` datetime DEFAULT NULL,
  `token_expired` bit(1) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`),
  UNIQUE KEY `UK_lqjrcobrh9jc8wpcar64q1bfh` (`user_name`),
  UNIQUE KEY `UK_cnjwxx5favk5ycqajjt17fwy1` (`mobile`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`,`birth_date`,`confirmation_token`,`email`,`enabled`,`file_extension`,`file_name`,`file_path`,`file_size`,`first_name`,`gender`,`last_modified_date`,`last_name`,`mobile`,`password`,`regi_date`,`token_expired`,`user_name`) VALUES 
 (1,'2019-03-13','ee6be8f7-ef7b-4d1a-8860-560f798b78fa','admin@pms.com',0x01,NULL,NULL,NULL,0,'Md.',NULL,'2019-03-13 10:06:36','R',NULL,'$2a$10$4l/R/FblVLrou2M.4C2Wv.kHPUFRr3wE4WG7hl2s8MDcHO45is9sy',NULL,0x01,'sadmin'),
 (2,'1991-03-12','56920952-5403-4a17-ac2d-7e61a881a68e','mhdrkb91@gmail.com',0x00,NULL,NULL,NULL,0,'Mehedee','m','2019-03-13 10:11:12','Hasan',NULL,NULL,'2019-03-13 10:11:12',0x00,'mhdrkb91');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


--
-- Definition of table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_role`
--

/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` (`user_id`,`role_id`) VALUES 
 (1,1),
 (1,2),
 (2,1);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
