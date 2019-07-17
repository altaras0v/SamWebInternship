create table question(
id BIGINT primary key AUTO_INCREMENT,
question varchar(1000),
test_id BIGINT,
foreign key (test_id) references test(id));