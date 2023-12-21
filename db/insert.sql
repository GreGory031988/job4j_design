insert into users(client) values ('Grigorii');
insert into users(client) values ('Oleg');

insert into roles(role, users_id) values ('manager', 1);
insert into roles(role, users_id) values ('engineer', 1);

insert into rules(rule) values ('user');
insert into rules(rule) values ('admin');

insert into roles_rules(roles_id, rules_id) values (1, 1);
insert into roles_rules(roles_id, rules_id) values (1, 2);
insert into roles_rules(roles_id, rules_id) values (2, 1);
insert into roles_rules(roles_id, rules_id) values (2, 2);

insert into items(item, users_id) values ('заявка 1', 1);
insert into items(item, users_id) values ('заявка 2', 1);
insert into items(item, users_id) values ('заявка 3', 2);
insert into items(item, users_id) values ('заявка 4', 2);

insert into comments(comment, items_id) values ('комментарии к заявке 1', 1);
insert into comments(comment, items_id) values ('комментарии к заявке 2', 1);
insert into comments(comment, items_id) values ('комментарии к заявке 3', 1);

insert into attachs(attach, items_id) values ('приложение 1', 3);
insert into attachs(attach, items_id) values ('приложение 2', 3);

insert into categories(category, items_id) values ('катеория 1', 2);
insert into categories(category, items_id) values ('категория 2', 2);

insert into states(state, items_id) values ('состояние 1', 2);
insert into states(state, items_id) values ('состояние 2', 2);
insert into states(state, items_id) values ('состояние 3', 3);


