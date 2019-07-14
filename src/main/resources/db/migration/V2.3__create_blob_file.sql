create table blob_file(
id int primary key AUTO_INCREMENT,
file_id int,
file BLOB,
foreign key (file_id) references lesson_file(id));