create table classes(
        id serial primary key,
	name varchar(100)
);

insert into classes (name) values ('4А'), ('4Б'), ('4В');


create table pupils(
        id serial primary key,
	name varchar(100),
	id_classes int references classes(id)
);


insert into pupils (name, id_classes) 
values ('Миша Иванов', 1), ('Александр Петров', 1), ('Сергей Воронин', 1),
('Александр Петров', 2), ('Василиса Сидорова', 2),
('Светлана Кабаева', 3), ('Екатерина Вялова', 3);


create table subjects(
        id serial primary key,
	name varchar(100)
);

insert into subjects (name) values ('математика'), ('окружающий мир'), ('русский язык');

create table schedule(
        id serial primary key,
	id_class int references classes(id),
	id_subject int references subjects(id)
);

insert into schedule (id_class, id_subject) 
values  (1, 1), (1, 2), (1, 3), (2, 3), (3, 2);