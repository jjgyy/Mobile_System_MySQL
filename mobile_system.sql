CREATE DATABASE  IF NOT EXISTS `mobile_system` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mobile_system`;
-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: localhost    Database: mobile_system
-- ------------------------------------------------------
-- Server version	5.6.40

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `plan`
--

DROP TABLE IF EXISTS `plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `plan` (
  `plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cost` float(10,2) NOT NULL DEFAULT '0.00',
  `pname` varchar(64) NOT NULL,
  `intro` varchar(256) DEFAULT NULL,
  `climit` bigint(20) NOT NULL DEFAULT '0',
  `ccost` float(10,2) NOT NULL DEFAULT '0.00',
  `mlimit` bigint(20) NOT NULL DEFAULT '0',
  `mcost` float(10,2) NOT NULL DEFAULT '0.00',
  `llimit` bigint(20) NOT NULL DEFAULT '0',
  `lcost` float(10,2) NOT NULL DEFAULT '0.00',
  `alimit` bigint(20) NOT NULL DEFAULT '0',
  `acost` float(10,2) NOT NULL DEFAULT '0.00',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`plan_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plan`
--

LOCK TABLES `plan` WRITE;
/*!40000 ALTER TABLE `plan` DISABLE KEYS */;
INSERT INTO `plan` VALUES (1,20.00,'话费套餐','月功能费20元，最多可拨打100分钟电话，超出时间按照0.5元/分钟计费。',100,0.50,-1,0.00,-1,0.00,-1,0.00,'2018-10-29 12:32:44',0),(2,10.00,'短信套餐','月功能费10元，最多可发送200条短信，超出条数按0.1元/条计费。',-1,0.00,200,0.10,-1,0.00,-1,0.00,'2018-10-29 12:32:44',0),(3,20.00,'本地流量套餐','月功能费20元，最多可获得2G流量，仅在本地使用，超出流量按3元/M计费。',-1,0.00,-1,0.00,2048,3.00,-1,0.00,'2018-10-29 12:32:44',0),(4,30.00,'国内流量套餐','月功能费30元，最多可获得2G流量，超出流量按3元/M计费。',-1,0.00,-1,0.00,-1,0.00,2048,3.00,'2018-10-29 12:32:44',0);
/*!40000 ALTER TABLE `plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uname` varchar(32) NOT NULL DEFAULT '新用户',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'张龙','2018-10-29 12:32:29',0),(2,'周一','2018-10-29 12:32:29',0),(3,'袁玲','2018-10-29 12:32:29',0),(4,'张鹏','2018-10-29 12:32:29',0),(5,'赵雍','2018-10-29 12:32:29',0),(6,'马超','2018-10-29 12:32:29',0),(7,'董卓','2018-10-29 12:32:29',0),(8,'留白','2018-10-29 12:32:29',0),(9,'邓艾','2018-10-29 12:32:29',0),(10,'钟会','2018-10-29 12:32:29',0),(11,'马梦琪','2018-10-29 12:32:29',0),(12,'刘伯温','2018-10-29 12:32:29',0),(13,'韩信','2018-10-29 12:32:29',0),(14,'王朗','2018-10-29 12:32:29',0),(15,'刘表','2018-10-29 12:32:29',0),(16,'鹏举','2018-10-29 12:32:29',0),(17,'牛莉','2018-10-29 12:32:29',0),(18,'海瑞','2018-10-29 12:32:29',0),(19,'张之洞','2018-10-29 12:32:29',0),(20,'高进','2018-10-29 12:32:29',0),(21,'高海宇','2018-10-29 12:32:29',0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_aflow_record`
--

DROP TABLE IF EXISTS `user_aflow_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_aflow_record` (
  `aflow_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`aflow_record_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_aflow_record`
--

LOCK TABLES `user_aflow_record` WRITE;
/*!40000 ALTER TABLE `user_aflow_record` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_aflow_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_call_record`
--

DROP TABLE IF EXISTS `user_call_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_call_record` (
  `call_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`call_record_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_call_record`
--

LOCK TABLES `user_call_record` WRITE;
/*!40000 ALTER TABLE `user_call_record` DISABLE KEYS */;
INSERT INTO `user_call_record` VALUES (1,1,40,'2018-10-29 12:36:02',0);
/*!40000 ALTER TABLE `user_call_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_lflow_record`
--

DROP TABLE IF EXISTS `user_lflow_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_lflow_record` (
  `lflow_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`lflow_record_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_lflow_record`
--

LOCK TABLES `user_lflow_record` WRITE;
/*!40000 ALTER TABLE `user_lflow_record` DISABLE KEYS */;
INSERT INTO `user_lflow_record` VALUES (1,1,56,'2018-10-29 12:36:34',0);
/*!40000 ALTER TABLE `user_lflow_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_msg_record`
--

DROP TABLE IF EXISTS `user_msg_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_msg_record` (
  `msg_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `value` int(10) NOT NULL DEFAULT '0',
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`msg_record_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_msg_record`
--

LOCK TABLES `user_msg_record` WRITE;
/*!40000 ALTER TABLE `user_msg_record` DISABLE KEYS */;
INSERT INTO `user_msg_record` VALUES (1,1,1,'2018-10-29 12:36:09',0);
/*!40000 ALTER TABLE `user_msg_record` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_plan`
--

DROP TABLE IF EXISTS `user_plan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_plan` (
  `user_plan_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `keep` tinyint(1) NOT NULL DEFAULT '1',
  `del` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`user_plan_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_plan`
--

LOCK TABLES `user_plan` WRITE;
/*!40000 ALTER TABLE `user_plan` DISABLE KEYS */;
INSERT INTO `user_plan` VALUES (1,1,1,'2018-10-29 12:33:06',1,0),(2,1,2,'2018-10-29 12:33:20',1,0),(3,2,3,'2018-10-29 12:33:33',0,0),(4,10,4,'2018-10-29 12:33:49',1,0);
/*!40000 ALTER TABLE `user_plan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_plan_record`
--

DROP TABLE IF EXISTS `user_plan_record`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_plan_record` (
  `plan_record_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL,
  `plan_id` bigint(20) NOT NULL,
  `type` varchar(32) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`plan_record_id`),
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_plan_record`
--

LOCK TABLES `user_plan_record` WRITE;
/*!40000 ALTER TABLE `user_plan_record` DISABLE KEYS */;
INSERT INTO `user_plan_record` VALUES (1,1,1,'BUY','2018-10-29 12:33:06'),(2,1,2,'BUY','2018-10-29 12:33:20'),(3,2,3,'BUY','2018-10-29 12:33:33'),(4,10,4,'BUY','2018-10-29 12:33:49'),(5,2,3,'CANCEL NEXT MONTH','2018-10-29 12:34:53');
/*!40000 ALTER TABLE `user_plan_record` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-10-29 20:43:50
