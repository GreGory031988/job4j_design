select * from employees e
         left join departments d on e.departments_id = d.id;

select * from departments d
         right join employees e on e.departments_id = d.id;

select * from employees e
         full join departments d on e.departments_id = d.id;

select * from employees e
         cross join departments d;

select * from departments d
         left join employees e on e.departments_id = d.id
where e.departments_id is null;

select e.name, e.departments_id, d.name
from employees e
         left join departments d on e.departments_id = d.id;
		
select e.name, e.departments_id, d.name
from departments d
         right join employees e on e.departments_id = d.id;