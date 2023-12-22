insert into roles(role) values ('manager');

insert into rules(rule) values ('user');
insert into rules(rule) values ('admin');

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (1, 2);

insert into users(client, roles_id) values ('Grigorii', 1);
insert into users(client, roles_id) values ('Oleg', 1);

insert into states(state) values ('в работе');
insert into states(state) values ('в ожидании');

insert into categories(category) values ('категория 1');

insert into items(item, users_id, states_id, category_id) values ('заявка 1', 1, 2, 1);
insert into items(item, users_id, states_id, category_id) values ('заявка 2', 1, 2, 1);
insert into items(item, users_id, states_id, category_id) values ('заявка 3', 2, 1, 1);
insert into items(item, users_id, states_id, category_id) values ('заявка 4', 2, 1, 1);

insert into comments(comment, items_id) values ('комментарии к заявке 1', 1);
insert into comments(comment, items_id) values ('комментарии к заявке 2', 1);

insert into attachs(attach, items_id) values ('приложение 1', 3);
insert into attachs(attach, items_id) values ('приложение 2', 3);