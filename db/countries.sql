create table countries(
    id serial primary key,
    title varchar(255),
    population integer,
    secular_nation boolean
);

insert into countries(name, population, secular_nation) values('Russia', 145000000, TRUE);

update countries set population = 150000000;

delete from countries;