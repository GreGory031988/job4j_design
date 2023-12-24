create table vendor_code(
    id serial primary key,
    number int
);

create table product(
	id serial primary key,
	name text,
	color text,
	vendor_code_id int references vendor_code(id) unique
);