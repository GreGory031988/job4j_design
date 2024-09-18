create table university_library(
	id serial primary key,
	type_of_literature varchar(50),
	name_book varchar(50),
	number_of_book integer default 0
);

insert into university_library (type_of_literature, name_book, number_of_book)
values ('fiction', 'War and Peace', 4);

insert into university_library (type_of_literature, name_book, number_of_book)
values ('scientific', 'A Brief History of Time', 1);

insert into university_library (type_of_literature, name_book, number_of_book)
values ('technical', 'Programming for beginners', 7);

begin transaction isolation level repeatable read;

update university_library set number_of_book = 2 where name_book = 'A Brief History of Time';

rollback;

commit;

begin transaction isolation level repeatable read;

update university_library set number_of_book = 10 where name_book = 'War and Peace';
update university_library set number_of_book = 2 where name_book = 'A Brief History of Time';

commit;




