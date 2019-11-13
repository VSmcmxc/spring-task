DROP TABLE IF EXISTS user;
create table user
(
    id_user           int auto_increment,
    user_name         varchar(255) not null,
    user_email        varchar(255) not null,
    user_password     varchar(255) not null,
    role              varchar(255) not null,
    user_subscription varchar(6)   null,
    constraint id_user_UNIQUE
        unique (id_user)
);

alter table user
    add primary key (id_user);

INSERT INTO user (id_user, user_name, user_email, user_password, role, user_subscription)
VALUES (1, 'Vadim', 'Vadim@email.com', 'password', 'ADMIN', 'test');
INSERT INTO user (id_user, user_name, user_email, user_password, role, user_subscription)
VALUES (2, 'Aleksey', 'Aleksey@email.com', 'password', 'ADMIN', 'test');
INSERT INTO user (id_user, user_name, user_email, user_password, role, user_subscription)
VALUES (3, 'User', 'User@email.com', 'password', 'USER', 'test');

DROP TABLE IF EXISTS task;
create table task
(
    id_task          int auto_increment,
    id_user          int               not null,
    task_description varchar(255)      null,
    task_complete    tinyint default 0 null,
    task_priority    varchar(255),
    constraint id_task_UNIQUE
        unique (id_task),
    constraint id_user
        foreign key (id_user) references user (id_user)
);

create index id_user_idx
    on task (id_user);

alter table task
    add primary key (id_task);

INSERT INTO task (id_task, id_user, task_description, task_complete, task_priority)
VALUES (1, 1, 'To do', 0, 'MEDIUM');
INSERT INTO task (id_task, id_user, task_description, task_complete, task_priority)
VALUES (2, 2, 'To do', 1, 'MEDIUM');
