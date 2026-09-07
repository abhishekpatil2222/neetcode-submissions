-- Write your query below

select name 
    from sales_person
    where sales_id not in(select sales_id
                            from orders o, company c
                            where c.com_id = o.com_id and
                                c.name = 'CRIMSON');