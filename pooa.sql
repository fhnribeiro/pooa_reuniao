-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           10.1.25-MariaDB - mariadb.org binary distribution
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para pooa
CREATE DATABASE IF NOT EXISTS `pooa` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `pooa`;

-- Copiando estrutura para tabela pooa.equipamento
CREATE TABLE IF NOT EXISTS `equipamento` (
  `idEquipamento` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) NOT NULL,
  PRIMARY KEY (`idEquipamento`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.equipamento: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `equipamento` DISABLE KEYS */;
INSERT IGNORE INTO `equipamento` (`idEquipamento`, `Descricao`) VALUES
	(1, 'Equipamento 1'),
	(2, 'Equipamento 2'),
	(3, 'Equipamento 3'),
	(4, 'Equipamento 4'),
	(5, 'Equipamento 5');
/*!40000 ALTER TABLE `equipamento` ENABLE KEYS */;

-- Copiando estrutura para tabela pooa.funcionario
CREATE TABLE IF NOT EXISTS `funcionario` (
  `idFuncionario` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) NOT NULL,
  `Cargo` varchar(255) DEFAULT NULL,
  `Login` varchar(45) NOT NULL,
  `Senha` varchar(45) NOT NULL,
  PRIMARY KEY (`idFuncionario`),
  UNIQUE KEY `Login_UNIQUE` (`Login`),
  UNIQUE KEY `Senha_UNIQUE` (`Senha`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.funcionario: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT IGNORE INTO `funcionario` (`idFuncionario`, `Nome`, `Cargo`, `Login`, `Senha`) VALUES
	(1, 'Admin', 'Administrador', 'admin', 'admin'),
	(2, 'Funcionario 1', 'Cargo', 'funcionario1', 'func1'),
	(3, 'Funcionario 2', 'Cargo', 'funcionario2', 'func2'),
	(4, 'Funcionario 3', 'Cargo', 'funcionario3', 'func3'),
	(5, 'Funcionario 4', 'Cargo', 'funcionario4', 'func4'),
	(6, 'Funcionario 5', 'Cargo', 'funcionario5', 'func5');
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;

-- Copiando estrutura para tabela pooa.participante
CREATE TABLE IF NOT EXISTS `participante` (
  `Reserva` int(11) NOT NULL,
  `Funcionario` int(11) NOT NULL,
  `AceitouAta` int(11) DEFAULT NULL,
  PRIMARY KEY (`Reserva`,`Funcionario`),
  KEY `fk_Reserva_has_Funcionario_Funcionario1_idx` (`Funcionario`),
  KEY `fk_Reserva_has_Funcionario_Reserva1_idx` (`Reserva`),
  CONSTRAINT `fk_Reserva_has_Funcionario_Funcionario1` FOREIGN KEY (`Funcionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_has_Funcionario_Reserva1` FOREIGN KEY (`Reserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.participante: ~18 rows (aproximadamente)
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT IGNORE INTO `participante` (`Reserva`, `Funcionario`, `AceitouAta`) VALUES
	(23, 1, NULL),
	(24, 1, NULL),
	(25, 1, NULL),
	(26, 1, NULL),
	(27, 1, NULL),
	(28, 1, NULL),
	(29, 1, NULL),
	(30, 1, NULL),
	(31, 1, NULL),
	(32, 1, NULL),
	(33, 1, NULL),
	(34, 1, NULL),
	(35, 1, NULL),
	(36, 1, NULL),
	(38, 1, NULL),
	(39, 1, 1),
	(39, 2, NULL),
	(39, 3, NULL);
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;

-- Copiando estrutura para tabela pooa.reserva
CREATE TABLE IF NOT EXISTS `reserva` (
  `idReserva` int(11) NOT NULL AUTO_INCREMENT,
  `Sala` int(11) NOT NULL,
  `Data` datetime NOT NULL,
  `Pauta` longtext,
  `Ata` longtext,
  `Funcionario` int(11) NOT NULL,
  `DataFim` datetime NOT NULL,
  `Status` int(11) DEFAULT NULL,
  PRIMARY KEY (`idReserva`),
  KEY `fk_Reserva_Sala_idx` (`Sala`),
  KEY `fk_Reserva_Funcionario1_idx` (`Funcionario`),
  CONSTRAINT `fk_Reserva_Funcionario1` FOREIGN KEY (`Funcionario`) REFERENCES `funcionario` (`idFuncionario`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reserva_Sala` FOREIGN KEY (`Sala`) REFERENCES `sala` (`idSala`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.reserva: ~16 rows (aproximadamente)
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT IGNORE INTO `reserva` (`idReserva`, `Sala`, `Data`, `Pauta`, `Ata`, `Funcionario`, `DataFim`, `Status`) VALUES
	(23, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(24, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(25, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(26, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(27, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(28, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(29, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(30, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(31, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(32, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(33, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(34, 4, '2019-04-26 09:00:00', NULL, NULL, 3, '2019-04-26 10:00:00', 1),
	(35, 4, '2019-04-26 09:00:00', NULL, NULL, 1, '2019-04-26 10:00:00', 1),
	(36, 1, '2019-04-24 09:00:00', NULL, NULL, 1, '2019-04-24 10:00:00', 1),
	(38, 4, '2019-04-24 14:00:00', NULL, NULL, 1, '2019-04-24 14:30:00', 1),
	(39, 1, '2019-04-23 09:30:00', 'Lorem', NULL, 1, '2019-04-23 10:30:00', 2);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;

-- Copiando estrutura para tabela pooa.reservaequipamento
CREATE TABLE IF NOT EXISTS `reservaequipamento` (
  `idReservaEquipamento` int(11) NOT NULL AUTO_INCREMENT,
  `Equipamento` int(11) NOT NULL,
  `Reserva` int(11) NOT NULL,
  PRIMARY KEY (`idReservaEquipamento`),
  KEY `fk_ReservaEquipamento_Equipamento1_idx` (`Equipamento`),
  KEY `fk_ReservaEquipamento_Reserva1_idx` (`Reserva`),
  CONSTRAINT `fk_ReservaEquipamento_Equipamento1` FOREIGN KEY (`Equipamento`) REFERENCES `equipamento` (`idEquipamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_ReservaEquipamento_Reserva1` FOREIGN KEY (`Reserva`) REFERENCES `reserva` (`idReserva`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.reservaequipamento: ~15 rows (aproximadamente)
/*!40000 ALTER TABLE `reservaequipamento` DISABLE KEYS */;
INSERT IGNORE INTO `reservaequipamento` (`idReservaEquipamento`, `Equipamento`, `Reserva`) VALUES
	(6, 4, 23),
	(7, 4, 24),
	(8, 4, 25),
	(9, 4, 26),
	(10, 4, 27),
	(11, 4, 28),
	(12, 4, 29),
	(13, 4, 30),
	(14, 4, 31),
	(15, 4, 32),
	(16, 4, 33),
	(17, 4, 34),
	(18, 4, 35),
	(19, 2, 36),
	(21, 3, 39);
/*!40000 ALTER TABLE `reservaequipamento` ENABLE KEYS */;

-- Copiando estrutura para tabela pooa.sala
CREATE TABLE IF NOT EXISTS `sala` (
  `idSala` int(11) NOT NULL AUTO_INCREMENT,
  `Descricao` varchar(255) NOT NULL,
  `Capacidade` int(11) NOT NULL,
  PRIMARY KEY (`idSala`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Copiando dados para a tabela pooa.sala: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `sala` DISABLE KEYS */;
INSERT IGNORE INTO `sala` (`idSala`, `Descricao`, `Capacidade`) VALUES
	(1, 'Sala 1', 6),
	(2, 'Sala 2', 6),
	(3, 'Sala 3', 10),
	(4, 'Sala 4', 14),
	(5, 'Sala 5', 10);
/*!40000 ALTER TABLE `sala` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
