create database	db_springboot;

use db_springboot;


create table clientes(
id int primary key auto_increment,
nombre	varchar(20),
apellido	varchar(20),
email	varchar(20),
create_at	 varchar(20),
idcategoria int,
foreign key(idcategoria) references categorias(idcategoria)
)

select * from categorias;

create table categorias(
idcategoria int primary key auto_increment,
nombre varchar(20)
 );
 