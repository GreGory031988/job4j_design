create table number_player(
    id serial primary key,
	number int
);

create table player_protocol(
    id serial primary key,
    surname varchar(255),
    number_player_id int references number_player(id) unique
);

insert into number_player(number) values(10);

insert into player_protocol(surname) values('Promes');