alter table lesson_file drop foreign key lesson_file_ibfk_1;

alter table lesson_file
    add constraint lesson_file_ibfk_1
        foreign key (lesson_id) references lesson (id)
            on update cascade on delete cascade;

alter table blob_file drop foreign key blob_file_ibfk_1;

alter table blob_file
    add constraint blob_file_ibfk_1
        foreign key (file_id) references lesson_file (id)
            on update cascade on delete cascade;

alter table lesson drop foreign key lesson_ibfk_1;

alter table lesson
    add constraint lesson_ibfk_1
        foreign key (course_id) references courses (id)
            on update cascade on delete cascade;

alter table test drop foreign key test_ibfk_1;

alter table test
    add constraint test_ibfk_1
        foreign key (lesson_id) references lesson (id)
            on update cascade on delete cascade;

alter table question drop foreign key question_ibfk_1;

alter table question
    add constraint question_ibfk_1
        foreign key (test_id) references test (id)
            on update cascade on delete cascade;

