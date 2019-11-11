--
-- Script was generated by Devart dbForge Studio 2019 for MySQL, Version 8.2.23.0
-- Product home page: http://www.devart.com/dbforge/mysql/studio
-- Script date 15/10/2019 20:16:25
-- Server version: 8.0.13
-- Client version: 4.1
--

-- 
-- Disable foreign keys
-- 
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;

-- 
-- Set SQL mode
-- 
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Drop table `fornecedores`
--
DROP TABLE IF EXISTS fornecedores;

--
-- Drop table `movimentacao_produto`
--
DROP TABLE IF EXISTS movimentacao_produto;

--
-- Drop table `produto`
--
DROP TABLE IF EXISTS produto;

--
-- Create table `produto`
--
CREATE TABLE produto (
  idProduto INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  descricao TEXT DEFAULT NULL,
  marca TEXT DEFAULT NULL,
  PRIMARY KEY (idProduto)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Create table `movimentacao_produto`
--
CREATE TABLE movimentacao_produto (
  idMovimentacao INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  tipo INT(11) DEFAULT NULL,
  idProduto INT(11) UNSIGNED NOT NULL,
  quantidade DECIMAL(10, 0) DEFAULT NULL,
  PRIMARY KEY (idMovimentacao)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

--
-- Create foreign key
--
ALTER TABLE movimentacao_produto 
  ADD CONSTRAINT movimentacao_produto_ibfk_1 FOREIGN KEY (idProduto)
    REFERENCES produto(idproduto);

--
-- Create table `fornecedores`
--
CREATE TABLE fornecedores (
  idFornecedor INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  nome TEXT DEFAULT NULL,
  cpf_cnpj TEXT DEFAULT NULL,
  endereco TEXT DEFAULT NULL,
  telefone TEXT DEFAULT NULL,
  PRIMARY KEY (idFornecedor)
)
ENGINE = INNODB,
CHARACTER SET utf8,
COLLATE utf8_general_ci;

-- 
-- Dumping data for table produto
--
-- Table estoque_aula.produto does not contain any data (it is empty)

-- 
-- Dumping data for table movimentacao_produto
--
-- Table estoque_aula.movimentacao_produto does not contain any data (it is empty)

-- 
-- Dumping data for table fornecedores
--
-- Table estoque_aula.fornecedores does not contain any data (it is empty)

-- 
-- Restore previous SQL mode
-- 
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;

-- 
-- Enable foreign keys
-- 
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;