CREATE DATABASE  IF NOT EXISTS `olympic_fisio` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `olympic_fisio`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: olympic_fisio
-- ------------------------------------------------------
-- Server version	8.0.30

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id_cita` int NOT NULL AUTO_INCREMENT,
  `fecha_cita` date NOT NULL,
  `hora_cita` varchar(45) NOT NULL,
  `especialista` int NOT NULL,
  `disponible` int NOT NULL,
  `observaciones` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `especialista` (`especialista`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`especialista`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES (5,'2023-06-05','16:30',2,1,'-'),(6,'2023-06-18','18.00',7,1,''),(10,'2023-05-14','17.00',7,1,'-'),(11,'2023-05-13','11.00',7,1,'-'),(12,'2023-05-13','11.00',7,1,'-'),(13,'2023-06-21','10.00',7,1,'Esta cita es para masajes');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `familias`
--

DROP TABLE IF EXISTS `familias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `familias` (
  `id_familia` int NOT NULL AUTO_INCREMENT,
  `nombre_familia` varchar(45) NOT NULL,
  `descripcion_familia` varchar(300) NOT NULL,
  `img` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_familia`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `familias`
--

LOCK TABLES `familias` WRITE;
/*!40000 ALTER TABLE `familias` DISABLE KEYS */;
INSERT INTO `familias` VALUES (1,'Terapia Manual','Tratamientos manuales','../images/fisioterapiageneral.jpg'),(2,'Electroterapia','Tratamientos con electroestimulación','../images/acutomo.jpg'),(3,'Masajes','Masajes terapéuticos','../images/diatermia2.jpg'),(5,'Terapia Respiratoria','Tratamientos para mejorar la función respiratoria','../images/respiratorio.jpg'),(6,'Rehabilitación Neurológica','Tratamientos para recuperar funciones neurológicas','../images/neuro.jpg'),(7,'Pilates Terapéutico','Ejercicios de pilates adaptados para rehabilitación','../images/pilates.jpg');
/*!40000 ALTER TABLE `familias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `id_producto` int NOT NULL AUTO_INCREMENT,
  `nombre_producto` varchar(45) NOT NULL,
  `precio` int NOT NULL,
  `descripcion` varchar(300) NOT NULL,
  `id_familia` int NOT NULL,
  `imgpro` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_producto`),
  KEY `id_familia` (`id_familia`),
  CONSTRAINT `productos_ibfk_1` FOREIGN KEY (`id_familia`) REFERENCES `familias` (`id_familia`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (2,'Vendaje Neuromuscular',25,'Vendaje elástico para soporte muscular',1,NULL),(3,'Electrodo Autoadhesivo',5,'Electrodos para electroterapia',2,NULL),(4,'Pelota de Ejercicios',30,'Pelota de ejercicio para fortalecimiento muscular',3,NULL),(5,'Crema Caliente',15,'Crema para aplicar calor en áreas afectadas',1,NULL),(6,'Electrodo de Acupuntura',8,'Electrodos para acupuntura y estimulación nerviosa',2,NULL),(7,'Pelota de Masaje',20,'Pelota con texturas para masajes de liberación miofascial',3,NULL),(11,'Aceite de Masaje',15,'Aceite para masajes terapéuticos',1,NULL),(12,'Vendaje Neuromuscular',10,'Vendaje elástico para soporte muscular',1,NULL),(13,'Pelota de Ejercicios',20,'Pelota de ejercicio para fortalecimiento muscular',1,NULL),(14,'Electroestimulador',150,'Aparato de electroterapia',2,NULL),(15,'Electrodos Autoadhesivos',10,'Electrodos para electroterapia',2,NULL),(16,'TENS',80,'Aparato de estimulación nerviosa transcutánea',2,NULL),(17,'Crema de Masaje',12,'Crema para masajes relajantes',3,NULL),(18,'Rodillo de Masaje',25,'Rodillo con relieve para masajes profundos',3,NULL),(19,'Aceite Esencial',18,'Aceite aromático para masajes',3,NULL),(20,'Incentivador Respiratorio',30,'Dispositivo para ejercicios respiratorios',5,NULL),(21,'Nebulizador Portátil',50,'Nebulizador para medicación respiratoria',5,NULL),(22,'Espaciador Inhalador',15,'Accesorio para la administración de medicamentos inhalados',5,NULL),(23,'Pelota de Equilibrio',40,'Pelota para ejercicios de equilibrio',6,NULL),(24,'Tablero de Coordinación',55,'Tablero para ejercicios de coordinación motora',6,NULL),(25,'Banda Elástica de Resistencia',20,'Banda elástica para ejercicios de fortalecimiento neuromuscular',6,NULL),(26,'Pelota de Pilates',35,'Pelota de pilates para ejercicios de estabilidad',7,NULL),(27,'Aro de Pilates',30,'Aro para ejercicios de tonificación muscular',7,NULL),(28,'Banda de Estiramiento',15,'Banda elástica para ejercicios de estiramiento',7,NULL);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reserva` int NOT NULL AUTO_INCREMENT,
  `observaciones_resevas` varchar(300) DEFAULT NULL,
  `id_cita` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `id_usuario` (`id_usuario`),
  KEY `ID_CITA` (`id_cita`),
  CONSTRAINT `ID_CITA` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id_cita`) ON DELETE CASCADE,
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id_cita`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `id_rol` int NOT NULL AUTO_INCREMENT,
  `nombre_rol` varchar(45) NOT NULL,
  PRIMARY KEY (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
INSERT INTO `roles` VALUES (1,'Administrador'),(2,'Especialista'),(3,'Cliente');
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(45) NOT NULL,
  `apellidos_usuario` varchar(45) NOT NULL,
  `email_usuario` varchar(45) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sociedad_medica` varchar(100) DEFAULT NULL,
  `enabled` int NOT NULL,
  `id_rol` int DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `email_usuario` (`email_usuario`),
  KEY `id_rol` (`id_rol`),
  CONSTRAINT `usuarios_ibfk_1` FOREIGN KEY (`id_rol`) REFERENCES `roles` (`id_rol`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Administrador','Administrador','administrador@gmail.com','2023-04-24','123456789','$2a$10$ltytA2AViKxeVdyJ64LvsePIdaKCwOBvpCM/orZvfjxij7nc91cmK','Adeslas',1,1),(2,'Juan','Pérez','juan@example.com','1985-03-12','915056489','$2a$10$xNdj2.O87h.WZ1VZvMP0K.2SFbcm6g1BU5vTGKhium05psWQhom4G','Seguros Médicos',1,2),(6,'Jesús','Raboso Cruz','jesus.rc93@gmail.com','2023-05-02','600032496','$2a$10$eHV4r86r7hwacWu1x1j9ae6LM/E6fUhSEtMFYjzzuLF3wo7C.b3bi','Sanitas',1,3),(7,'Fisio','Fisio','fisio@gmail.com','2023-05-04','916568423','$2a$10$VI8g7ZulWjRfCpQnv4SwOexVGSHfaTEFtZhg/.QaMYJ7JEyLmrfIO','Adeslas',1,2);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-01 18:46:36
