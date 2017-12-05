/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  vinicius.fbatista1
 * Created: 24/04/2017
 */

create table Produto(
    idProduto INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) 
CONSTRAINT PK_Produto PRIMARY KEY,
    nomeProduto VARCHAR(50) NOT NULL,
    codigo INT NOT NULL UNIQUE,
    categorias VARCHAR(50) NOT NULL,
    quantidade INT NOT NULL,
    descricao VARCHAR(255),
    valorProduto DOUBLE NOT NULL,
    imagem varchar(2083),
    statusProduto INT NOT NULL,
    disponivel BOOLEAN NOT NULL
--     cadastradoPor VARCHAR(50) NOT NULL,
--     dataCadastro TIMESTAMP NOT NULL,
--     disponivel BOOLEAN NOT NULL,
--     idFilial INT NOT NULL,
--     FOREIGN KEY (idFilial) REFERENCES Filial (idFilial)
  
);

create table Usuario (
    id INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
 CONSTRAINT PK_Usuario PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    dataNasc DATE NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    email VARCHAR(50) NOT NULL,
    telefone VARCHAR(15) NOT NULL,
    senha VARCHAR(50) NOT NULL, -- O tamanho da VARCHAR deve ser no mínimo 32 caracteres (Hashes md5 possuem 32 caracteres). Menos do que isso, provavelmente vai dar erro.
    nivel INT DEFAULT 0
);

CREATE TABLE Endereco (
    idEndereco INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
   idUsuario INT NOT NULL,
   cep VARCHAR(9) NOT NULL,
   rua VARCHAR(50) NOT NULL,
   numero INT NOT NULL,
   complemento VARCHAR(50),
   bairro VARCHAR(50),
   cidade VARCHAR(50),
   uf VARCHAR(2),
   FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
);
 create table Venda (
    idVenda INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY, 
    protocolo VARCHAR (10) NOT NULL UNIQUE,
    idUsuario INT NOT NULL,
    idEndereco INT NOT NULL, 
    dataVenda TIMESTAMP NOT NULL,
    valorFinal DOUBLE NOT NULL,
    valorFrete DOUBLE NOT NULL,
--     valorSubtotal DOUBLE NOT NULL, -- Atualmente está sendo feito ValorFinal - ValorFrete
    diasUteis INT NOT NULL, -- Para calcular a previsão de entrega
    status INT NOT NULL,
    ultimaAtt TIMESTAMP NOT NULL,
--     pagamento INT, -- Formas de Pagamento
    numeroCartao BIGINT,
    numeroParcelas INT,
    valorParcelas DOUBLE NOT NULL,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(id),
    FOREIGN KEY (idEndereco) REFERENCES Endereco(idEndereco)
);

create table VendaProd (
   idVendaProd INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1) PRIMARY KEY,
   idVenda INT NOT NULL,
   idProduto INT NOT NULL,
   idUsuario INT NOT NULL,
   dataProd DATE NOT NULL,
   nomeProduto VARCHAR(50) NOT NULL,
   codigo INT NOT NULL,
   quantidade INT NOT NULL,
   valorUni DOUBLE NOT NULL,
   valorTotal DOUBLE NOT NULL,
   imagem varchar(2083),
   FOREIGN KEY (idVenda) REFERENCES Venda(idVenda),
   FOREIGN KEY (idProduto) REFERENCES Produto(idProduto),
   FOREIGN KEY (idUsuario) REFERENCES Usuario(id)
);

 create table Contato (
    protocolo BIGINT NOT NULL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    sobrenome VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    motivo VARCHAR(50) NOT NULL,
    mensagem VARCHAR(4000) NOT NULL,
    dataMensagem DATE NOT NULL,
    respondida BOOLEAN NOT NULL
);

-- CREATE TABLE Filial (
--     idFilial INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
--  CONSTRAINT PK_Filial PRIMARY KEY,
--     nomeFilial VARCHAR(50) NOT NULL,
--     estadoFilial VARCHAR(50) NOT NULL
-- --   , idProduto INT NOT NULL
-- --   ,  FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
-- );

