-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 09-Dez-2018 às 17:15
-- Versão do servidor: 10.1.30-MariaDB
-- PHP Version: 7.1.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `barihosh`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `caixa`
--

CREATE TABLE `caixa` (
  `id_caixa` bigint(20) NOT NULL,
  `data_abertura` date DEFAULT NULL,
  `data_fechamento` date DEFAULT NULL,
  `statusCaixa` varchar(255) DEFAULT NULL,
  `valorAbertura` float DEFAULT NULL,
  `valorFechamento` float DEFAULT NULL,
  `valorTotal` float DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `categoria_produto`
--

CREATE TABLE `categoria_produto` (
  `id_categoria` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `categoria_produto`
--

INSERT INTO `categoria_produto` (`id_categoria`, `descricao`) VALUES
(1, 'Refrigerante'),
(2, 'Hosh'),
(3, 'Comida'),
(4, 'Cigarro'),
(5, 'Cerveja');

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `id_cliente` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `observacao` varchar(255) DEFAULT NULL,
  `id_pessoa` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id_cliente`, `ativo`, `observacao`, `id_pessoa`) VALUES
(1, b'1', NULL, 6),
(2, b'1', NULL, 7),
(3, b'1', NULL, 8),
(4, b'1', NULL, 9),
(5, b'1', NULL, 10);

-- --------------------------------------------------------

--
-- Estrutura da tabela `comada`
--

CREATE TABLE `comada` (
  `id_comanda` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `data` date NOT NULL,
  `valorTotal` float NOT NULL,
  `id_cliente` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `despesa`
--

CREATE TABLE `despesa` (
  `id_despesa` bigint(20) NOT NULL,
  `dataCricacaoDespesa` date DEFAULT NULL,
  `valorTotalDespesa` float NOT NULL,
  `id_comanda` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `endereco`
--

CREATE TABLE `endereco` (
  `id_endereco` bigint(20) NOT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `cep` varchar(255) DEFAULT NULL,
  `cidade` varchar(255) DEFAULT NULL,
  `complemento` varchar(255) DEFAULT NULL,
  `endereco` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `pais` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `endereco`
--

INSERT INTO `endereco` (`id_endereco`, `bairro`, `cep`, `cidade`, `complemento`, `endereco`, `estado`, `pais`) VALUES
(1, 'centro', '74013040', 'goiania', 'rua', 'administrador', 'goias', 'brasil'),
(2, 'Vila Brasilia', '74905-670', 'Aparecida de Goiania', 'N 11 -   - GO, 74905-670', 'R. Sapucaí', 'Goias', 'Brasil'),
(3, 'Setor das Nações', '74493-835', 'Goiania', 'S/N', 'Avenida Leopoldo de Bulhões', 'Goiás', 'Brasil'),
(4, 'Jardim Bela Vista', '74863-160', 'Goiânia', 'nº 666 edf: belzebox apt 13', 'Rua das Paineiras', 'goiás', 'Brasil'),
(5, 'vitoria', '74850-510', 'Goiania', 'sem numero', 'rua direita', 'Goias', 'Brasil'),
(6, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(7, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(9, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(10, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, 'Ilda', '75013040', 'Goiania', 'Casa 6', 'Av dona maria cardoso', 'Goias', 'Brasil');

-- --------------------------------------------------------

--
-- Estrutura da tabela `estoque`
--

CREATE TABLE `estoque` (
  `id_estoque` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `data_criacao` date DEFAULT NULL,
  `data_finalizacao` date DEFAULT NULL,
  `data_validade_lote` date DEFAULT NULL,
  `qtd_produto` int(11) DEFAULT NULL,
  `saldoEstoque` float NOT NULL,
  `id_estoque_produto` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `estoque`
--

INSERT INTO `estoque` (`id_estoque`, `ativo`, `data_criacao`, `data_finalizacao`, `data_validade_lote`, `qtd_produto`, `saldoEstoque`, `id_estoque_produto`) VALUES
(1, b'1', '2018-12-08', NULL, '2022-12-12', 500, 250, 1),
(2, b'1', '2018-12-09', NULL, '2022-12-12', 40, 2022, 2),
(3, b'1', '2018-12-09', NULL, '2022-12-12', 40, 119.6, 3),
(4, b'1', '2018-12-09', NULL, '2022-12-12', 500, 2250, 4),
(5, b'1', '2018-12-09', NULL, '2022-12-12', 60, 180, 5);

-- --------------------------------------------------------

--
-- Estrutura da tabela `fabricante`
--

CREATE TABLE `fabricante` (
  `id_fabricante` bigint(20) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `nomeFantasia` varchar(255) DEFAULT NULL,
  `razaoSocial` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fabricante`
--

INSERT INTO `fabricante` (`id_fabricante`, `cnpj`, `nomeFantasia`, `razaoSocial`) VALUES
(1, '99.496.811/0001-92', 'Essencias rosh', 'Larissa e Ayla Essencias Ltda'),
(2, '05.105.575/0001-92', 'Chopp 10', 'Sophie e Rafael Ltda'),
(3, '37.466.821/0001-28', 'Palheiros Souza', 'Maya artesanais'),
(4, '45.997.418/0001-53', 'Refrigerantes Bandeirante', 'Coca-Cola Indústrias Ltda');

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedor`
--

CREATE TABLE `fornecedor` (
  `id_fornecedor` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `cnpj` varchar(255) DEFAULT NULL,
  `numInscricao` varchar(255) DEFAULT NULL,
  `ramoAtividade` varchar(255) DEFAULT NULL,
  `razao` varchar(255) DEFAULT NULL,
  `id_pessoa` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `fornecedor`
--

INSERT INTO `fornecedor` (`id_fornecedor`, `ativo`, `cnpj`, `numInscricao`, `ramoAtividade`, `razao`, `id_pessoa`) VALUES
(1, b'1', NULL, '05105575000192', 'Itens', 'Frabica Coca', 11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `grupoproduto`
--

CREATE TABLE `grupoproduto` (
  `idGrupoProduto` bigint(20) NOT NULL,
  `tipoproduto` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `itemcomanda`
--

CREATE TABLE `itemcomanda` (
  `id_itemComanda` bigint(20) NOT NULL,
  `quantidade` int(11) DEFAULT NULL,
  `valorTotal` float NOT NULL,
  `valorUnitario` float NOT NULL,
  `id_comanda` bigint(20) DEFAULT NULL,
  `id_produto` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `log_estoque`
--

CREATE TABLE `log_estoque` (
  `id_log_estoque` bigint(20) NOT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `dt_movimentacao` date DEFAULT NULL,
  `tipo_movimentacao` varchar(255) DEFAULT NULL,
  `id_estoque` bigint(20) NOT NULL,
  `id_usuariomovimentador` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `log_estoque`
--

INSERT INTO `log_estoque` (`id_log_estoque`, `descricao`, `dt_movimentacao`, `tipo_movimentacao`, `id_estoque`, `id_usuariomovimentador`) VALUES
(1, 'CRIACAO DE ESTOQUE PARA PRODUTO : ( 1 )', '2018-12-08', 'ENTRADA', 1, 1),
(2, 'CRIACAO DE ESTOQUE PARA PRODUTO : ( 2 )', '2018-12-09', 'ENTRADA', 2, 1),
(3, 'CRIACAO DE ESTOQUE PARA PRODUTO : ( 3 )', '2018-12-09', 'ENTRADA', 3, 1),
(4, 'CRIACAO DE ESTOQUE PARA PRODUTO : ( 4 )', '2018-12-09', 'ENTRADA', 4, 1),
(5, 'CRIACAO DE ESTOQUE PARA PRODUTO : ( 5 )', '2018-12-09', 'ENTRADA', 5, 1);

-- --------------------------------------------------------

--
-- Estrutura da tabela `marca`
--

CREATE TABLE `marca` (
  `id_marca` bigint(20) NOT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `id_fabricante` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `marca`
--

INSERT INTO `marca` (`id_marca`, `nome`, `id_fabricante`) VALUES
(1, 'Fanta', 4),
(2, 'Zomo Essencias', 1),
(3, 'Zion', 3),
(4, 'Brownie\'s Juca', 2);

-- --------------------------------------------------------

--
-- Estrutura da tabela `movimentacao`
--

CREATE TABLE `movimentacao` (
  `id_movimentacao` bigint(20) NOT NULL,
  `dataFinalMovimentacao` date DEFAULT NULL,
  `dataInicialMovimentacao` date DEFAULT NULL,
  `tipo_movimento` varchar(255) DEFAULT NULL,
  `id_caixa` bigint(20) DEFAULT NULL,
  `id_pagamento` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pagamento`
--

CREATE TABLE `pagamento` (
  `id` bigint(20) NOT NULL,
  `ValorTotal` float NOT NULL,
  `completamente_recebido` bit(1) NOT NULL,
  `desconto` float NOT NULL,
  `formaPagamento` varchar(255) DEFAULT NULL,
  `statusPagamento` varchar(255) DEFAULT NULL,
  `valorAcrescimo` float NOT NULL,
  `id_despesa` bigint(20) DEFAULT NULL,
  `id_usuario` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estrutura da tabela `pessoa`
--

CREATE TABLE `pessoa` (
  `id_pessoa` bigint(20) NOT NULL,
  `cpf` varchar(255) DEFAULT NULL,
  `dt_alteracao` date DEFAULT NULL,
  `dt_criacao` date DEFAULT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `id_usuario_criacao` bigint(20) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `rg` varchar(255) DEFAULT NULL,
  `sexo` varchar(255) DEFAULT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `id_endereco` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `pessoa`
--

INSERT INTO `pessoa` (`id_pessoa`, `cpf`, `dt_alteracao`, `dt_criacao`, `dt_nascimento`, `email`, `id_usuario_criacao`, `nome`, `rg`, `sexo`, `telefone`, `id_endereco`) VALUES
(1, '755.009.301-68', '2018-12-08', '2018-12-08', '1993-10-26', 'admin@admin', NULL, 'administrador', '57736', 'M', '62321242223', 1),
(2, '583.236.370-16', '2018-12-08', NULL, '1990-12-12', 'afonso@gmail.com', 1, 'Afonso Neto', '473121864', 'M', '(62)9826-89713', 2),
(3, '845.054.710-55', NULL, NULL, '2000-01-01', 'larissa.moon@gmail.com', 1, 'Larissa Mon', '238537122', 'F', '(62)3212-4567', 3),
(4, '307.850.510-31', NULL, NULL, '1945-07-10', 'jurandir4@ig.com.br', 1, 'Jurandir Fonseca Quarto de Queiroz', '404179654', 'M', '(62)9950-80141', 4),
(5, '153.794.220-47', NULL, NULL, '1954-12-01', 'naritchasan@gmail.com', 1, 'Nara Cláudia da Rosa', '248306091', 'F', '(62)9919-24223', 5),
(6, '931.715.940-05', NULL, '2018-12-08', '1990-01-01', NULL, 1, 'Clara Roseta', '122381269', 'F', NULL, 6),
(7, '419.240.270-03', NULL, '2018-12-08', '1993-10-26', NULL, 1, 'Aliandro Lobo Areta', '458980894', 'M', NULL, 7),
(8, '532.354.690-52', NULL, '2018-12-08', '1978-03-13', NULL, 1, 'Manuel Del Cel', '377319077', 'M', NULL, 8),
(9, '713.387.990-53', NULL, '2018-12-08', '1989-07-22', NULL, 1, 'Laís Inácio Xavier', '228536479', 'F', NULL, 9),
(10, '825.223.980-32', NULL, '2018-12-08', '1952-05-27', NULL, 1, 'Stevon Guele', '160301853', 'M', NULL, 10),
(11, '785.112.390-90', NULL, '2018-12-08', '1990-12-01', 'geral@gmail.com', 1, 'Distribuidora Geral', '785112390', 'M', '(62)9960-91878', 11);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

CREATE TABLE `produto` (
  `id_produto` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `codigo_barras` varchar(255) DEFAULT NULL,
  `data_alteracao` date DEFAULT NULL,
  `data_criacao` date DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `id_usuario_criacao` bigint(20) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `valorEntrada` float DEFAULT NULL,
  `valorSaida` float DEFAULT NULL,
  `id_categoria_produto` bigint(20) NOT NULL,
  `id_estoque_produto` bigint(20) DEFAULT NULL,
  `id_fornecedor` bigint(20) NOT NULL,
  `id_grupoProduto` bigint(20) DEFAULT NULL,
  `id_marca_produto` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id_produto`, `ativo`, `codigo_barras`, `data_alteracao`, `data_criacao`, `descricao`, `id_usuario_criacao`, `nome`, `valorEntrada`, `valorSaida`, `id_categoria_produto`, `id_estoque_produto`, `id_fornecedor`, `id_grupoProduto`, `id_marca_produto`) VALUES
(1, b'1', '1231231231234', '2018-12-08', '2018-12-08', 'Cigarro de Palha', 1, 'Palheiro', 0.5, 1, 4, 1, 1, NULL, 3),
(2, b'1', '142195562293', NULL, '2018-12-09', 'Essencia ABACAXI COM MENTA ZOMO', 1, 'Essencia ABACAXI COM MENTA', 50.55, 70.45, 2, 2, 1, NULL, 2),
(3, b'1', '1231231231111', NULL, '2018-12-09', 'Fanta Uva 2L', 1, 'Fanta Uva 2L', 2.99, 4.99, 1, 3, 1, NULL, 1),
(4, b'1', '123123', NULL, '2018-12-09', 'Papel alumino para hosh', 1, 'Papel Aluminio', 4.5, 6, 2, 4, 1, NULL, 3),
(5, b'1', '23412312', NULL, '2018-12-09', 'Carvão para narguile', 1, 'Carvão', 3, 4, 2, 5, 1, NULL, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` bigint(20) NOT NULL,
  `ativo` bit(1) NOT NULL,
  `login` varchar(255) DEFAULT NULL,
  `permissao` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `id_pessoa` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `ativo`, `login`, `permissao`, `senha`, `id_pessoa`) VALUES
(1, b'1', 'admin@admin', 'ROLE_ADMINISTRADOR', 'admin12345', 1),
(2, b'1', 'afonso@gmail.com', 'ROLE_USUARIO_CAIXA', '123456789', 2),
(3, b'1', 'larissa.moon@gmail.com', 'ROLE_USUARIO_GARCON', 'larissa12345', 3),
(4, b'1', 'jurandir4@ig.com.br', 'ROLE_USUARIO_GARCON', 'ironmaiden666', 4),
(5, b'1', 'naritchasan@gmail.com', 'ROLE_USUARIO_GARCON', '1234567890', 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `caixa`
--
ALTER TABLE `caixa`
  ADD PRIMARY KEY (`id_caixa`),
  ADD KEY `FK_3k4l8icqlte5k3sk3q2rcd37i` (`id_usuario`);

--
-- Indexes for table `categoria_produto`
--
ALTER TABLE `categoria_produto`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id_cliente`),
  ADD KEY `FK_10o8xikm9dkpckflumw1rdoga` (`id_pessoa`);

--
-- Indexes for table `comada`
--
ALTER TABLE `comada`
  ADD PRIMARY KEY (`id_comanda`),
  ADD KEY `FK_2a9rp5e2wgje2hqqjbtyd27qi` (`id_cliente`),
  ADD KEY `FK_ckfbce9561m28g377tca55qjp` (`id_usuario`);

--
-- Indexes for table `despesa`
--
ALTER TABLE `despesa`
  ADD PRIMARY KEY (`id_despesa`),
  ADD KEY `FK_medk2ex5q5tigk6rugc8kmytc` (`id_comanda`);

--
-- Indexes for table `endereco`
--
ALTER TABLE `endereco`
  ADD PRIMARY KEY (`id_endereco`);

--
-- Indexes for table `estoque`
--
ALTER TABLE `estoque`
  ADD PRIMARY KEY (`id_estoque`),
  ADD KEY `FK_tb8be7tjxydv5qf2ci1t0efbp` (`id_estoque_produto`);

--
-- Indexes for table `fabricante`
--
ALTER TABLE `fabricante`
  ADD PRIMARY KEY (`id_fabricante`);

--
-- Indexes for table `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD PRIMARY KEY (`id_fornecedor`),
  ADD KEY `FK_khamly97o1h6gwd91qe36jht2` (`id_pessoa`);

--
-- Indexes for table `grupoproduto`
--
ALTER TABLE `grupoproduto`
  ADD PRIMARY KEY (`idGrupoProduto`);

--
-- Indexes for table `itemcomanda`
--
ALTER TABLE `itemcomanda`
  ADD PRIMARY KEY (`id_itemComanda`),
  ADD KEY `FK_o41t7v8a17ivvnrt017hvj8a6` (`id_comanda`),
  ADD KEY `FK_b1b9xr0desavlf5fl49k88y50` (`id_produto`);

--
-- Indexes for table `log_estoque`
--
ALTER TABLE `log_estoque`
  ADD PRIMARY KEY (`id_log_estoque`),
  ADD KEY `FK_k384gh3y7on6blk2l7l32rr6y` (`id_estoque`),
  ADD KEY `FK_6bs7incafsynk5of2hwt0hovk` (`id_usuariomovimentador`);

--
-- Indexes for table `marca`
--
ALTER TABLE `marca`
  ADD PRIMARY KEY (`id_marca`),
  ADD KEY `FK_mvdpiwtad3pa9dkvbhnarb1nt` (`id_fabricante`);

--
-- Indexes for table `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD PRIMARY KEY (`id_movimentacao`),
  ADD KEY `FK_kc3s6lllxup6wc43tkonl2av` (`id_caixa`),
  ADD KEY `FK_jiodevqlvssn0ut5uhmnxhsr0` (`id_pagamento`);

--
-- Indexes for table `pagamento`
--
ALTER TABLE `pagamento`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_fw83axxuhxh70y0r9dfn6j6aq` (`id_despesa`),
  ADD KEY `FK_g0l8aok7vqpb8lsvt2x34thby` (`id_usuario`);

--
-- Indexes for table `pessoa`
--
ALTER TABLE `pessoa`
  ADD PRIMARY KEY (`id_pessoa`),
  ADD KEY `FK_h3253iuetkv2ql45d33viretg` (`id_endereco`);

--
-- Indexes for table `produto`
--
ALTER TABLE `produto`
  ADD PRIMARY KEY (`id_produto`),
  ADD KEY `FK_ck4rvygy9io57msntl7cadrne` (`id_categoria_produto`),
  ADD KEY `FK_hyod2rwy62u9rukn6eukayn7a` (`id_estoque_produto`),
  ADD KEY `FK_60uk2d6wcyipenpqb4sfw0sgs` (`id_fornecedor`),
  ADD KEY `FK_tkqaudhuom5sduvw02gmq2cwu` (`id_grupoProduto`),
  ADD KEY `FK_qqeneu6liwk47gw2qybunxxc` (`id_marca_produto`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`),
  ADD KEY `FK_9wnw55sajbeqbpd8fsjbna1ie` (`id_pessoa`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `caixa`
--
ALTER TABLE `caixa`
  MODIFY `id_caixa` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `categoria_produto`
--
ALTER TABLE `categoria_produto`
  MODIFY `id_categoria` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id_cliente` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `comada`
--
ALTER TABLE `comada`
  MODIFY `id_comanda` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `despesa`
--
ALTER TABLE `despesa`
  MODIFY `id_despesa` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `endereco`
--
ALTER TABLE `endereco`
  MODIFY `id_endereco` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `estoque`
--
ALTER TABLE `estoque`
  MODIFY `id_estoque` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `fabricante`
--
ALTER TABLE `fabricante`
  MODIFY `id_fabricante` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `fornecedor`
--
ALTER TABLE `fornecedor`
  MODIFY `id_fornecedor` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `grupoproduto`
--
ALTER TABLE `grupoproduto`
  MODIFY `idGrupoProduto` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `itemcomanda`
--
ALTER TABLE `itemcomanda`
  MODIFY `id_itemComanda` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `log_estoque`
--
ALTER TABLE `log_estoque`
  MODIFY `id_log_estoque` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `marca`
--
ALTER TABLE `marca`
  MODIFY `id_marca` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `movimentacao`
--
ALTER TABLE `movimentacao`
  MODIFY `id_movimentacao` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pagamento`
--
ALTER TABLE `pagamento`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `pessoa`
--
ALTER TABLE `pessoa`
  MODIFY `id_pessoa` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `produto`
--
ALTER TABLE `produto`
  MODIFY `id_produto` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `caixa`
--
ALTER TABLE `caixa`
  ADD CONSTRAINT `FK_3k4l8icqlte5k3sk3q2rcd37i` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `FK_10o8xikm9dkpckflumw1rdoga` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `comada`
--
ALTER TABLE `comada`
  ADD CONSTRAINT `FK_2a9rp5e2wgje2hqqjbtyd27qi` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id_cliente`),
  ADD CONSTRAINT `FK_ckfbce9561m28g377tca55qjp` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `despesa`
--
ALTER TABLE `despesa`
  ADD CONSTRAINT `FK_medk2ex5q5tigk6rugc8kmytc` FOREIGN KEY (`id_comanda`) REFERENCES `comada` (`id_comanda`);

--
-- Limitadores para a tabela `estoque`
--
ALTER TABLE `estoque`
  ADD CONSTRAINT `FK_tb8be7tjxydv5qf2ci1t0efbp` FOREIGN KEY (`id_estoque_produto`) REFERENCES `produto` (`id_produto`);

--
-- Limitadores para a tabela `fornecedor`
--
ALTER TABLE `fornecedor`
  ADD CONSTRAINT `FK_khamly97o1h6gwd91qe36jht2` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);

--
-- Limitadores para a tabela `itemcomanda`
--
ALTER TABLE `itemcomanda`
  ADD CONSTRAINT `FK_b1b9xr0desavlf5fl49k88y50` FOREIGN KEY (`id_produto`) REFERENCES `produto` (`id_produto`),
  ADD CONSTRAINT `FK_o41t7v8a17ivvnrt017hvj8a6` FOREIGN KEY (`id_comanda`) REFERENCES `comada` (`id_comanda`);

--
-- Limitadores para a tabela `log_estoque`
--
ALTER TABLE `log_estoque`
  ADD CONSTRAINT `FK_6bs7incafsynk5of2hwt0hovk` FOREIGN KEY (`id_usuariomovimentador`) REFERENCES `usuario` (`id_usuario`),
  ADD CONSTRAINT `FK_k384gh3y7on6blk2l7l32rr6y` FOREIGN KEY (`id_estoque`) REFERENCES `estoque` (`id_estoque`);

--
-- Limitadores para a tabela `marca`
--
ALTER TABLE `marca`
  ADD CONSTRAINT `FK_mvdpiwtad3pa9dkvbhnarb1nt` FOREIGN KEY (`id_fabricante`) REFERENCES `fabricante` (`id_fabricante`);

--
-- Limitadores para a tabela `movimentacao`
--
ALTER TABLE `movimentacao`
  ADD CONSTRAINT `FK_jiodevqlvssn0ut5uhmnxhsr0` FOREIGN KEY (`id_pagamento`) REFERENCES `pagamento` (`id`),
  ADD CONSTRAINT `FK_kc3s6lllxup6wc43tkonl2av` FOREIGN KEY (`id_caixa`) REFERENCES `caixa` (`id_caixa`);

--
-- Limitadores para a tabela `pagamento`
--
ALTER TABLE `pagamento`
  ADD CONSTRAINT `FK_fw83axxuhxh70y0r9dfn6j6aq` FOREIGN KEY (`id_despesa`) REFERENCES `despesa` (`id_despesa`),
  ADD CONSTRAINT `FK_g0l8aok7vqpb8lsvt2x34thby` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id_usuario`);

--
-- Limitadores para a tabela `pessoa`
--
ALTER TABLE `pessoa`
  ADD CONSTRAINT `FK_h3253iuetkv2ql45d33viretg` FOREIGN KEY (`id_endereco`) REFERENCES `endereco` (`id_endereco`);

--
-- Limitadores para a tabela `produto`
--
ALTER TABLE `produto`
  ADD CONSTRAINT `FK_60uk2d6wcyipenpqb4sfw0sgs` FOREIGN KEY (`id_fornecedor`) REFERENCES `fornecedor` (`id_fornecedor`),
  ADD CONSTRAINT `FK_ck4rvygy9io57msntl7cadrne` FOREIGN KEY (`id_categoria_produto`) REFERENCES `categoria_produto` (`id_categoria`),
  ADD CONSTRAINT `FK_hyod2rwy62u9rukn6eukayn7a` FOREIGN KEY (`id_estoque_produto`) REFERENCES `estoque` (`id_estoque`),
  ADD CONSTRAINT `FK_qqeneu6liwk47gw2qybunxxc` FOREIGN KEY (`id_marca_produto`) REFERENCES `marca` (`id_marca`),
  ADD CONSTRAINT `FK_tkqaudhuom5sduvw02gmq2cwu` FOREIGN KEY (`id_grupoProduto`) REFERENCES `grupoproduto` (`idGrupoProduto`);

--
-- Limitadores para a tabela `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `FK_9wnw55sajbeqbpd8fsjbna1ie` FOREIGN KEY (`id_pessoa`) REFERENCES `pessoa` (`id_pessoa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
