create table my_db.booklist
(
    isbn      varchar(20)  not null
        constraint isbn_pk
        primary key,
    title     varchar(100) not null,
    summary   varchar,
    author    varchar,
    cover     varchar,
    rate      integer
);

create table my_db.commentlist
(
    id      serial   not null
        constraint commentlist_pk
            primary key ,
    isbn    varchar(20) not null,
    comment varchar(700)
);

