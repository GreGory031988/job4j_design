select avg(price) from devices;

select s.name, avg(ss.price)
from devices_people as sss
join people as s on sss.people_id = s.id
join devices as ss on sss.device_id = ss.id
group by s.name;


select s.name, avg(ss.price)
from devices_people as sss
join people as s on sss.people_id = s.id
join devices as ss on sss.device_id = ss.id
group by s.name
having avg(ss.price) > 5000;