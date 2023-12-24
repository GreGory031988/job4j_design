select pp.name, pp.color, p.number 
from product as pp join vendor_code as p on pp.vendor_code_id = p.id;

select pp.name as Название, pp.color as Цвет, p.number as Номер
from product as pp join vendor_code as p on pp.vendor_code_id = p.id;

select pp.name as "Название товара", pp.color Цвет, p.number Номер
from product as pp join vendor_code as p on pp.vendor_code_id = p.id;