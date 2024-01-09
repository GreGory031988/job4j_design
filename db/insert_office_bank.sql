insert into departments (name) 
values ('отдел ипотечного кредитования'),
       ('отдел кредитования'),
	   ('отдел инвестиции');

insert into employees (name, departments_id)
values ('Иванов', 1),
       ('Петрова', 1),
	   ('Сидорова', 1),
	   ('Зенина', 2),
	   ('Кашин', 2),
	   ('Коротков', null),
	   ('Любимов', null);