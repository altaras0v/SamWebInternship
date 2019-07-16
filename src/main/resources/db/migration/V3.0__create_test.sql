create table test(
id int primary key AUTO_INCREMENT,
name varchar(100),
description varchar(255),
lesson_id int unique,
foreign key (lesson_id) references lesson(id));