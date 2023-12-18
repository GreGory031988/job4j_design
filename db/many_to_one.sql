create table team(
    id serial primary key,
    name varchar(255),
    city varchar(255)
);

create table player(
    id serial primary key,
	surname varchar(255),
	role varchar(255),
	number int,
	team_id int references team(id)
);

insert into team(name, city) values ('Spartak', 'Moscow');
insert into team(name, city) values ('Dinamo', 'Moscow');
insert into player(surname, role, number, team_id) values ('Promes', 
														   'midfielder', 
														  10,
														  1);
insert into player(surname, role, number, team_id) values ('Jikia', 
														   'defender', 
														  14,
														  1);
insert into player(surname, role, number, team_id) values ('Shunin', 
														   'goalkeeper', 
														  1,
														  2);