-- 보호시작일보다 입양일이 더 빠른 동물
-- select animal_id, name
-- 보호 시작일 빠른 순 정렬

SELECT a.animal_id, a.name
from animal_ins a join animal_outs b on a.animal_id = b.animal_id
where a.datetime >b.datetime
order by a.datetime;