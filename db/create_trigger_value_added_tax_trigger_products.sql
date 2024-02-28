create
or replace function value_added_tax()
    returns trigger as
$$
    BEGIN
        update products
        set price = price * 1.2
        where id = (select id from inserted);
        return new;
    END;
$$
LANGUAGE 'plpgsql';

create trigger value_added_tax_trigger
    after insert
    on products
    referencing new table as
                    inserted
    for each statement
    execute procedure value_added_tax();

insert into products (name, producer, count, price)
VALUES ('product_4', 'producer_4', 9, 85);

select * from products;