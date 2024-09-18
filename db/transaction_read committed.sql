create table school_library(
	id serial primary key,
	type_of_literature varchar(50),
	name_book varchar(50),
	number_of_book integer default 0
);

insert into school_library (type_of_literature, name_book, number_of_book)
values ('fiction', 'War and Peace', 4);

insert into school_library (type_of_literature, name_book, number_of_book)
values ('scientific', 'A Brief History of Time', 1);

insert into school_library (type_of_literature, name_book, number_of_book)
values ('technical', 'Programming for beginners', 7);

Begin transaction;

insert into school_library (type_of_literature, name_book)
values ('reference', 'English dictionary');

delete from school_library where type_of_literature = 'scientific';

update school_library set number_of_book = 10 where name_book = 'War and Peace';

Commit;

Begin transaction;

select * from school_library;

Commit;
