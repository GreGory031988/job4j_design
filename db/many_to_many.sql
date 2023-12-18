create table player_on_field(
    id serial primary key,
    surname varchar(255)
);

create table position_on_field(
    id serial primary key,
    role_on_field varchar(255)
);

create table on_field(
    id serial primary key,
    player_id int references player_on_field(id),
    position_id int references position_on_field(id)
);

insert into player_on_field(surname) values('Promes');
insert into player_on_field(surname) values('Jikia');

insert into position_on_field(role_on_field) values('midfielder');
insert into position_on_field(role_on_field) values('defender');
insert into position_on_field(role_on_field) values('attack');

insert into on_field(player_id, position_id) values(1, 1);
insert into on_field(player_id, position_id) values(1, 3);
insert into on_field(player_id, position_id) values(2, 2);
insert into on_field(player_id, position_id) values(2, 3);