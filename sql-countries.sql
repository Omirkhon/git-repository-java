select * from continents;

select * from countries;

select * from cities;

select name, population from cities;

select name, population from cities where population > 5000000;

select name, population from cities where name like 'А%';

select name, population from cities where name like 'А%' order by name;

select name, population from cities where char_length(name) >= 7;

select name, population from cities where char_length(name) >= 7 order by population desc;

select name, population from cities where country_id = 6 and name like 'А%';

select name from countries where continent_id = 1;

select name from countries where continent_id = 1 or continent_id = 2;

select name from countries where not (continent_id = 1 or continent_id = 2);

select name, population from cities order by population;

select name, population from cities where country_id = 1 order by population;

select name, population from cities where country_id = 5 order by name;

select name, population from cities where country_id = 3 and population > 750000;

select name, population from cities where country_id = 2 or country_id = 4 or country_id = 5;

select sum(population) as total_german_population from cities where country_id = 1;

select sum(c.population) as total_european_population from cities as c
join countries as co on co.id = c.country_id
where co.continent_id = 1;

-- 23
select c.name , sum(ci.population) as total_population
from countries c
join cities ci on c.id = ci.country_id
group by c.name
order by total_population desc;

-- 24
select name, max(population) as max
from cities
group by name
order by max desc
limit 1;

-- 25
select c.name , avg(ci.population) as avg_population
from countries c
join cities ci on c.id = ci.country_id
group by c.name
having sum(ci.population) > 1000000;

-- 26
select distinct c.name, co.name
from countries c
join cities ci on c.id = ci.country_id
join continents co on c.continent_id = co.id
where ci.population < 1000000;

-- 27
select co.name, sum(ci.population) as total_population
from continents co
join countries c on co.id = c.continent_id
join cities ci on c.id = ci.country_id
group by co.name
order by total_population;
