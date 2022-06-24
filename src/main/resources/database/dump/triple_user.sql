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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `userId` binary(16) NOT NULL,
  `nickname` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `registrationDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `nicknameModifiedDate` timestamp NULL DEFAULT NULL,
  `isUnsigned` tinyint(1) NOT NULL DEFAULT '0',
  `unsignedDate` timestamp NULL DEFAULT NULL,
  `isRecommendated` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (_binary '“\ZH\ë\ÆO<‚H}\0M‰\Ã','triple0','0','2022-06-24 20:15:59',NULL,0,NULL,0),(_binary '¯7Jm„I”b\ÖÎ²','triple0','0','2022-06-24 20:50:39',NULL,0,NULL,0),(_binary '	.þÕ¢MÄª+\\\\ˆ\0\áv','triple5337','8185','2022-06-24 20:58:05',NULL,0,NULL,1),(_binary 'h`«\ÃaE£„=7\Ç','triple0','0','2022-06-24 20:37:37',NULL,0,NULL,0),(_binary '«ÀŸI®\Î\ÙÁ(þŒ','triple0','0','2022-06-24 20:17:54',NULL,0,NULL,0),(_binary 'ÿc\ÚöWLò­7kW›µ`','triple0','0','2022-06-24 19:59:47',NULL,0,NULL,0),(_binary '/ÿb\Ü\ÅA<šJ&\ÝZŽ','triple','333','2022-06-24 17:33:35',NULL,0,NULL,0),(_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á','triple0','0','2022-06-24 20:00:05',NULL,0,NULL,0),(_binary ';w\Ä\Þ\ÎA»¨¬b¤\Äh\È\Â','triple0','0','2022-06-24 20:31:26',NULL,0,NULL,0),(_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©','triple0','0','2022-06-24 20:39:09',NULL,0,NULL,0),(_binary '>\Þò’·H¥óWSa÷E','Ben','1111','2022-06-24 13:43:54',NULL,0,NULL,0),(_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ð','triple0','0','2022-06-24 20:37:10',NULL,0,NULL,0),(_binary 'K70(ošK·—¯)ô\Ü*X\Ú','triple0','0','2022-06-24 20:23:15',NULL,0,NULL,0),(_binary 'bˆŸ&§rHÜŽ%ò©G\Ç5','triple0','0','2022-06-24 17:36:32',NULL,0,NULL,0),(_binary 'laò½¤\rD<€’\'E\çf«—','triple0','0','2022-06-24 20:26:03',NULL,0,NULL,0),(_binary 'qÏƒ)‡J‡c\n+“ð7®','triple0','0','2022-06-24 20:18:44',NULL,0,NULL,0),(_binary '‡o\"zž“G\à–\ÛU\×B\Ä','triple0','0','2022-06-24 20:30:28',NULL,0,NULL,0),(_binary 'D†Ý‚tLÙ§†“-\èC\Ý','triple0','0','2022-06-24 20:15:59',NULL,0,NULL,0),(_binary '–¼G`IR„ˆ\ËÃ°÷','triple0','0','2022-06-24 20:22:58',NULL,0,NULL,0),(_binary '—\à\îjIŠ§\Íü\ÊN¨','triple0','0','2022-06-24 20:50:55',NULL,0,NULL,0),(_binary '™‡Z\ØR@é¯Š\ç\'\Æl','triple0','0','2022-06-24 20:27:24',NULL,0,NULL,0),(_binary '‰,´À5BˆƒFWÑ¹','triple0','0','2022-06-24 20:49:51',NULL,0,NULL,0),(_binary '¡ Š2ŽI¯—‘@\ï\Ðmó','triple0','0','2022-06-24 20:19:35',NULL,0,NULL,0),(_binary '¾m\ÝtBP–zy’_·}','triple0','0','2022-06-24 20:21:27',NULL,0,NULL,0),(_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï','triple0','0','2022-06-24 20:29:13',NULL,0,NULL,0),(_binary 'À	³¥¼;F–,Aª@','triple0','0','2022-06-24 20:34:12',NULL,0,NULL,0),(_binary '\Æz\ïkDŠa\Ô&F‹d','triple0','0','2022-06-24 20:35:40',NULL,0,NULL,0),(_binary '\Ð\êG\Ô!FIDœ\é­@›H–x','triple0','0','2022-06-24 20:17:07',NULL,0,NULL,0),(_binary '\Ú9\ÜB\Þ\ÝL‘|\Z<VÁIO','triple0','0','2022-06-24 18:55:58',NULL,0,NULL,0),(_binary '\ç8Z‹%ÀBL… ž\Ð`—Œž','triple0','0','2022-06-24 18:23:29',NULL,0,NULL,0),(_binary '\éfžø?N3Š´VKg\ï','triple3150','7659','2022-06-24 20:58:28',NULL,0,NULL,0),(_binary 'û\Ù\ÄrÝ·NÚ²&\r\'nYY','triple5782','7079','2022-06-24 20:57:32',NULL,0,NULL,0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-06-25  6:18:54
