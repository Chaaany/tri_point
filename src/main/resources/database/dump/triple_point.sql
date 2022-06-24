-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: triple
-- ------------------------------------------------------
-- Server version	8.0.28

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `point`
--

DROP TABLE IF EXISTS `point`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `point` (
  `pointId` bigint NOT NULL AUTO_INCREMENT,
  `userId` binary(16) NOT NULL,
  `activityType` int NOT NULL,
  `activityId` binary(16) NOT NULL,
  `pointScore` int NOT NULL,
  `pointType` int DEFAULT NULL,
  `createdDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`pointId`),
  KEY `idx_point_userId_activityId` (`userId`,`activityId`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `point`
--

LOCK TABLES `point` WRITE;
/*!40000 ALTER TABLE `point` DISABLE KEYS */;
INSERT INTO `point` VALUES (18,_binary '>\Şò’·H¥óWSa÷E',1,_binary '$\nX\Ü_Hx“ë·²fwr',1,2,'2022-06-24 13:44:06'),(19,_binary '>\Şò’·H¥óWSa÷E',2,_binary '$\nX\Ü_Hx“ë·²fwr',1,1,'2022-06-24 13:44:06'),(20,_binary '>\Şò’·H¥óWSa÷E',3,_binary '$\nX\Ü_Hx“ë·²fwr',1,1,'2022-06-24 13:44:06'),(21,_binary 'ÿc\ÚöWLò­7kW›µ`',1,_binary ' \İÍƒŒC˜£a\\Ó¿ŒzS',1,2,'2022-06-24 19:59:47'),(22,_binary 'ÿc\ÚöWLò­7kW›µ`',2,_binary ' \İÍƒŒC˜£a\\Ó¿ŒzS',1,1,'2022-06-24 19:59:47'),(23,_binary 'ÿc\ÚöWLò­7kW›µ`',3,_binary ' \İÍƒŒC˜£a\\Ó¿ŒzS',1,1,'2022-06-24 19:59:47'),(24,_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á',1,_binary 'œ\Ò(z•Dı®KX	ƒ\Å',1,2,'2022-06-24 20:00:06'),(25,_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á',2,_binary 'œ\Ò(z•Dı®KX	ƒ\Å',1,1,'2022-06-24 20:00:06'),(26,_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á',3,_binary 'œ\Ò(z•Dı®KX	ƒ\Å',1,1,'2022-06-24 20:00:06'),(27,_binary 'D†İ‚tLÙ§†“-\èC\İ',1,_binary 'LkUR@b!`O;\Ã@,',1,2,'2022-06-24 20:15:59'),(28,_binary 'D†İ‚tLÙ§†“-\èC\İ',2,_binary 'LkUR@b!`O;\Ã@,',1,1,'2022-06-24 20:15:59'),(29,_binary 'D†İ‚tLÙ§†“-\èC\İ',3,_binary 'LkUR@b!`O;\Ã@,',1,1,'2022-06-24 20:15:59'),(30,_binary '\Ğ\êG\Ô!FIDœ\é­@›H–x',1,_binary 'h\Í7Æ§F<„¬-r\Ï\Õ-˜',1,2,'2022-06-24 20:17:07'),(31,_binary '\Ğ\êG\Ô!FIDœ\é­@›H–x',2,_binary 'h\Í7Æ§F<„¬-r\Ï\Õ-˜',1,1,'2022-06-24 20:17:07'),(32,_binary '\Ğ\êG\Ô!FIDœ\é­@›H–x',3,_binary 'h\Í7Æ§F<„¬-r\Ï\Õ-˜',1,1,'2022-06-24 20:17:07'),(33,_binary '«ÀŸI®\Î\ÙÁ(şŒ',1,_binary '?\î\Æ\Ú5OÉš\á€\Ì&wµ',1,2,'2022-06-24 20:17:54'),(34,_binary '«ÀŸI®\Î\ÙÁ(şŒ',2,_binary '?\î\Æ\Ú5OÉš\á€\Ì&wµ',1,1,'2022-06-24 20:17:54'),(35,_binary '«ÀŸI®\Î\ÙÁ(şŒ',3,_binary '?\î\Æ\Ú5OÉš\á€\Ì&wµ',1,1,'2022-06-24 20:17:54'),(36,_binary 'qÏƒ)‡J‡c\n+“ğ7®',1,_binary '5&(>\ËD­‚`˜‹’S¸',1,2,'2022-06-24 20:18:44'),(37,_binary 'qÏƒ)‡J‡c\n+“ğ7®',2,_binary '5&(>\ËD­‚`˜‹’S¸',1,1,'2022-06-24 20:18:44'),(38,_binary 'qÏƒ)‡J‡c\n+“ğ7®',3,_binary '5&(>\ËD­‚`˜‹’S¸',1,1,'2022-06-24 20:18:44'),(39,_binary '¡ Š2I¯—‘@\ï\Ğmó',1,_binary '\Ù#\à6\È AmÀ±\n\Ş4<',1,2,'2022-06-24 20:19:35'),(40,_binary '¡ Š2I¯—‘@\ï\Ğmó',2,_binary '\Ù#\à6\È AmÀ±\n\Ş4<',1,1,'2022-06-24 20:19:35'),(41,_binary '¡ Š2I¯—‘@\ï\Ğmó',3,_binary '\Ù#\à6\È AmÀ±\n\Ş4<',1,1,'2022-06-24 20:19:35'),(42,_binary '¾m\İtBP–zy’_·}',1,_binary '\âkPA\'˜Ù½x½\Õ\æ¸',1,2,'2022-06-24 20:21:27'),(43,_binary '¾m\İtBP–zy’_·}',2,_binary '\âkPA\'˜Ù½x½\Õ\æ¸',1,1,'2022-06-24 20:21:27'),(44,_binary '¾m\İtBP–zy’_·}',3,_binary '\âkPA\'˜Ù½x½\Õ\æ¸',1,1,'2022-06-24 20:21:27'),(45,_binary '–¼G`IR„ˆ\ËÃ°÷',1,_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',1,2,'2022-06-24 20:22:58'),(46,_binary '–¼G`IR„ˆ\ËÃ°÷',2,_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',1,1,'2022-06-24 20:22:58'),(47,_binary '–¼G`IR„ˆ\ËÃ°÷',3,_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',1,1,'2022-06-24 20:22:58'),(48,_binary '–¼G`IR„ˆ\ËÃ°÷',5,_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',-1,1,'2022-06-24 20:22:58'),(49,_binary 'K70(ošK·—¯)ô\Ü*X\Ú',1,_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',1,2,'2022-06-24 20:23:15'),(50,_binary 'K70(ošK·—¯)ô\Ü*X\Ú',2,_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',1,1,'2022-06-24 20:23:15'),(51,_binary 'K70(ošK·—¯)ô\Ü*X\Ú',3,_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',1,1,'2022-06-24 20:23:15'),(52,_binary 'K70(ošK·—¯)ô\Ü*X\Ú',5,_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',-1,1,'2022-06-24 20:23:15'),(53,_binary 'laò½¤\rD<€’\'E\çf«—',1,_binary '\Ä\ÏkO}œ8m',1,2,'2022-06-24 20:26:03'),(54,_binary 'laò½¤\rD<€’\'E\çf«—',2,_binary '\Ä\ÏkO}œ8m',1,1,'2022-06-24 20:26:03'),(55,_binary 'laò½¤\rD<€’\'E\çf«—',3,_binary '\Ä\ÏkO}œ8m',1,1,'2022-06-24 20:26:03'),(56,_binary 'laò½¤\rD<€’\'E\çf«—',5,_binary '\Ä\ÏkO}œ8m',-1,1,'2022-06-24 20:26:03'),(57,_binary '™‡Z\ØR@é¯Š\ç\'\Æl',1,_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',1,2,'2022-06-24 20:27:24'),(58,_binary '™‡Z\ØR@é¯Š\ç\'\Æl',2,_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',1,1,'2022-06-24 20:27:24'),(59,_binary '™‡Z\ØR@é¯Š\ç\'\Æl',3,_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',1,1,'2022-06-24 20:27:24'),(60,_binary '™‡Z\ØR@é¯Š\ç\'\Æl',5,_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',-1,1,'2022-06-24 20:27:24'),(61,_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï',1,_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',1,2,'2022-06-24 20:29:13'),(62,_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï',2,_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',1,1,'2022-06-24 20:29:13'),(63,_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï',3,_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',1,1,'2022-06-24 20:29:13'),(64,_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï',5,_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',-1,1,'2022-06-24 20:29:13'),(65,_binary '‡o\"z“G\à–\ÛU\×B\Ä',1,_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',1,2,'2022-06-24 20:30:28'),(66,_binary '‡o\"z“G\à–\ÛU\×B\Ä',2,_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',1,1,'2022-06-24 20:30:28'),(67,_binary '‡o\"z“G\à–\ÛU\×B\Ä',3,_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',1,1,'2022-06-24 20:30:28'),(68,_binary '‡o\"z“G\à–\ÛU\×B\Ä',5,_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',-1,1,'2022-06-24 20:30:28'),(69,_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â',1,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',1,2,'2022-06-24 20:31:26'),(70,_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â',2,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',1,1,'2022-06-24 20:31:26'),(71,_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â',3,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',1,1,'2022-06-24 20:31:26'),(72,_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â',5,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',-1,1,'2022-06-24 20:31:26'),(73,_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â',6,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',-1,1,'2022-06-24 20:31:26'),(74,_binary 'À	³¥¼;F–,Aª@',1,_binary '˜ä›„mEÒ„ş’C¾OœQ',1,2,'2022-06-24 20:34:12'),(75,_binary 'À	³¥¼;F–,Aª@',2,_binary '˜ä›„mEÒ„ş’C¾OœQ',1,1,'2022-06-24 20:34:12'),(76,_binary 'À	³¥¼;F–,Aª@',3,_binary '˜ä›„mEÒ„ş’C¾OœQ',1,1,'2022-06-24 20:34:12'),(77,_binary '\Æz\ïkDŠa\Ô&F‹d',1,_binary '\Ë,ü	”sLL¥ò^¦S´',1,2,'2022-06-24 20:35:40'),(78,_binary '\Æz\ïkDŠa\Ô&F‹d',2,_binary '\Ë,ü	”sLL¥ò^¦S´',1,1,'2022-06-24 20:35:40'),(79,_binary '\Æz\ïkDŠa\Ô&F‹d',3,_binary '\Ë,ü	”sLL¥ò^¦S´',1,1,'2022-06-24 20:35:40'),(80,_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ğ',1,_binary ' kv\Øl$MŠ¿ûşK¿EG',1,2,'2022-06-24 20:37:10'),(81,_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ğ',2,_binary ' kv\Øl$MŠ¿ûşK¿EG',1,1,'2022-06-24 20:37:10'),(82,_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ğ',3,_binary ' kv\Øl$MŠ¿ûşK¿EG',1,1,'2022-06-24 20:37:10'),(83,_binary 'h`«\ÃaE£„=7\Ç',1,_binary 'xŒÏˆ\ĞòA\\‡r9b6õ(',1,2,'2022-06-24 20:37:37'),(84,_binary 'h`«\ÃaE£„=7\Ç',2,_binary 'xŒÏˆ\ĞòA\\‡r9b6õ(',1,1,'2022-06-24 20:37:37'),(85,_binary 'h`«\ÃaE£„=7\Ç',3,_binary 'xŒÏˆ\ĞòA\\‡r9b6õ(',1,1,'2022-06-24 20:37:37'),(86,_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©',1,_binary '*Ü„÷1\ÏNª¤3C£ox}z',1,2,'2022-06-24 20:39:09'),(87,_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©',2,_binary '*Ü„÷1\ÏNª¤3C£ox}z',1,1,'2022-06-24 20:39:09'),(88,_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©',3,_binary '*Ü„÷1\ÏNª¤3C£ox}z',1,1,'2022-06-24 20:39:09'),(89,_binary '‰,´À5BˆƒFWÑ¹',1,_binary 'Ÿóü\è:L,¤\ëÿBr!\Ê',1,2,'2022-06-24 20:49:51'),(90,_binary '‰,´À5BˆƒFWÑ¹',2,_binary 'Ÿóü\è:L,¤\ëÿBr!\Ê',1,1,'2022-06-24 20:49:51'),(91,_binary '‰,´À5BˆƒFWÑ¹',3,_binary 'Ÿóü\è:L,¤\ëÿBr!\Ê',1,1,'2022-06-24 20:49:51'),(92,_binary '¯7Jm„I”b\ÖÎ²',1,_binary ')§ò_LÍ\Ş\È.(\éd4',1,2,'2022-06-24 20:50:39'),(93,_binary '¯7Jm„I”b\ÖÎ²',2,_binary ')§ò_LÍ\Ş\È.(\éd4',1,1,'2022-06-24 20:50:39'),(94,_binary '¯7Jm„I”b\ÖÎ²',3,_binary ')§ò_LÍ\Ş\È.(\éd4',1,1,'2022-06-24 20:50:39'),(95,_binary '—\à\îjIŠ§\Íü\ÊN¨',1,_binary '5w:¸ eH‚Qy\Äp·',1,2,'2022-06-24 20:50:55'),(96,_binary '—\à\îjIŠ§\Íü\ÊN¨',2,_binary '5w:¸ eH‚Qy\Äp·',1,1,'2022-06-24 20:50:55'),(97,_binary '—\à\îjIŠ§\Íü\ÊN¨',3,_binary '5w:¸ eH‚Qy\Äp·',1,1,'2022-06-24 20:50:55'),(98,_binary '—\à\îjIŠ§\Íü\ÊN¨',4,_binary '5w:¸ eH‚Qy\Äp·',-1,2,'2022-06-24 20:50:55'),(99,_binary '—\à\îjIŠ§\Íü\ÊN¨',5,_binary '5w:¸ eH‚Qy\Äp·',-1,1,'2022-06-24 20:50:55'),(100,_binary '—\à\îjIŠ§\Íü\ÊN¨',6,_binary '5w:¸ eH‚Qy\Äp·',-1,1,'2022-06-24 20:50:55'),(101,_binary 'û\Ù\Ärİ·NÚ²&\r\'nYY',1,_binary 'ş\éX¤|Iª‰3UE\Ş\ì',1,2,'2022-06-24 20:57:32'),(102,_binary 'û\Ù\Ärİ·NÚ²&\r\'nYY',2,_binary 'ş\éX¤|Iª‰3UE\Ş\ì',1,1,'2022-06-24 20:57:32'),(103,_binary 'û\Ù\Ärİ·NÚ²&\r\'nYY',3,_binary 'ş\éX¤|Iª‰3UE\Ş\ì',1,1,'2022-06-24 20:57:32'),(104,_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv',1,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',1,2,'2022-06-24 20:58:05'),(105,_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv',2,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',1,1,'2022-06-24 20:58:05'),(106,_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv',3,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',1,1,'2022-06-24 20:58:05'),(107,_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv',5,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',-1,1,'2022-06-24 20:58:05'),(108,_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv',6,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',-1,1,'2022-06-24 20:58:05'),(109,_binary '\éfø?N3Š´VKg\ï',1,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',1,2,'2022-06-24 20:58:28'),(110,_binary '\éfø?N3Š´VKg\ï',2,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',1,1,'2022-06-24 20:58:28'),(111,_binary '\éfø?N3Š´VKg\ï',3,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',1,1,'2022-06-24 20:58:28'),(112,_binary '\éfø?N3Š´VKg\ï',4,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',-1,2,'2022-06-24 20:58:28'),(113,_binary '\éfø?N3Š´VKg\ï',5,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',-1,1,'2022-06-24 20:58:28'),(114,_binary '\éfø?N3Š´VKg\ï',6,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',-1,1,'2022-06-24 20:58:28');
/*!40000 ALTER TABLE `point` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  6:18:53
