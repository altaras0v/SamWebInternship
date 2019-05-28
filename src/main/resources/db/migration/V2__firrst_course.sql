CREATE TABLE courses (
id INT primary key AUTO_INCREMENT,
name varchar (30) not null,
description varchar (120) not null
);

insert into courses(name, description) values ('English','Learn English language');