-- 
-- create table Relatorio(
--     idRelatorio INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
--     nmProduto VARCHAR(50) NOT NULL,
--     nmCliente VARCHAR(50) NOT NULL,
--     tipoProduto VARCHAR(50) NOT NULL
--     venda TIMESTAMP NOT NULL,
--     vlFinal DOUBLE NOT NULL,
--     valorProduto DOUBLE NOT NULL,
--     quantProduto INT NOT NULL
--     FOREIGN KEY (nomeProduto) REFERENCES Produto(nomeProduto),
--     FOREIGN KEY(nomeCliente) REFERENCES Cliente(nomeCliente),
--     FOREIGN KEY (tipoProduto) REFERENCES Produto(tipo),
--     FOREIGN KEY (venda) REFERENCES Venda(dataVenda),
--     FOREIGN KEY (vlFinal) REFERENCES Venda(valorFinal),
--     FOREIGN KEY(valorProduto) REFERENCES Produto(valorProduto),
--     FOREIGN KEY(quantProduto) REFERENCES Produto(quantidade)
-- );

-- create table ProdutosExcluidos(
--     idProduto INT NOT NULL UNIQUE,
--     nomeProduto VARCHAR(50) NOT NULL,
--     quantidade INT NOT NULL,
--     valorProduto DOUBLE NOT NULL,
--     excluidoPor VARCHAR(50) NOT NULL,
--     dataExclusao TIMESTAMP NOT NULL,
--     FOREIGN KEY (idProduto) REFERENCES Produto(idProduto)
-- );
-- 


