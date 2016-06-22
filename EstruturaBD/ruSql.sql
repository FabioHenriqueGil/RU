-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u1build0.15.04.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 22-Jun-2016 às 16:37
-- Versão do servidor: 5.6.28-0ubuntu0.15.04.1
-- PHP Version: 5.6.4-4ubuntu6.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ruSql`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `Consumidor`
--

CREATE TABLE IF NOT EXISTS `Consumidor` (
`id` int(11) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `grr` varchar(11) DEFAULT NULL,
  `Modalidade_id` int(11) NOT NULL,
  `Vinculo_id` int(11) NOT NULL,
  `Credito_id` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Credito`
--

CREATE TABLE IF NOT EXISTS `Credito` (
`id` int(11) NOT NULL,
  `saldo` mediumtext NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Modalidade`
--

CREATE TABLE IF NOT EXISTS `Modalidade` (
`id` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `Vinculo`
--

CREATE TABLE IF NOT EXISTS `Vinculo` (
`id` int(11) NOT NULL,
  `descricao` varchar(45) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1'
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `VinculosBloqueados`
--

CREATE TABLE IF NOT EXISTS `VinculosBloqueados` (
  `Vinculo_id` int(11) NOT NULL,
  `Modalidade_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Consumidor`
--
ALTER TABLE `Consumidor`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id_UNIQUE` (`id`), ADD KEY `fk_Consumidor_Modalidade_idx` (`Modalidade_id`), ADD KEY `fk_Consumidor_Vinculo1_idx` (`Vinculo_id`), ADD KEY `fk_Consumidor_Credito1_idx` (`Credito_id`);

--
-- Indexes for table `Credito`
--
ALTER TABLE `Credito`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `Modalidade`
--
ALTER TABLE `Modalidade`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `Vinculo`
--
ALTER TABLE `Vinculo`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `VinculosBloqueados`
--
ALTER TABLE `VinculosBloqueados`
 ADD PRIMARY KEY (`Vinculo_id`,`Modalidade_id`), ADD KEY `fk_VinculosBloqueados_Modalidade1_idx` (`Modalidade_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Consumidor`
--
ALTER TABLE `Consumidor`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT for table `Credito`
--
ALTER TABLE `Credito`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `Modalidade`
--
ALTER TABLE `Modalidade`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT for table `Vinculo`
--
ALTER TABLE `Vinculo`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=19;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `Consumidor`
--
ALTER TABLE `Consumidor`
ADD CONSTRAINT `fk_Consumidor_Credito1` FOREIGN KEY (`Credito_id`) REFERENCES `Credito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Consumidor_Modalidade` FOREIGN KEY (`Modalidade_id`) REFERENCES `Modalidade` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
ADD CONSTRAINT `fk_Consumidor_Vinculo1` FOREIGN KEY (`Vinculo_id`) REFERENCES `Vinculo` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Limitadores para a tabela `VinculosBloqueados`
--
ALTER TABLE `VinculosBloqueados`
ADD CONSTRAINT `fk_VinculosBloqueados_Modalidade1` FOREIGN KEY (`Modalidade_id`) REFERENCES `Modalidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_VinculosBloqueados_Vinculo1` FOREIGN KEY (`Vinculo_id`) REFERENCES `Vinculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
