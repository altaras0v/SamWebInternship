create table contact
(
    id bigint auto_increment,
    mentor_id bigint not null,
    user_id bigint not null,

    constraint table_name_pk
        primary key (id),
    constraint table_name_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade,
    constraint table_name_user_id_fk_2
        foreign key (mentor_id) references user (id)
            on update cascade on delete cascade
);

