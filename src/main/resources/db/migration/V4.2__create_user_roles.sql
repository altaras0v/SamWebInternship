CREATE TABLE user
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(255) NOT NULL,
    password varchar(80) NOT NULL
);
CREATE UNIQUE INDEX user_name_uindex ON user (name);

