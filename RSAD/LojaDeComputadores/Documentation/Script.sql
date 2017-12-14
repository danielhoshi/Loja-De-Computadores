--<ScriptOptions statementTerminator=";"/>

CREATE TABLE Usuario (
	idUsuario INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(250) NOT NULL,
	cpf VARCHAR(14) NOT NULL,
	login VARCHAR(50) NOT NULL,
	senha VARCHAR(20) NOT NULL,
	idTipoUsuario INT NOT NULL,
	idCargo INT NOT NULL,
	PRIMARY KEY (idUsuario)
);

CREATE TABLE TipoUsuario (
	idTipoUsuario INT NOT NULL AUTO_INCREMENT,
	tipo VARCHAR(50) NOT NULL,
	PRIMARY KEY (idTipoUsuario)
);

CREATE TABLE Cargo (
	idCargo INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	PRIMARY KEY (idCargo)
);

CREATE TABLE Pedido (
	idPedido INT NOT NULL AUTO_INCREMENT,
	precoFinal DOUBLE NOT NULL,
	desconto DOUBLE NOT NULL,
	idCliente INT NOT NULL,
	idUsuario INT NOT NULL,
	PRIMARY KEY (idPedido)
);

CREATE TABLE ItemPedido (
	idItemPedido INT NOT NULL AUTO_INCREMENT,
	quantidade INT NOT NULL,
	idPedido INT NOT NULL,
	idItem INT NOT NULL,
	PRIMARY KEY (idItemPedido)
);

CREATE TABLE Item (
	idItem INT NOT NULL AUTO_INCREMENT,
	preco DOUBLE NOT NULL,
	idProcessador INT,
	idPlacaMae INT,
	idHD INT,
	idMemoria INT,
	idComputador INT,
	PRIMARY KEY (idItem)
);

CREATE TABLE Processador (
	idProcessador INT NOT NULL AUTO_INCREMENT,
	fabricante VARCHAR(250) NOT NULL,
	modelo VARCHAR(250) NOT NULL,
	frequencia VARCHAR(30) NOT NULL,
	idSoquete INT NOT NULL,
	PRIMARY KEY (idProcessador)
);

CREATE TABLE PlacaMae (
	idPlacaMae INT NOT NULL AUTO_INCREMENT,
	fabricante VARCHAR(250) NOT NULL,
	modelo VARCHAR(250) NOT NULL,
	numeroDePentes INT NOT NULL,
	idSoquete INT NOT NULL,
	PRIMARY KEY (idPlacaMae)
);

CREATE TABLE HD (
	idHD INT NOT NULL AUTO_INCREMENT,
	fabricante VARCHAR(250) NOT NULL,
	modelo VARCHAR(250) NOT NULL,
	capacidade VARCHAR(30) NOT NULL,
	tecnologia VARCHAR(30) NOT NULL,
	PRIMARY KEY (idHD)
);

CREATE TABLE Memoria (
	idMemoria INT NOT NULL AUTO_INCREMENT,
	fabricante VARCHAR(250) NOT NULL,
	mdelo VARCHAR(250) NOT NULL,
	capacidade VARCHAR(30) NOT NULL,
	idTipoMemoria INT NOT NULL,
	PRIMARY KEY (idMemoria)
);

CREATE TABLE Cliente (
	idCliente INT NOT NULL AUTO_INCREMENT,
	cpf VARCHAR(14) NOT NULL,
	PRIMARY KEY (idCliente)
);

CREATE TABLE Computador (
	idComputador INT NOT NULL AUTO_INCREMENT,
	idPlacaMae INT NOT NULL,
	idProcessador INT NOT NULL,
	PRIMARY KEY (idComputador)
);

CREATE TABLE Soquete (
	idSoquete INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY (idSoquete)
);

CREATE TABLE TipoMemoria (
	idTipoMemoria INT NOT NULL AUTO_INCREMENT,
	nome VARCHAR(100) NOT NULL,
	PRIMARY KEY (idTipoMemoria)
);

CREATE TABLE Computador_tem_Hd (
	idComputador INT NOT NULL,
	idHD INT NOT NULL,
	PRIMARY KEY (idComputador,idHD)
);

CREATE TABLE Computador_tem_Memoria (
	idComputador INT NOT NULL,
	idMemoria INT NOT NULL,
	PRIMARY KEY (idComputador,idMemoria)
);

CREATE TABLE PlacaMae_aceita_TipoMemoria (
	idTipoMemoria INT NOT NULL,
	idPlacaMae INT NOT NULL,
	PRIMARY KEY (idTipoMemoria,idPlacaMae)
);

ALTER TABLE Usuario ADD CONSTRAINT Usuario_TipoUsuario_FK FOREIGN KEY (idTipoUsuario)
	REFERENCES TipoUsuario (idTipoUsuario)
	ON DELETE CASCADE;

