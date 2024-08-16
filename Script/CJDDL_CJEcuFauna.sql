-- database: ../DataBase/CJEcuFauna.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| jonathan.cuasapaz@epn.edu.ec           |
|----------------------------------------|
Autor : Jonathan Cuasapaz 
Fecha : 15.agosto.2k24
Script: Creacion de la estructura de datos
*/

DROP TABLE IF EXISTS CJHormiga; 
DROP TABLE IF EXISTS CJSexo;
DROP TABLE IF EXISTS CJLocalidad;
DROP TABLE IF EXISTS CJLocalidadEstructura;
DROP TABLE IF EXISTS CJAlimento; 
DROP TABLE IF EXISTS CJTipoAlimento;
DROP TABLE IF EXISTS CJAdministrador;

CREATE TABLE CJAdministrador (
     IdCJAdministrador      INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Usuario                VARCHAR(30) NOT NULL UNIQUE
    ,Clave                  VARCHAR(30) NOT NULL UNIQUE
        
    ,Estado                 VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion          DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica          DATETIME
); 

CREATE TABLE CJSexo (
     IdCJSexo       INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre         VARCHAR(10) NOT NULL UNIQUE

    ,Estado         VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion  DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica  DATETIME
); 

CREATE TABLE CJLocalidadEstructura (
     IdCJLocalidadEstructura    INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre                     VARCHAR(10) NOT NULL UNIQUE

    ,Estado                     VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica              DATETIME
); 

CREATE TABLE CJLocalidad (
     IdCJLocalidad              INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCJLocalidadEstructura    INTEGER     NOT NULL REFERENCES CJLocalidadEstructura (IdCJLocalidadEstructura)
    ,Nombre                     VARCHAR(30) NOT NULL UNIQUE

    ,Estado                     VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion              DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica              DATETIME
); 

CREATE TABLE CJTipoAlimento (
     IdCJTipoAlimento   INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,Nombre             VARCHAR(20) NOT NULL UNIQUE

    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
); 

CREATE TABLE CJAlimento (
     IdCJAlimento       INTEGER     NOT NULL PRIMARY KEY AUTOINCREMENT
    ,IdCJTipoAlimento   INTEGER     NOT NULL REFERENCES CJTipoAlimento (IdCJTipoAlimento)
    ,Nombre             VARCHAR(20) NOT NULL UNIQUE     
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
); 

CREATE TABLE CJHormiga (
     IdCJHormiga        INTEGER primary key autoincrement
    ,IdCJSexo           INTEGER NOT NULL REFERENCES CJSexo(IdCJSexo)
    ,IdCJProvincia      INTEGER NOT NULL REFERENCES CJLocalidad(IdCJLocalidad)
    ,Tipo               VARCHAR(30) NOT NULL
    ,GenoAlimento       VARCHAR(30)
    ,IngestaNativa      VARCHAR(30)
    
    ,Estado             VARCHAR(1)  NOT NULL DEFAULT('A')
    ,FechaCreacion      DATETIME    DEFAULT(datetime('now','localtime'))
    ,FechaModifica      DATETIME
);
