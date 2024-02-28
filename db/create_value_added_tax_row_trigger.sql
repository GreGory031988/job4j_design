create
or replace function value_added_tax_row()
    returns trigger as
$$
    BEGIN
        NEW.price = NEW.price * 1.2;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';

create trigger value_added_tax_row_trigger
    before insert
    on products
    for each row
    execute procedure value_added_tax_row();
