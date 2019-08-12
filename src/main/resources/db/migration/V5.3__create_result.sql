create table result
(
    id bigint auto_increment,
    user_id bigint null,
    grade int null,
    comments varchar(1000) null,
    constraint result_pk
        primary key (id),
    constraint table_name_test_id_fk
        foreign key (user_id) references test (id)
            on update cascade on delete cascade
);

