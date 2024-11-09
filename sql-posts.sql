create table users (
    login varchar(255) primary key,
    bio varchar(255) not null
);

create table posts (
    name varchar(255) primary key,
    description varchar(255) not null,
    date timestamp not null,
    author varchar(255) not null,
    foreign key (author) references users (login)
);

create table comments (
    text varchar(255) not null,
    post varchar(255) not null,
    foreign key (post) references posts (name),
    author varchar(255) not null,
    foreign key (author) references users (login)
);

insert into users (login, bio)
values ('Toblerone', 'life could be a dream'),
       ('Devletin', '...');

insert into posts (name, description, date, author)
values ('Хочу быть котом', 'Коты рулят', '2024-04-10 10:37:25', 'Toblerone'),
       ('Java', 'Объясняю Java на примере с бутербродом', '2024-05-27 22:12:42', 'Toblerone'),
       ('Finals', 'Не буду готовиться к экзаменам', '2024-06-01 22:43:12', 'Devletin');

insert into comments (text, post, author)
values ('Спасибо!', 'Java', 'Devletin'),
       ('Иди готовься', 'Finals', 'Toblerone'),
       ('Больно будет', 'Finals', 'Toblerone');

select distinct name, description from posts as p
join comments as c on p.name = c.post
where c.post = p.name
