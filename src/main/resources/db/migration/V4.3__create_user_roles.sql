CREATE TABLE user_roles
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    user_id bigint NOT NULL,
    role_id bigint NOT NULL,
    CONSTRAINT user_roles_user_id_fk FOREIGN KEY (user_id) REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT user_roles_roles_id_fk FOREIGN KEY (role_id) REFERENCES roles (id) ON DELETE CASCADE ON UPDATE CASCADE
);