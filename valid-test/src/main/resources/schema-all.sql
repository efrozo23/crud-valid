SET MODE MySql;



DROP TABLE usuarios IF EXISTS;

CREATE TABLE usuarios  (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(80) NOT null,
    lastname VARCHAR(30) NOT null,
    status BOOLEAN not null default 0
);


CREATE SEQUENCE id_user_key;

insert into usuarios (id,name,lastname) values (100,'Elkin','Rozo');
insert into usuarios (id,name,lastname) values (200,'Fabian','O');


















