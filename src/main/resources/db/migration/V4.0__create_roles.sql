CREATE TABLE roles
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name varchar(20) NOT NULL
);
CREATE UNIQUE INDEX roles_id_uindex ON roles (id);
CREATE UNIQUE INDEX roles_name_uindex ON roles (name);