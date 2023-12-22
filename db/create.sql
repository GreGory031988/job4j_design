create table users(
    id serial primary key,
    client varchar(255),
	role_id int references roles(id)
);

create table roles(
    id serial primary key,
    role varchar(255),
);

create table rules(
    id serial primary key,
    rule varchar(255)
);

create table roles_rules(
    id serial primary key,
    roles_id int references roles(id),
	rules_id int references rules(id)
);

create table items(
    id serial primary key,
    item varchar(255),
	users_id int references users(id);
	states_id int references states(id),
	category_id int references categories(id)
	
);

create table comments(
    id serial primary key,
    comment varchar(255),
    items_id int references items(id)
);

create table attachs(
    id serial primary key,
    attach varchar(255),
	items_id int references items(id)
);

create table states(
    id serial primary key,
    state varchar(255)
);

create table categories(
    id serial primary key,
    category varchar(255)
);