create table lesson(
id BIGINT primary key AUTO_INCREMENT,
name varchar(100) not null,
description varchar(3000),
course_id BIGINT,
foreign key (course_id) references courses(id));