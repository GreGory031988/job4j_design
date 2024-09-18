create table work_library(
	id serial primary key,
	type_of_document varchar(50),
	name_document varchar(50),
	number_of_document integer default 0
);

insert into work_library (type_of_document, name_document, number_of_document)
values ('TC', 'ТУ 16-505.339-79', 2), 
       ('GOST', 'ГОСТ 31528-80', 9), 
       ('GOST', 'ГОСТ 33033-80', 4), 
       ('TC', 'ТУ 13-505.339-93', 1);

begin transaction isolation level serializable;

select sum (number_of_document) from work_library where type_of_document = 'GOST';

delete from work_library where number_of_document = 9;

commit;

begin transaction isolation level serializable;

select sum (number_of_document) from work_library where type_of_document = 'TC';

delete from work_library where number_of_document = 2;

commit;
