-- creacion de la base de datos
create DATABASE usuarios;

-- creacon de la tabla
create table usuario(
idusuario serial PRIMARY KEY,
usr VARCHAR(20),
pwd VARCHAR(50)
);

create SEQUENCE sec_usuario
START with 1
INCREMENT 99999
MINVALUE 1;

select *from usuario;