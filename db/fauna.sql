create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date) values ('Бурый медведь', 40, '1902-Jan-09');
insert into fauna(name, avg_age, discovery_date) values ('Лиса', 15, '1978-Feb-27');
insert into fauna(name, avg_age, discovery_date) values ('Заяц', 7, '1956-Oct-13');
insert into fauna(name, avg_age, discovery_date) values ('Волк', 17, '1948-Sep-03');

select * from fauna where name like '%fish%';

select * from fauna where avg_age >= 10000 and avg_age <= 21000;

select * from fauna where discovery_date is null;

select * from fauna where discovery_date < '01.01.1950';