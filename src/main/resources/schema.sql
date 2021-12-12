create table Book
(
    id     uuid default random_uuid() not null unique,
    isbn   varchar(20)                not null unique,
    title  varchar(255)               not null,
    author varchar(255)               not null,
    date   date                       not null,

    primary key (id)
);
