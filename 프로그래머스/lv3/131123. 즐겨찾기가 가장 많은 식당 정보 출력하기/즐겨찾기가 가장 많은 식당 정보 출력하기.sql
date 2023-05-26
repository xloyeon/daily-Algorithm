-- 코드를 입력하세요
select a.food_type, a.rest_id, a.rest_name, a.favorites
from rest_info a,
    (select food_type, max(favorites) as max_favorites
    from rest_info
    group by food_type) b
where a.food_type = b.food_type
and a.favorites = b.max_favorites
order by a.food_type desc;
