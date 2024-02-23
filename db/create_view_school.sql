create view show_count_pupils_on_subjects
as
select su.name as предмет, c.name as класс, count (p.name) as "количество учеников"
from classes as c
         join schedule sc on c.id = sc.id_class
         join subjects su on su.id = sc.id_subject
		 join pupils p on c.id = p.id_classes
where c.name like '4%' and su.name like 'русский язык'
group by (c.name, su.name)
having count (p.name) > 2;