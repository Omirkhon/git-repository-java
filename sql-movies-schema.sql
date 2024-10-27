-- 1

select name, count(m.id) from genres g
join movies_genres mg on g.id = mg.genre_id
join movies m on mg.movie_id = m.id
group by name
order by count(m.id) desc
limit 3;

-- 2

select name, avg(m.rating) as avg_movie_rating
from genres g
join movies_genres mg on g.id = mg.genre_id
join movies m on mg.movie_id = m.id
group by name
order by avg(m.rating) desc;

-- 3

select release_year, max(rating) as rating
from movies
group by release_year
order by release_year;

-- 4

select release_year, g.name, count(m.id)
from movies m
join movies_genres mg on m.id = mg.movie_id
join genres g on mg.genre_id = g.id
group by release_year, g.name
order by release_year, count(m.id) desc;

-- 5

select name, count(m.id) as movie_count
from genres g
join movies_genres mg on g.id = mg.genre_id
join movies m on mg.movie_id = m.id
group by name
having count(m.id) > 5
order by movie_count desc;

-- 6

select release_year, avg(rating) as avg_rating, count(id) as num_of_movies
from movies
group by release_year
order by avg_rating desc;

-- 7

select title, release_year, rating
from movies m
join movies_genres mg on m.id = mg.movie_id
join genres g on mg.genre_id = g.id
where rating > 8 and g.name like 'Боевик';
