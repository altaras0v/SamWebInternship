create table question(
id int primary key AUTO_INCREMENT,
question varchar(1000),
test_id int,
foreign key (test_id) references test(id));