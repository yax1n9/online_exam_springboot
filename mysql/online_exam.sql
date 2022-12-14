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
  `start_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `latest_enter_time` int DEFAULT '15' COMMENT '最晚的进入时间（min）',
  `shortest_submit_time` int NOT NULL DEFAULT '15' COMMENT '最短提交时间（min)',
  `pass_line` int NOT NULL DEFAULT '60' COMMENT '及格线，百分制',
  `is_end` int NOT NULL DEFAULT '0' COMMENT '0：未结束；1：已结束',
  `is_delete` int NOT NULL DEFAULT '0' COMMENT '0：未删除；1：已删除',
  PRIMARY KEY (`exam_id`),
  UNIQUE KEY `exam_examId_uindex` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='试卷信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam`
--

LOCK TABLES `exam` WRITE;
/*!40000 ALTER TABLE `exam` DISABLE KEYS */;
INSERT INTO `exam` VALUES (1,'计算机网络期末考试（A）','exam_cover_default.png',1,'2022-12-05 02:20:23','2022-12-31 02:20:23',15,15,60,0,0),(2,'计算机网络期末考试（B）','exam_cover_default.png',1,'2022-12-31 02:22:46','2022-12-31 04:22:46',15,15,60,0,0),(3,'web前端','exam_cover_default.png',2,'2022-12-12 09:39:13','2022-12-12 09:39:13',15,15,60,0,0),(4,'test','exam_cover_default.png',4,'2022-12-12 09:54:28','2022-12-12 09:54:28',15,15,60,0,1),(5,'test222','exam_cover_default.png',3,'2022-12-12 09:58:05','2022-12-12 09:58:05',15,15,60,0,1),(6,'test333','exam_cover_default.png',3,'2022-12-13 01:30:04','2022-12-13 01:30:04',15,15,60,0,0),(7,'test444','exam_cover_default.png',3,'2022-12-13 01:34:27','2022-12-13 01:34:27',15,15,60,0,0),(8,'test555','exam_cover_default.png',3,'2022-12-13 01:37:01','2022-12-13 01:37:01',15,15,60,0,0),(9,'test666','exam_cover_default.png',3,'2022-12-13 02:40:11','2022-12-13 02:40:11',15,15,60,0,0),(10,'test77','exam_cover_default.png',3,'2022-12-13 06:42:39','2022-12-20 02:42:39',15,15,60,0,0);
/*!40000 ALTER TABLE `exam` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-13 17:59:58
