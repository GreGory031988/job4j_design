select pp.name Наименование, p.name Тип
from product as pp join type as p on pp.type_id = p.id
where p.name = 'Сыр';

select pp.name, pp.expired_date, pp.price, p.name Тип
from product as pp join type as p on pp.type_id = p.id
where pp.name like '%Мороженое%';

select pp.name, pp.expired_date, p.name Тип
from product as pp join type as p on pp.type_id = p.id
where current_date > pp.expired_date;

select name, price from product
group by name, price
having price = (select max(price) from product);

select p.name as имя_типа, count(pp.name) as количество
from product as pp join type as p on pp.type_id = p.id
group by p.name;

select p.name as "имя типа", pp.name
from product as pp join type as p on pp.type_id = p.id
where p.name in ('Сыр', 'Молоко');

select p.name as имя_типа, count(pp.name) as количество
from product as pp join type as p on pp.type_id = p.id
group by p.name
having count(pp.name) < 10;

select pp.name, pp.expired_date, pp.price, p.name
from product as pp join type as p on pp.type_id = p.id;