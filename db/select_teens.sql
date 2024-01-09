select m.name as male, f.name as female from teens m cross join teens f
where m.gender > f.gender;

