create table test(
id BIGINT primary key AUTO_INCREMENT,
name varchar(100),
description varchar(255),
lesson_id BIGINT unique,
foreign key (lesson_id) references lesson(id));