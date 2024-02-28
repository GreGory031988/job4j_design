create
or replace function insert_data_two_table_fnc()
    returns trigger as
$$
    BEGIN
        insert into history_of_price (name, price, date)
		values (new.name, new.price, current_date);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger insert_data_two_table_trigger
    after insert
    on products
    for each row
    execute procedure insert_data_two_table_fnc();