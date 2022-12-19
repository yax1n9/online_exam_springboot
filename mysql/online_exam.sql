-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: exam
-- ------------------------------------------------------
-- Server version	8.0.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `role` int NOT NULL DEFAULT '1' COMMENT '0：考生；1：管理员',
  `avatar` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：删除',
  `name` varchar(20) DEFAULT NULL,
  `gender` int DEFAULT '0' COMMENT '0：女；1：男',
  `tel` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`admin_id`),
  UNIQUE KEY `admin_admin_id_uindex` (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员或老师表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (3,'teacher',1,NULL,'8d788385431273d11e8b43bb78f3aa41',0,'马老师',0,NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam`
--

DROP TABLE IF EXISTS `exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam` (
  `exam_id` int NOT NULL AUTO_INCREMENT,
  `title` varchar(50) NOT NULL,
  `cover` varchar(255) DEFAULT 'exam_cover_default.png',
  `subject_id` int NOT NULL,
  `subject_name` varchar(50) DEFAULT NULL,
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `shortest_submit_time` int NOT NULL DEFAULT '15' COMMENT '最短提交时间（min)',
  `latest_enter_time` int DEFAULT '15' COMMENT '最晚的进入时间（min）',
  `pass_line` int NOT NULL DEFAULT '60' COMMENT '及格线，百分制',
  `is_begin` int DEFAULT '0' COMMENT '是否开始考试。 0：未开始； 1：正在进行；',
  `is_end` int NOT NULL DEFAULT '0' COMMENT '0：未结束；1：已结束',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`exam_id`),
  UNIQUE KEY `exam_examId_uindex` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'计算机网络期末考试（A）','exam_cover_default.png',1,'计算机网络','2022-12-05 02:20:23','2022-12-31 02:20:23',15,15,60,1,0,0),(2,'计算机网络期末考试（B）','exam_cover_default.png',1,'计算机网络','2022-12-31 02:22:46','2022-12-31 04:22:46',15,15,60,0,0,0),(3,'web前端','exam_cover_default.png',2,'web前端','2022-12-12 09:39:13','2022-12-12 09:39:13',15,15,60,0,1,0),(4,'test','exam_cover_default.png',2,'web前端','2022-12-12 09:54:28','2022-12-12 09:54:28',15,15,60,0,1,1),(5,'test222','exam_cover_default.png',1,'计算机网络','2022-12-12 09:58:05','2022-12-12 09:58:05',15,15,60,0,1,1),(6,'test333','exam_cover_default.png',1,'计算机网络','2022-12-13 01:30:04','2022-12-13 01:30:04',15,15,60,0,1,0),(7,'test444','exam_cover_default.png',1,'计算机网络','2022-12-13 01:34:27','2022-12-13 01:34:27',15,15,60,0,1,0),(8,'test555','exam_cover_default.png',1,'计算机网络','2022-12-13 01:37:01','2022-12-13 01:37:01',15,15,60,0,1,0),(9,'test666','exam_cover_default.png',1,'计算机网络','2022-12-13 02:40:11','2022-12-13 02:40:11',15,15,60,0,1,0),(10,'test77','exam_cover_default.png',1,'计算机网络','2022-12-13 06:42:39','2022-12-20 02:42:39',15,15,60,1,0,0),(11,'长期考试1','exam_cover_default.png',1,'计算机网络','2022-12-16 02:39:08','2023-12-16 02:39:11',15,15,60,0,1,0),(12,'长期考试2','exam_cover_default.png',1,'计算机网络','2022-12-16 02:39:41','2023-12-16 02:39:45',15,15,60,1,0,0),(13,'test000','exam_cover_default.png',3,'测试','2022-12-19 06:55:06','2022-12-19 06:55:06',15,15,60,0,1,0),(14,'321','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-30 16:00:00',15,15,60,1,0,0),(15,'1','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-19 16:00:00',15,15,60,1,0,0),(16,'1','exam_cover_default.png',1,'计算机网络','2022-12-19 16:00:00','2022-12-30 16:00:00',15,15,60,0,0,0),(17,'测试标题1','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-23 16:00:00',15,15,60,1,0,0),(18,'1','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-20 16:00:00',15,15,60,1,0,0),(19,'2','exam_cover_default.png',3,'测试','2022-12-21 16:00:00','2022-12-23 16:00:00',15,15,60,0,0,0),(20,'1','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-20 16:00:00',15,15,60,1,0,0),(21,'5','exam_cover_default.png',3,'测试','2022-12-18 16:00:00','2022-12-30 16:00:00',15,15,60,0,0,0);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_question`
--

DROP TABLE IF EXISTS `exam_question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_question` (
  `exam_question_id` int NOT NULL AUTO_INCREMENT,
  `question_id` int NOT NULL,
  `score` int NOT NULL DEFAULT '3',
  `exam_id` int NOT NULL,
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`exam_question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷对应试题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_question`
--

LOCK TABLES `exam_question` WRITE;
/*!40000 ALTER TABLE `exam_question` DISABLE KEYS */;
INSERT INTO `exam_question` VALUES (1,1,3,1,0),(2,2,3,1,0),(3,3,3,1,0),(4,4,3,1,0),(5,5,3,1,0),(6,6,3,1,0),(7,7,3,1,0),(8,8,3,1,0),(9,9,3,1,0),(10,10,3,1,0),(11,10,3,2,1),(12,1,3,13,0),(13,2,3,13,0),(14,3,3,13,0),(15,1,3,14,0),(16,2,3,14,0),(17,7,3,14,0),(18,6,3,14,0),(19,1,3,15,0),(20,1,3,18,0),(21,17,3,20,0),(22,1,3,21,0),(23,18,3,21,0);
/*!40000 ALTER TABLE `exam_question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `single_choose`
--

DROP TABLE IF EXISTS `single_choose`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `single_choose` (
  `question_id` int NOT NULL AUTO_INCREMENT,
  `subject_id` int NOT NULL DEFAULT '1',
  `subject_name` varchar(50) DEFAULT NULL,
  `title` varchar(255) NOT NULL,
  `answer_a` varchar(255) NOT NULL,
  `answer_b` varchar(255) NOT NULL,
  `answer_c` varchar(255) DEFAULT NULL,
  `answer_d` varchar(255) DEFAULT NULL,
  `real_answer` int NOT NULL DEFAULT '1' COMMENT '0: A;1: B;2: C;3: D',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  `type` int NOT NULL DEFAULT '0' COMMENT '默认0：选择题',
  PRIMARY KEY (`question_id`),
  UNIQUE KEY `singleChoose_questionId_uindex` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='单选题表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `single_choose`
--

LOCK TABLES `single_choose` WRITE;
/*!40000 ALTER TABLE `single_choose` DISABLE KEYS */;
INSERT INTO `single_choose` VALUES (1,1,'计算机网络','DNS 服务器和DHCP服务器的作用是（）','将IP地址翻译为计算机名，为客户机分配IP地址','将IP地址翻译为计算机名、解析计算机的MAC地址','将IP地址翻译为计算机名、解析计算机的MAC地址','将计算机名翻译为IP地址、解析计算机的MAC地址',2,0,0),(2,1,'计算机网络','HTTP协议通常使用什么协议进行传输（）','ARP','DHCP','UDP','TCP',3,0,0),(3,1,'计算机网络','查看DNS缓存记录的命令（）','ipconfig/displaydns','nslookup','ipconfig/release','ipconfig/flushdns',0,0,0),(4,1,'计算机网络','DHCP(        )报文的目的IP地址为255.255.255.255','DhcpDisover','DhcpOffer','DhcpAck','DhcpNack',0,0,0),(5,1,'计算机网络','下列地址中，（  ）不是DHCP服务器分配的IP地址','196.254.109.100','169.254.12.42','69.254.48.45','96.254.54.15',1,0,0),(6,1,'计算机网络','DHCP通常可以为客户端自动配置哪些网络参数（）','IP，掩码，网关，DNS','IP，掩码，域名，SMTP','网关，掩码，浏览器，FTP','IP，网关，DNS，服务器',0,0,0),(7,1,'计算机网络','DNS服务器在名称解析过程中正确的查询顺序为（）','本地缓存记录→区域记录→转发域名服务器→根域名服务器','区域记录→本地缓存记录→转发域名服务器→根域名服务器','本地缓存记录→区域记录→根域名服务器→转发域名服务器','区域记录→本地缓存记录→根域名服务器→转发域名服务器',0,0,0),(8,1,'计算机网络','在TCP/IP协议中，序号小于（  ）的端口称为熟知端口(well-known port)。','1024','64','256','128',0,0,0),(9,1,'计算机网络','在Internet上用TCP/IP播放视频，想用传输层的最快协议，以减少时延，要使用（ ）','UDP协议的低开销特性','UDP协议的低开销特性','TCP协议的低开销特性','TCP协议的高开销特性',0,0,0),(10,1,'计算机网络','在TCP协议中采用（ ）来区分不同的应用进程','端口号','IP地址','协议类型','MAC地址',0,0,0),(11,3,'测试','单选题','answerA','B','AnswerC',NULL,1,1,0),(12,1,'计算机网络','<p>1</p>','<p>1</p>','<p>1</p>',NULL,NULL,0,0,0),(13,3,'测试','<p>测试题干</p>','<p>测试选项A</p>','<p>测试选项B</p>',NULL,NULL,0,0,0),(14,3,'测试','<p>题干1</p>','<p>选项A</p>','<p>选项B</p>',NULL,NULL,0,0,0),(15,3,'测试','<p>2</p>','<p>2</p>','<p>2</p>',NULL,NULL,1,0,0),(16,3,'测试','<p>3</p>','<p>3</p>','<p>3</p>',NULL,NULL,1,0,0),(17,3,'测试','<p>4</p>','<p>4</p>','<p>4</p>',NULL,NULL,1,0,0),(18,3,'测试','<p>5</p>','<p>5</p>','<p>5</p>',NULL,NULL,1,0,0);
/*!40000 ALTER TABLE `single_choose` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `gender` int DEFAULT '0' COMMENT '0：女；1：男',
  `tel` varchar(20) DEFAULT NULL,
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  `role` int NOT NULL DEFAULT '0' COMMENT '0：考生；1：管理员老师',
  PRIMARY KEY (`student_id`),
  UNIQUE KEY `student_student_id_uindex` (`student_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='考生信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (2,'stu01','aabb2e552f79aff762f10fe249328a31',NULL,NULL,0,NULL,0,0),(3,'student','cd73502828457d15655bbd7a63fb0bc8',NULL,NULL,0,NULL,0,0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`subject_id`),
  UNIQUE KEY `subject_name_uindex` (`name`),
  UNIQUE KEY `subject_subjectId_uindex` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='科目分类表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'计算机网络',0),(2,'web前端',1),(3,'测试',0);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-19 17:59:02