ALTER TABLE Usuario ADD CONSTRAINT Usuario_Cargo_FK FOREIGN KEY (idCargo)
	REFERENCES Cargo (idCargo)
	ON DELETE CASCADE;

ALTER TABLE Pedido ADD CONSTRAINT Pedido_Cliente_FK FOREIGN KEY (idCliente)
	REFERENCES Cliente (idCliente)
	ON DELETE CASCADE;

ALTER TABLE Pedido ADD CONSTRAINT Pedido_Usuario_FK FOREIGN KEY (idUsuario)
	REFERENCES Usuario (idUsuario)
	ON DELETE CASCADE;

ALTER TABLE ItemPedido ADD CONSTRAINT ItemPedido_Pedido_FK FOREIGN KEY (idPedido)
	REFERENCES Pedido (idPedido)
	ON DELETE CASCADE;

ALTER TABLE ItemPedido ADD CONSTRAINT ItemPedido_Item_FK FOREIGN KEY (idItem)
	REFERENCES Item (idItem)
	ON DELETE CASCADE;

ALTER TABLE Item ADD CONSTRAINT Item_Processador_FK FOREIGN KEY (idProcessador)
	REFERENCES Processador (idProcessador)
	ON DELETE CASCADE;

ALTER TABLE Item ADD CONSTRAINT Item_PlacaMae_FK FOREIGN KEY (idPlacaMae)
	REFERENCES PlacaMae (idPlacaMae)
	ON DELETE CASCADE;

ALTER TABLE Item ADD CONSTRAINT Item_HD_FK FOREIGN KEY (idHD)
	REFERENCES HD (idHD)
	ON DELETE CASCADE;

ALTER TABLE Item ADD CONSTRAINT Item_Memoria_FK FOREIGN KEY (idMemoria)
	REFERENCES Memoria (idMemoria)
	ON DELETE CASCADE;

ALTER TABLE Item ADD CONSTRAINT Item_Computador_FK FOREIGN KEY (idComputador)
	REFERENCES Computador (idComputador)
	ON DELETE CASCADE;

ALTER TABLE Processador ADD CONSTRAINT Processador_Soquete_FK FOREIGN KEY (idSoquete)
	REFERENCES Soquete (idSoquete)
	ON DELETE CASCADE;

ALTER TABLE PlacaMae ADD CONSTRAINT PlacaMae_Soquete_FK FOREIGN KEY (idSoquete)
	REFERENCES Soquete (idSoquete)
	ON DELETE CASCADE;

ALTER TABLE Memoria ADD CONSTRAINT Memoria_TipoMemoria_FK FOREIGN KEY (idTipoMemoria)
	REFERENCES TipoMemoria (idTipoMemoria)
	ON DELETE CASCADE;

ALTER TABLE Computador ADD CONSTRAINT Computador_PlacaMae_FK FOREIGN KEY (idPlacaMae)
	REFERENCES PlacaMae (idPlacaMae)
	ON DELETE CASCADE;

ALTER TABLE Computador ADD CONSTRAINT Computador_Processador_FK FOREIGN KEY (idProcessador)
	REFERENCES Processador (idProcessador)
	ON DELETE CASCADE;

ALTER TABLE Computador_tem_Hd ADD CONSTRAINT Computador_Hd_Computador_FK FOREIGN KEY (idComputador)
	REFERENCES Computador (idComputador)
	ON DELETE CASCADE;

ALTER TABLE Computador_tem_Hd ADD CONSTRAINT Computador_Hd_HD_FK FOREIGN KEY (idHD)
	REFERENCES HD (idHD)
	ON DELETE CASCADE;

ALTER TABLE Computador_tem_Memoria ADD CONSTRAINT Computador_Memoria_Computador_FK FOREIGN KEY (idComputador)
	REFERENCES Computador (idComputador)
	ON DELETE CASCADE;

ALTER TABLE Computador_tem_Memoria ADD CONSTRAINT Computador_Memoria_Memoria_FK FOREIGN KEY (idMemoria)
	REFERENCES Memoria (idMemoria)
	ON DELETE CASCADE;

ALTER TABLE PlacaMae_aceita_TipoMemoria ADD CONSTRAINT PlacaMae_TipoMemoria_TipoMemoria_FK FOREIGN KEY (idTipoMemoria)
	REFERENCES TipoMemoria (idTipoMemoria)
	ON DELETE CASCADE;

ALTER TABLE PlacaMae_aceita_TipoMemoria ADD CONSTRAINT PlacaMae_TipoMemoria_PlacaMae_FK FOREIGN KEY (idPlacaMae)
	REFERENCES PlacaMae (idPlacaMae)
	ON DELETE CASCADE;

