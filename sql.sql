CREATE TABLE movie (
                       id              SERIAL PRIMARY KEY,  -- Уникальный идентификатор фильма
                       title           VARCHAR(255) NOT NULL, -- Название фильма
                       rental_rate     DECIMAL(4,2) NOT NULL, -- Стоимость аренды
                       rental_duration INTEGER NOT NULL,     -- Длительность аренды (в днях)
                       rating          VARCHAR(10) NOT NULL  -- Рейтинг фильма (например, 'PG', 'PG-13', 'R')
);

INSERT INTO movie (title, rental_rate, rental_duration, rating)
VALUES ('The Godfather', 2.99, 7, 'R'),
       ('Casablanca', 1.99, 5, 'PG'),
       ('The Silence of the Lambs', 3.49, 4, 'R'),
       ('Jurassic Park', 2.49, 5, 'PG-13'),
       ('The Matrix', 2.99, 4, 'R'),
       ('Spirited Away', 1.99, 6, 'PG'),
       ('Saving Private Ryan', 3.99, 6, 'R'),
       ('The Lion King', 2.49, 4, 'G'),
       ('Back to the Future', 2.99, 5, 'PG'),
       ('Toy Story', 2.49, 4, 'G');

select * from movie where (rating = 'R' or rating = 'NC-17') and rental_rate < 3;

select title from movie where rating = 'G' or rental_rate > 4 or rental_duration > 5;

select * from movie where rental_duration >= 3 and rental_duration <= 5 and rating != 'PG';

select title from movie where rating != 'PG-13' and rental_rate < 2.50;

select * from movie where rating = 'R' and rental_duration >= 7 and rental_rate > 1.50 and rental_rate < 3;

select * from movie where rating != 'G' and rating != 'PG-13' and rental_duration = 5;

drop table books;

create table books (
    id serial primary key,
    title varchar(255),
    author varchar(255),
    genre varchar(100),
    publication_year int,
    available boolean
);

insert into books (title, author, genre, publication_year, available)
values ('Мастер и Маргарита', 'Михаил Булгаков', 'Роман', '1967', true),
       ('Преступление и наказание', 'Федор Достоевский', 'Роман', 1866, true),
       ('Анна Каренина', 'Лев Толстой', 'Роман', 1877, true),
       ('1984', 'Джордж Оруэлл', 'Антиутопия', 1949, false),
       ('Гарри Поттер и философский камень', 'Джоан Роулинг', 'Фэнтези', 1997, true),
       ('Война и мир', 'Лев Толстой', 'Исторический роман', 1869, true),
       ('Пикник на обочине', 'Аркадий и Борис Стругацкие', 'Научная фантастика', 1972, false);

update books set available = false where id = 3;

delete from books where id = 7;

select * from books;
