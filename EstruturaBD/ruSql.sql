-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: 23/06/2016 às 02:23
-- Versão do servidor: 5.5.49-0ubuntu0.14.04.1
-- Versão do PHP: 5.5.9-1ubuntu4.17

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de dados: `ruSql`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `Consumidor`
--

CREATE TABLE IF NOT EXISTS `Consumidor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `grr` varchar(11) DEFAULT NULL,
  `Modalidade_id` int(11) DEFAULT NULL,
  `Vinculo_id` int(11) DEFAULT NULL,
  `Credito_id` int(11) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_Consumidor_Modalidade_idx` (`Modalidade_id`),
  KEY `fk_Consumidor_Vinculo1_idx` (`Vinculo_id`),
  KEY `fk_Consumidor_Credito1_idx` (`Credito_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=29 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Credito`
--

CREATE TABLE IF NOT EXISTS `Credito` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `saldo` mediumtext NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Modalidade`
--

CREATE TABLE IF NOT EXISTS `Modalidade` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=34 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `Vinculo`
--

CREATE TABLE IF NOT EXISTS `Vinculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `ativo` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=25 ;

-- --------------------------------------------------------

--
-- Estrutura para tabela `VinculosBloqueados`
--

CREATE TABLE IF NOT EXISTS `VinculosBloqueados` (
  `Vinculo_id` int(11) NOT NULL,
  `Modalidade_id` int(11) NOT NULL,
  PRIMARY KEY (`Vinculo_id`,`Modalidade_id`),
  KEY `fk_VinculosBloqueados_Modalidade1_idx` (`Modalidade_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Restrições para dumps de tabelas
--

--
-- Restrições para tabelas `Consumidor`
--
ALTER TABLE `Consumidor`
  ADD CONSTRAINT `fk_Consumidor_Credito1` FOREIGN KEY (`Credito_id`) REFERENCES `Credito` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Consumidor_Modalidade` FOREIGN KEY (`Modalidade_id`) REFERENCES `Modalidade` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Consumidor_Vinculo1` FOREIGN KEY (`Vinculo_id`) REFERENCES `Vinculo` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Restrições para tabelas `VinculosBloqueados`
--
ALTER TABLE `VinculosBloqueados`
  ADD CONSTRAINT `fk_VinculosBloqueados_Modalidade1` FOREIGN KEY (`Modalidade_id`) REFERENCES `Modalidade` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_VinculosBloqueados_Vinculo1` FOREIGN KEY (`Vinculo_id`) REFERENCES `Vinculo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
