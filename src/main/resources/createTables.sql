create table my_db.bookList
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

