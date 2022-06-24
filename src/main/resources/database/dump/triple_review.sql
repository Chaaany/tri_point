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
-- Table structure for table `review`
--

DROP TABLE IF EXISTS `review`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `review` (
  `reviewId` binary(16) NOT NULL,
  `placeId` binary(16) NOT NULL,
  `userId` binary(16) NOT NULL,
  `content` longtext,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `uploadedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifiedDate` timestamp NULL DEFAULT NULL,
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`reviewId`),
  KEY `idx_review_placeId_userId` (`placeId`,`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `review`
--

LOCK TABLES `review` WRITE;
/*!40000 ALTER TABLE `review` DISABLE KEYS */;
INSERT INTO `review` VALUES (_binary 'LkUR@b!`O;\Ã@,',_binary '\æÙ¨öHk­¾ø³\'e,ô',_binary 'D†İ‚tLÙ§†“-\èC\İ','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 20:15:59',NULL,NULL),(_binary '˜ä›„mEÒ„ş’C¾OœQ',_binary 'Z;u;¥AŸ\Ç?LÁÁ\nŸ',_binary 'À	³¥¼;F–,Aª@','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 20:34:12',NULL,NULL),(_binary ' kv\Øl$MŠ¿ûşK¿EG',_binary '\r\ê„<œ\â@ñ’\ê\àO¡¢',_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ğ','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:37:10',NULL,'2022-06-24 20:37:10'),(_binary ' ¡rHd\ïC¾\Çzˆ+!\Úk',_binary '.K¯Z\ËNû¡¯\í\Ú\Ú1°',_binary '>\Şò’·H¥óWSa÷E','0',0,'2022-06-24 18:57:43',NULL,NULL),(_binary ' \İÍƒŒC˜£a\\Ó¿ŒzS',_binary '\Ù\Òf4,HÍ«\æ~ÿ\î',_binary 'ÿc\ÚöWLò­7kW›µ`','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 19:59:47',NULL,NULL),(_binary '$\nX\Ü_Hx“ë·²fwr',_binary '.K¯Z\ËNû¡¯\í\Ú\Ú1°',_binary '>\Şò’·H¥óWSa÷E','ì¢‹ì•„ìš”!',0,'2022-06-24 13:43:54',NULL,NULL),(_binary '&h\Z‹,ıOu¦Jr\Å$\Å',_binary '–	¡9HöHM»~6´uc®',_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv','',0,'2022-06-24 20:58:05','2022-06-24 20:58:05',NULL),(_binary ')§ò_LÍ\Ş\È.(\éd4',_binary ',´6\ë1LE’†7N\Ø[',_binary '¯7Jm„I”b\ÖÎ²','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:50:39',NULL,'2022-06-24 20:50:39'),(_binary '*Ü„÷1\ÏNª¤3C£ox}z',_binary '¯W\âQB»[÷(¼—\Ä',_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:39:09',NULL,'2022-06-24 20:39:09'),(_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',_binary 'GpŸó-`Dr‚ \äaô\ä¦',_binary '–¼G`IR„ˆ\ËÃ°÷','',0,'2022-06-24 20:22:58','2022-06-24 20:22:58',NULL),(_binary '5&(>\ËD­‚`˜‹’S¸',_binary 'FM=?ZAV«ƒ\ÜÎ½',_binary 'qÏƒ)‡J‡c\n+“ğ7®','',0,'2022-06-24 20:18:44','2022-06-24 20:18:44',NULL),(_binary '5w:¸ eH‚Qy\Äp·',_binary 'g¢c\ê\ÙgHA¸k\ï\rZ\î£',_binary '—\à\îjIŠ§\Íü\ÊN¨','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:50:55',NULL,'2022-06-24 20:50:55'),(_binary '?\î\Æ\Ú5OÉš\á€\Ì&wµ',_binary '\ëd\Üiÿ4@c¤,ò\"¼¯Œ',_binary '«ÀŸI®\Î\ÙÁ(şŒ','',0,'2022-06-24 20:17:54','2022-06-24 20:17:54',NULL),(_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',_binary '\Ë\ãí‚“\ãK\r§´K\Îkgu',_binary '‡o\"z“G\à–\ÛU\×B\Ä','',0,'2022-06-24 20:30:28','2022-06-24 20:30:28',NULL),(_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',_binary '\rÜ²g\rL—0.\î\Ñlô',_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â','',0,'2022-06-24 20:31:26','2022-06-24 20:31:26',NULL),(_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',_binary '\à¤\İk\ÛK3’Øù-\âf4',_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï','',0,'2022-06-24 20:29:13','2022-06-24 20:29:13',NULL),(_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',_binary '™¹ÿ}GBl½^òÙ˜|',_binary '™‡Z\ØR@é¯Š\ç\'\Æl','',0,'2022-06-24 20:27:24','2022-06-24 20:27:24',NULL),(_binary '`X~½U\àF\ç’r8Ì†ÁÙ•',_binary 'h\nC¯¬JB’24=…+ñn',_binary '“\ZH\ë\ÆO<‚H}\0M‰\Ã','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 20:15:59',NULL,NULL),(_binary 'h\Í7Æ§F<„¬-r\Ï\Õ-˜',_binary 'œ\Ñ\ç\ávbI¶!’T÷1\â',_binary '\Ğ\êG\Ô!FIDœ\é­@›H–x','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 20:17:07',NULL,NULL),(_binary 'xŒÏˆ\ĞòA\\‡r9b6õ(',_binary '¦U\×Õ”B^—.†<\"§§õ',_binary 'h`«\ÃaE£„=7\Ç','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:37:37',NULL,'2022-06-24 20:37:37'),(_binary 'œ\Ò(z•Dı®KX	ƒ\Å',_binary '\ì\ìÏ•\ÌO£¶òû‘]qş',_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á','ì¢‹ì•„ìš”!!!0',0,'2022-06-24 20:00:05',NULL,NULL),(_binary 'Ÿóü\è:L,¤\ëÿBr!\Ê',_binary '¨<L{ø\Ñ@ğ¿S>\ÜÔ±\ë',_binary '‰,´À5BˆƒFWÑ¹','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:49:51',NULL,'2022-06-24 20:49:51'),(_binary '\Ä\ÏkO}œ8m',_binary '\\\n¼\è\ÎOò„{ö¾¯g\Ñ\ß',_binary 'laò½¤\rD<€’\'E\çf«—','',0,'2022-06-24 20:26:03','2022-06-24 20:26:03',NULL),(_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',_binary '‹~ —}@Œ@úU%',_binary 'K70(ošK·—¯)ô\Ü*X\Ú','',0,'2022-06-24 20:23:15','2022-06-24 20:23:15',NULL),(_binary '\Ë,ü	”sLL¥ò^¦S´',_binary '#`\"\ŞWJ¯€0\å0—ˆ\Ù',_binary '\Æz\ïkDŠa\Ô&F‹d','ì¢‹ì•„ìš”!!!0',1,'2022-06-24 20:35:40',NULL,'2022-06-24 20:35:40'),(_binary '\Ù#\à6\È AmÀ±\n\Ş4<',_binary '{H&~\nBõ4Bp»\Äª',_binary '¡ Š2I¯—‘@\ï\Ğmó','',0,'2022-06-24 20:19:35','2022-06-24 20:19:35',NULL),(_binary '\Ü?¶u€\àMŒ²\É*•¢',_binary '.K¯Z\ËNû¡¯\í\Ú\Ú1°',_binary '>\Şò’·H¥óWSa÷E','0',0,'2022-06-24 18:56:18',NULL,NULL),(_binary '\âkPA\'˜Ù½x½\Õ\æ¸',_binary '—rc§¿«BŠ²u\æ\ĞxO\ß',_binary '¾m\İtBP–zy’_·}','',0,'2022-06-24 20:21:27','2022-06-24 20:21:27',NULL),(_binary 'ş\éX¤|Iª‰3UE\Ş\ì',_binary 'N\Ö\æwŸªNq½¸\×\ÊiLeù',_binary 'û\Ù\Ärİ·NÚ²&\r\'nYY','ì¢‹ì•„ìš”!!!4896',0,'2022-06-24 20:57:32',NULL,NULL),(_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',_binary 'Á\à*\Û>XLO¾\Ìj\İ0»\\ø',_binary '\éfø?N3Š´VKg\ï','ì¢‹ì•„ìš”!!!998',1,'2022-06-24 20:58:28',NULL,'2022-06-24 20:58:28');
/*!40000 ALTER TABLE `review` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  6:18:52
