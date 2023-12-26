insert into type (name) values ('Сыр');
insert into type (name) values ('Молоко');
insert into type (name) values ('Хлеб');

insert into product (name, expired_date, price, type_id)
    values ('Сыр плавленный', '2024-02-14', 55.9, 1), 
           ('Сыр российский', '2023-12-31', 93.9, 1),
           ('Сыр голландский', '2023-12-25', 55.9, 1);

insert into product (name, expired_date, price, type_id)
    values ('Молоко топленое', '2023-12-27', 45.4, 2), 
           ('Молоко пастеризованное', '2023-12-28', 90.4, 2);
	
insert into product (name, expired_date, price, type_id)
    values ('Хлеб белый', '2023-12-26', 27.2, 3),
           ('Хлеб ржаной', '2023-12-29', 32.2, 3),
           ('Хлеб бездрожевой', '2023-12-30', 35.2, 3);
