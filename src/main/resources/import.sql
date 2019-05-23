create database	db_springboot;

use db_springboot;


create table clientes(
id int primary key auto_increment,
nombre	varchar(30),
apellido	varchar(40),
email	varchar(50),
create_at	 varchar(20)
)

select * from categorias;

create table categorias(
idcategoria int primary key auto_increment,
nombre varchar(20),
descripcion varchar(60)
 );
 
insert into clientes values(null,'aldair','venturo','aldair@gmial.com',null,2);
insert into categorias values(2,'nikee','marca');

create table productos(
idproducto int primary key auto_increment,
nombre varchar (30),
precio varchar(7),
stock varchar(4),
idcategoria int,
foreign key(idcategoria) references categorias(idcategoria)
);

insert into productos values (null,'gaseosa','30','2',2);

select * from productos;
