create table blob_file(
id BIGINT primary key AUTO_INCREMENT,
file_id BIGINT,
file BLOB,
foreign key (file_id) references lesson_file(id));