-- Comando para inserir produtos
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa Petite Jolie', 440, 'Bolsa', 3, 'sasda', 149.90, 'http://static1.netshoes.net/Produtos/bolsa-petite-jolie-bau-bloom-feminina/03/E41-0616-203/E41-0616-203_detalhe1.jpg', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Pulseira Verde Amarela', 949592, 'Pulseira', 22, '', 19.0, 'https://t-static.dafiti.com.br/9QwG7yFa89p_Iz2HN6IyrFX6k5I=/fit-in/427x620/dafitistatic-a.akamaihd.net%2fp%2fdecovian-pulseira-decovian-ajust%25c3%25a1vel-preto-6352-8300522-1-product.jpg', 0, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Pulseira Branca Preta', 2492, 'Pulseira', 22, '', 42.0, 'https://t-static.dafiti.com.br/gELozGF0YrwFT0J_lLeQieuCu40=/fit-in/427x620/dafitistatic-a.akamaihd.net%2fp%2fdecovian-pulseira-decovian-ajust%25c3%25a1vel-off-white-6332-3830522-1-product.jpg', 0, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Oculos', 99202, 'Oculos', 4, '', 250.0, 'http://static1.netshoes.net/Produtos/oculos-de-sol-ray-ban-justin/06/N97-0023-006/N97-0023-006_detalhe1.jpg', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Mochila Nike', 22289, 'Mochila', 3, 'Mochila vermelha ', 55.0, 'http://static1.netshoes.net/Produtos/mochila-nike-sb-courthouse-masculina/14/D12-5912-014/D12-5912-014_detalhe1.jpg', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Brinco Turpin', 22429, 'Brinco', 2, '', 15.0, 'https://t-static.dafiti.com.br/70YDHxfj9K2pSfR5HUR5fL2nwh0=/fit-in/427x620/dafitistatic-a.akamaihd.net%2fp%2fturpin-brinco-turpin-boho-helga-ouro-velho-2040-6194142-1-product.jpg', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Relogio Curren', 4006, 'Relogio', 3, '', 48.29, 'http://static1.netshoes.net/Produtos/relogio-curren-analogico/38/DTD-0022-138/DTD-0022-138_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Mochila Nike Preta', 885566, 'Mochila', 2, '', 99.0, 'http://static1.netshoes.net/Produtos/mochila-nike-brasilia-masculina/26/D12-5868-026/D12-5868-026_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Relogio Fossil', 928394, 'Relogio', 5, '', 439.90, 'http://static1.netshoes.net/Produtos/relogio-fossil-pulseira-couro/14/F57-0128-414/F57-0128-414_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa Nike Auralux', 29202, 'Bolsa', 4, '', 100.0, 'http://static1.netshoes.net/Produtos/bolsa-nike-auralux-club-feminina/26/D12-3257-026/D12-3257-026_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa de Viagem', 22012, 'Bolsa', 1, '', 25.0, 'http://static1.netshoes.net/Produtos/bolsa-de-viagem-ls-bolsas-com-bolso-frontal-alcas-tiracolo-e-alcas-de-mao/06/CPQ-0016-006/CPQ-0016-006_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa Colcci', 3193, 'Bolsa', 3, '', 150.0, 'http://static1.netshoes.net/Produtos/bolsa-colcci/16/E33-2963-016/E33-2963-016_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa Ls', 219219, 'Bolsa', 2, '', 122.0, 'http://static1.netshoes.net/Produtos/bolsa-de-viagem-ls-bolsas-2-bolsos-laterais-e-frontal/10/CPQ-0208-010/CPQ-0208-010_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bolsa Roxy Explorer', 813456, 'Bolsa', 3, '', 158.0, 'http://static1.netshoes.net/Produtos/bolsa-roxy-explorer/06/B49-0449-006/B49-0449-006_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bone Nike Branco', 5255252, 'Bone', 10, '', 100.0, 'http://static1.netshoes.net/Produtos/bone-nike-aba-reta-qt-pro-swoosh/14/004-7064-014/004-7064-014_detalhe1.jpg?resize=254:*', 0, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bone Nike Metal', 20048, 'Bone', 2, '', 60.0, 'http://static1.netshoes.net/Produtos/bone-nike-metal-swoosh/06/123-0225-006/123-0225-006_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bone Quiksilver Mescla', 296311, 'Bone', 3, '', 50.0, 'http://static1.netshoes.net/Produtos/bone-quiksilver-mescla-cap/60/A46-1584-060/A46-1584-060_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Bone Element Preto', 991133, 'Bone', 10, '', 95.0, 'http://static1.netshoes.net/Produtos/bone-element-snap-united-a-class-r/26/D51-0830-026/D51-0830-026_detalhe1.jpg?resize=254:*', 0, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Colar PS Beake', 114488, 'Colar', 2, '', 15.0, 'http://static1.netshoes.net/Produtos/colar-polo-state-beake-003/38/K03-0084-138/K03-0084-138_detalhe1.jpg?resize=254:*', 1, true);
INSERT INTO LOJA.PRODUTO (NOMEPRODUTO, CODIGO, CATEGORIAS, QUANTIDADE, DESCRICAO, VALORPRODUTO, IMAGEM, STATUSPRODUTO, DISPONIVEL) 
	VALUES ('Cinto Oakley', 228844, 'Cinto', 2, '', 40.0, 'http://static1.netshoes.net/Produtos/cinto-oakley-halifax-belt/06/D63-0959-006/D63-0959-006_detalhe1.jpg?resize=254:*', 1, true);


INSERT INTO LOJA.USUARIO(NOME, SOBRENOME, DATANASC, CPF, EMAIL, TELEFONE, SENHA) 
	VALUES ('Vinicius', 'Ferreira', '1998-11-01', '360.000.000-00', 'cliente@gmail.com', '(11) 90000-0000', '4297f44b13955235245b2497399d7a93');

INSERT INTO LOJA.ENDERECO (IDUSUARIO, CEP, RUA, NUMERO, COMPLEMENTO, BAIRRO, CIDADE, UF) 
	VALUES (1, '04686-000', 'Avenida Nossa Senhora do Sabará', 121, 'aa', 'Jardim Bélgica', 'São Paulo', 'SP');

