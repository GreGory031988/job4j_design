select c.id, c.name as car_name,
	   b.name as body_name
from cars c 
	           right join car_bodies b on c.bodies_id = b.id
where c.id is null;

select c.id, c.name as car_name,
	   e.name as engine_name
from cars c 
	           right join car_engines e on c.engines_id = e.id
where c.id is null;

select c.id, c.name as car_name,
	   t.name as transmission_name
from cars c 
	           right join car_transmissions t on c.transmissions_id = t.id
where c.id is null;