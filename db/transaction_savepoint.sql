create table city_library(
	id serial primary key,
	type_of_literature varchar(50),
	name_book varchar(50),
	number_of_book integer default 0
);

insert into city_library (type_of_literature, name_book, number_of_book)
values ('fiction', 'War and Peace', 4);

insert into city_library (type_of_literature, name_book, number_of_book)
values ('scientific', 'A Brief History of Time', 1);

insert into city_library (type_of_literature, name_book, number_of_book)
values ('technical', 'Programming for beginners', 7);

begin transaction;

insert into city_library (type_of_literature, name_book, number_of_book) 
values ('reference', 'English dictionary', 5);

savepoint first_savepoint;

delete from city_library where name_book = 'War and Peace';

rollback to first_savepoint;

update city_library set number_of_book = 0 where name_book = 'A Brief History of Time';

savepoint third_savepoint;

commit;

