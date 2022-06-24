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
-- Table structure for table `attachedphoto`
--

DROP TABLE IF EXISTS `attachedphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachedphoto` (
  `attachedPhotoId` binary(16) NOT NULL,
  `attachedActivityType` int NOT NULL,
  `attachedActivityId` binary(16) NOT NULL,
  `uploadUserId` binary(16) NOT NULL,
  `uploadedDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isDeleted` tinyint(1) NOT NULL DEFAULT '0',
  `deletedDate` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`attachedPhotoId`),
  KEY `idx` (`attachedActivityId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachedphoto`
--

LOCK TABLES `attachedphoto` WRITE;
/*!40000 ALTER TABLE `attachedphoto` DISABLE KEYS */;
INSERT INTO `attachedphoto` VALUES (_binary '±( zO|’\Ì[\ÅÃ˜8z',1,_binary '±( zO|’\Ì[\ÅÃ˜8z',_binary '±( zO|’\Ì[\ÅÃ˜8z','2022-06-24 13:42:45',0,NULL),(_binary '±( zO|’\Ì[\ÅÃ˜8Œ',1,_binary '±( zO|’\Ì[\ÅÃ˜8Œ',_binary '±( zO|’\Ì[\ÅÃ˜8Œ','2022-06-24 13:42:45',0,NULL),(_binary '¥²¨¨O\ã©\Í[/ù',1,_binary '¥²¨¨O\ã©\Í[/ù',_binary '¥²¨¨O\ã©\Í[/ù','2022-06-24 16:37:11',0,NULL),(_binary '\rM£\İ/@•ºY-ú¬ˆ«ƒ',1,_binary 'LkUR@b!`O;\Ã@,',_binary 'D†İ‚tLÙ§†“-\èC\İ','2022-06-24 20:15:59',0,NULL),(_binary '`f¶\\EÁ¡|›Åª‡',1,_binary 'Ÿóü\è:L,¤\ëÿBr!\Ê',_binary '‰,´À5BˆƒFWÑ¹','2022-06-24 20:49:51',1,'2022-06-24 20:49:51'),(_binary '-XB$‰I·¨l\ãörD«',1,_binary '£f]Z•C0£ºığ€',_binary '>\Şò’·H¥óWSa÷E','2022-06-24 17:36:39',0,NULL),(_binary '0\Ö\å’WyI3ºÖ¯F\"V°',1,_binary 'È«L\î\å$B£­(\î\Ï\n‚÷',_binary 'K70(ošK·—¯)ô\Ü*X\Ú','2022-06-24 20:23:15',1,'2022-06-24 20:23:15'),(_binary '5\ç%¹`J,•>\Ï9dlú•',1,_binary '\\‰gk\ÄD„‘Á\è\éN‹ó',_binary '™‡Z\ØR@é¯Š\ç\'\Æl','2022-06-24 20:27:24',1,'2022-06-24 20:27:24'),(_binary '6egvYƒDTº\r\ß>¤f¸',1,_binary ')§ò_LÍ\Ş\È.(\éd4',_binary '¯7Jm„I”b\ÖÎ²','2022-06-24 20:50:39',1,'2022-06-24 20:50:39'),(_binary 'I)“n‰„Dş–$Y\Ñ Ó›',1,_binary '& ‚2\ØO4–ù\Z­]õ\æ',_binary '>\Şò’·H¥óWSa÷E','2022-06-24 17:42:26',0,NULL),(_binary 'V\Ö¹ğBX•Ö˜õØ‡\Í\Í',1,_binary 'h\Í7Æ§F<„¬-r\Ï\Õ-˜',_binary '\Ğ\êG\Ô!FIDœ\é­@›H–x','2022-06-24 20:17:07',0,NULL),(_binary 'Wº\Âø#BSºW±Ó†\Ë\ï²',1,_binary 'C0‘\ä±\àA\ê‚õ\ß\â;š²',_binary '‡o\"z“G\à–\ÛU\×B\Ä','2022-06-24 20:30:28',1,'2022-06-24 20:30:28'),(_binary 'W\êkY\Û\rOi•û÷¦\â€\â\Ä',1,_binary '+€?fü“B‚¡¾\Û\İ\êˆ+\Â',_binary '–¼G`IR„ˆ\ËÃ°÷','2022-06-24 20:22:58',1,'2022-06-24 20:22:58'),(_binary 'Z‚Qî†šOFœ48›\éw’',1,_binary ' \İÍƒŒC˜£a\\Ó¿ŒzS',_binary 'ÿc\ÚöWLò­7kW›µ`','2022-06-24 19:59:47',0,NULL),(_binary 'f™ûM&K©¬\ê\Ö šû',1,_binary 'Fƒ‰\ä&.D+£\rª\î”\Ğ0',_binary ';w\Ä\Ş\ÎA»¨¬b¤\Äh\È\Â','2022-06-24 20:31:26',1,'2022-06-24 20:31:26'),(_binary 'mA`p°O\ä•cjA\èc©;',1,_binary '*Ü„÷1\ÏNª¤3C£ox}z',_binary ';‡ùpD\ÉI(˜‰ùiQÈ³©','2022-06-24 20:39:09',1,'2022-06-24 20:39:09'),(_binary 'p„WIIAÔ¼e\à!‚\n‘',1,_binary ' kv\Øl$MŠ¿ûşK¿EG',_binary 'Jdn‹\Ì\ÆJ:©%­!\æRø\Ğ','2022-06-24 20:37:10',1,'2022-06-24 20:37:10'),(_binary 'u3(6™Ca¨[]½\"U\Üù',1,_binary 'QœR™^‡K.†‡Ê¸ÿ\é‰\r',_binary '¿\Ï~1ieI——\â\ïYŒ\Ì\Ï','2022-06-24 20:29:13',1,'2022-06-24 20:29:13'),(_binary 'wfT\ç€N‚“‘ö \Ë\0‰H',1,_binary '\Ä\ÏkO}œ8m',_binary 'laò½¤\rD<€’\'E\çf«—','2022-06-24 20:26:03',1,'2022-06-24 20:26:03'),(_binary '{;3\ÆU\rLªX\ç\æ‚K\İJ',1,_binary '5&(>\ËD­‚`˜‹’S¸',_binary 'qÏƒ)‡J‡c\n+“ğ7®','2022-06-24 20:18:44',1,'2022-06-24 20:18:44'),(_binary '•y\ßbBÖ§»û/]\ß\Å',1,_binary '\Ù#\à6\È AmÀ±\n\Ş4<',_binary '¡ Š2I¯—‘@\ï\Ğmó','2022-06-24 20:19:35',1,'2022-06-24 20:19:35'),(_binary 'Œ\Ò[\ëxHNª‹f\İ*Q\Ş\'Á',1,_binary '\Ë,ü	”sLL¥ò^¦S´',_binary '\Æz\ïkDŠa\Ô&F‹d','2022-06-24 20:35:40',1,'2022-06-24 20:35:40'),(_binary '—\ëš}¬Iñ¹è‡±”mQ.',1,_binary '?\î\Æ\Ú5OÉš\á€\Ì&wµ',_binary '«ÀŸI®\Î\ÙÁ(şŒ','2022-06-24 20:17:54',0,NULL),(_binary '¤€8‹C[€\Â\Æl¼<\Ñ',1,_binary '&h\Z‹,ıOu¦Jr\Å$\Å',_binary '	.şÕ¢MÄª+\\\\ˆ\0\áv','2022-06-24 20:58:05',1,'2022-06-24 20:58:05'),(_binary '­³\Ã\0\×N-§T^Š\n£',1,_binary '5w:¸ eH‚Qy\Äp·',_binary '—\à\îjIŠ§\Íü\ÊN¨','2022-06-24 20:50:55',1,'2022-06-24 20:50:55'),(_binary '¯°\Îò…JP»œÁ\\½\Ã2',1,_binary '$\nX\Ü_Hx“ë·²fwr',_binary '>\Şò’·H¥óWSa÷E','2022-06-24 13:43:54',0,NULL),(_binary '½½,U  H„²¹·[\à2\0š',1,_binary 'œ\Ò(z•Dı®KX	ƒ\Å',_binary ':Ø¸ƒ\"‹EÒ¤È®&¸|\á','2022-06-24 20:00:06',0,NULL),(_binary 'À¥¯<\ÅHJŠº\ÄÀó=aQ',1,_binary '\âkPA\'˜Ù½x½\Õ\æ¸',_binary '¾m\İtBP–zy’_·}','2022-06-24 20:21:27',1,'2022-06-24 20:21:27'),(_binary 'À·\Z\è+\ÕB]€sPPd\ï¼',1,_binary 'ÿ\"\ÌD§J3–ñ\É|Aó2\à',_binary '\éfø?N3Š´VKg\ï','2022-06-24 20:58:28',1,'2022-06-24 20:58:28'),(_binary '\Éni.!Eö‘j±”JqË',1,_binary '`X~½U\àF\ç’r8Ì†ÁÙ•',_binary '“\ZH\ë\ÆO<‚H}\0M‰\Ã','2022-06-24 20:15:59',0,NULL),(_binary '\Ğ\îHY§*@Z½¥ş©\è2o•',1,_binary '˜ä›„mEÒ„ş’C¾OœQ',_binary 'À	³¥¼;F–,Aª@','2022-06-24 20:34:12',0,NULL),(_binary '\äÑ¦N¥1FŞˆ\Ğÿ\×¸',1,_binary '$\nX\Ü_Hx“ë·²fwr',_binary '>\Şò’·H¥óWSa÷E','2022-06-24 13:43:54',0,NULL),(_binary '\è\ãÁÁ3ùEï–¿~fX2',1,_binary 'ş\éX¤|Iª‰3UE\Ş\ì',_binary 'û\Ù\Ärİ·NÚ²&\r\'nYY','2022-06-24 20:57:32',0,NULL),(_binary '\é\rKôAöN-”–Gœß„',1,_binary 'xŒÏˆ\ĞòA\\‡r9b6õ(',_binary 'h`«\ÃaE£„=7\Ç','2022-06-24 20:37:37',1,'2022-06-24 20:37:37'),(_binary '\ê¿\ìx`IZ§XÀaa¿	',1,_binary '\ê¿\ìx`IZ§XÀaa¿	',_binary '\ê¿\ìx`IZ§XÀaa¿	','2022-06-24 16:35:13',0,NULL);
/*!40000 ALTER TABLE `attachedphoto` ENABLE KEYS */;
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
