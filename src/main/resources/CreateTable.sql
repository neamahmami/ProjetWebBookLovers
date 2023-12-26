create table favtable
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
INSERT INTO favtable (isbn, title, summary, author, cover, rate)
VALUES
    ('19', 'Titre du livre', 'Résumé du livre', 'Auteur du livre', 'URL de la couverture', 5);
COMMIT;