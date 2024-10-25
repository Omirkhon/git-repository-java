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
