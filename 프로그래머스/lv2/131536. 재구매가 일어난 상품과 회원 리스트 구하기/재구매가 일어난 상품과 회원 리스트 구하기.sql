select user_id, product_id
from
    (select user_id, product_id, count(*) as count
    from online_sale
    group by (user_id, product_id))
where count >1
order by user_id, product_id desc;