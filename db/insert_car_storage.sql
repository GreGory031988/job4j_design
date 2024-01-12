insert into car_bodies (name) values ('седан'), ('купе'), ('хэтчбек'), ('универсал');

insert into car_engines (name) values ('турбированный'), ('атмосферный');

insert into car_transmissions (name) values ('механика'), ('автомат'), ('робот');

insert into cars(name, bodies_id, engines_id, transmissions_id)
values ('киа', 4, 2, null),
       ('хонда', 1, 2, 2),
	   ('бмв', 1, 1, null),
	   ('хавал', 3, null, null),
	   ('хендэ', 3, 2, 2);