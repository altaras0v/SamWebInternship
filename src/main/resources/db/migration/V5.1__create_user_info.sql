create table user_info
(
    id      bigint auto_increment,
    fName   varchar(60) not null,
    lName   varchar(80) not null,
    photo   mediumblob  null,
    user_id bigint      not null,
    constraint user_info_id_uindex
        unique (id),
    constraint user_info_user_id_fk
        foreign key (user_id) references user (id)
            on update cascade on delete cascade
);

alter table user_info
    add primary key (id);

