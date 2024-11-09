-- 1
create table books (
    id serial primary key,
    name varchar not null,
    genre_id int references genres (id) not null,
    author_id int references authors (id) not null
);

create table readers (
    id serial primary key,
    name varchar not null
);

create table genres (
    id serial primary key,
    name varchar not null
);

create table authors (
    id serial primary key,
    name varchar not null
);

create table books_readers (
    book_id int references books (id) not null,
    reader_id int references readers (id) not null,
    primary key (book_id, reader_id)
);

-- 2
insert into genres (name)
values ('Детектив'),
       ('Фэнтези');


insert into authors (name)
values ('Джоан Роулинг'),
       ('Джон Толкин'),
       ('Артур Конан Дойл');

insert into books (name, genre_id, author_id)
values ('Гарри Поттер', 2, 1),
       ('Хоббит: Туда и Обратно', 2, 2),
       ('Властелин колец', 2, 2),
       ('Шерлок Холмс', 1, 3);

insert into readers (name)
values ('Амирхан'),
       ('Темирлан'),
       ('Бекзот');

-- 3
insert into books_readers (book_id, reader_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (2, 2),
       (3, 2),
       (4, 2),
       (4, 3),
       (2, 1);

-- 4

select name from books b
join books_readers br on b.id = br.book_id
where br.reader_id = 2;

-- 5

select r.name from readers r
join books_readers br on r.id = br.reader_id
join books b on b.id = br.book_id
join genres g on b.genre_id = g.id
where g.name = 'Детектив';

select b.name, r.name from books b
join authors a on a.id = b.author_id
join books_readers br on b.id = br.book_id
join readers r on br.reader_id = r.id
where a.name = 'Джон Толкин';
