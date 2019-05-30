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

insert into auth_user (auth_user_id,first_name,last_name,email,password,status)
 values (2,'Antho','Muñoz','admin@gmail.com','$2a$10$DD/FQ0hTIprg3fGarZl1reK1f7tzgM4RuFKjAKyun0Si60w6g3v5i','VERIFIED');
 // pass antho =abc123ABC
 //pass aldair = perro

INSERT INTO auth_role VALUES (1,'SUPER_USER','This user has ultimate rights for everything');
INSERT INTO auth_role VALUES (2,'ADMIN_USER','This user has admin rights for administrative work');
INSERT INTO auth_role VALUES (3,'SITE_USER','This user has access to site, after login - normal user');

insert into auth_user_role (auth_user_id, auth_role_id) values ('1','1');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','2');
insert into auth_user_role (auth_user_id, auth_role_id) values ('1','3');
select *from auth_user;
