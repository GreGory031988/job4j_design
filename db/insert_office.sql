insert into devices (name, price) values ('switch', 8100.2);
insert into devices (name, price) values ('phone', 27900.0);
insert into devices (name, price) values ('headphones', 4999.99);

insert into people (name) values ('Ivan');
insert into people (name) values ('Fedor');

insert into devices_people (device_id, people_id) values (1, 1), (1, 2);
insert into devices_people (device_id, people_id) values (2, 1);
insert into devices_people (device_id, people_id) values (3, 2);