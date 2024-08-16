-- database: ../DataBase/CJEcuFauna.sqlite
/*
|----------------------------------------|
| (©) 2K24 EPN-FIS, All rights reserved. |
| jonathan.cuasapaz@epn.edu.ec           |
|----------------------------------------|
Autor : Jonathan Cuasapaz 
Fecha : 15.agosto.2k24
Script: Insercion de datos
*/

INSERT INTO CJAdministrador
 ( Usuario      ,Clave      )  VALUES
 ( 'pat_mic'    ,'123456'   );

INSERT INTO CJSexo
 ( Nombre   )  VALUES
 ( 'Macho'  )
,( 'Hembra' )
,( 'Asexual');

INSERT INTO CJLocalidadEstructura
 ( Nombre       )  VALUES
 ( 'Pais'       )
,( 'Region'     )
,( 'Provincia'  );

INSERT INTO CJLocalidad
 ( IdCJLocalidadEstructura  ,Nombre             ) VALUES
 (  1                       ,'Ecuador'          )   -- 1

,(  2                       ,'Costa'            )   -- 2
,(  2                       ,'Sierra'           )   -- 3
,(  2                       ,'Oriente,'         )   -- 4
,(  2                       ,'AsexGalápagos'    )   -- 5

,(  3                       ,'Esmeraldas'       )   -- 6
,(  3                       ,'Manabi'           )   -- 
,(  3                       ,'Santo Domingo'    )   -- 
,(  3                       ,'Los Rios'         )   -- 
,(  3                       ,'Guayas'           )   -- 
,(  3                       ,'Santa Elena'      )   -- 
,(  3                       ,'El Oro'           )   -- 
,(  3                       ,'Carchi'           )   -- 
,(  3                       ,'Imbabura'         )   -- 
,(  3                       ,'Pichincha'        )   -- 
,(  3                       ,'Cotopaxi'         )   -- 
,(  3                       ,'Tungurahua'       )   -- 
,(  3                       ,'Bolivar'          )   -- 
,(  3                       ,'Chimborazo'       )   -- 
,(  3                       ,'Canar'            )   -- 
,(  3                       ,'Azuay'            )   -- 
,(  3                       ,'Loja'             )   -- 
,(  3                       ,'Sucumbios'        )   -- 
,(  3                       ,'Napo'             )
,(  3                       ,'Orellana'         )
,(  3                       ,'Pastaza'          )
,(  3                       ,'Morona Santiago'  )
,(  3                       ,'Zamora Chinchipe' )
,(  3                       ,'Galapagos'        );

INSERT INTO CJTipoAlimento
 ( Nombre           )  VALUES
 ( 'Ingesta Nativa'  )
,( 'Geno Alimento'   );

INSERT INTO CJAlimento
 ( IdCJTipoAlimento ,Nombre         ) VALUES
 (  1               ,'Carnívoro'    )
,(  1               ,'Herbívoro'    )   -- 
,(  1               ,'Omnívoro'     )   -- 3
,(  1               ,'Insectívoros' )   -- 4
,(  2               ,'X'            )
,(  2               ,'XX'           )   -- 6
,(  2               ,'XY'           );

INSERT INTO CJHormiga  
 ( IdCJSexo ,IdCJProvincia ,Tipo      ) VALUES
 ( 3        , 5            ,'Larva'   )
,( 3        , 12           ,'Larva'   );