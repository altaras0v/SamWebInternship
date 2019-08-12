create table result
(
    id bigint auto_increment,
    user_id bigint null,
    test_id bigint null,
    grade int null,
    comments varchar(1000) null,
    constraint test_pk
        primary key (id),
    constraint test_test_id_fk
        foreign key (test_id) references test (id)
            on update cascade on delete cascade,
    constraint test_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);