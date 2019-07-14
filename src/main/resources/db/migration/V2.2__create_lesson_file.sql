create table lesson_file(
id int primary key AUTO_INCREMENT,
name varchar(150) not null,
description varchar(255),
lesson_id int,
foreign key (lesson_id) references lesson(id));