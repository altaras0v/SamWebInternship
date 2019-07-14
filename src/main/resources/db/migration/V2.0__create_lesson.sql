create table lesson(
id int primary key AUTO_INCREMENT,
name varchar(100) not null,
description varchar(3000),
course_id int,
foreign key (course_id) references courses(id));