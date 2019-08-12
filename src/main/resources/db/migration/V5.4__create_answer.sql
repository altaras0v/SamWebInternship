create table answer
(
    id bigint auto_increment,
    result_id bigint null,
    answer_1 varchar(1000) null,
    answer_2 varchar(1000) null,
    answer_3 varchar(1000) null,
    answer_4 varchar(1000) null,
    answer_5 varchar(1000) null,
    constraint answer_pk
        primary key (id),
    constraint answer_result_id_fk
        foreign key (result_id) references result (id)
            on update cascade on delete cascade
);

