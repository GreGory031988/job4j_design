CREATE TABLE customers
(
    id         serial primary key,
    first_name text,
    last_name  text,
    age        int,
    country    text
);

insert into customers (first_name, last_name, age, country)
values ('Aleksei', 'Ivanov', 30, 'Russua'),
       ('Sol', 'Kembell', 38, 'England'),
	   ('Akiri', 'Una', 27, 'Japan'),
	   ('Stiven', 'Rolls', 25, 'England'),
	   ('Sandra', 'Kembell', 21, 'USA');
	   
select * from customers
where age = (select min(age) from customers);

CREATE TABLE orders(
    id serial primary key,
    amount int,
    customer_id int references customers (id)
);

insert into orders (amount, customer_id)
values (1, 1),
       (1, 2),
	   (0, 3),
	   (4, 4),
	   (0, 5),
	   (0, 6);

select first_name, last_name
from customers
where customers.id not in (select customer_id from orders 
						   where amount = 0);
