-- 코드를 입력하세요

select a.flavor
from first_half a, icecream_info b 
where a.flavor = b.flavor
and a.total_order>3000
and b.ingredient_type = 'fruit_based'
order by a.total_order desc;