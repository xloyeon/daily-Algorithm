-- 코드를 입력하세요
select mcdp_cd as "진료과코드", count(*) as "5월예약건수"
from appointment
where extract(year from apnt_ymd) = 2022
and extract(month from apnt_ymd) = 5
group by mcdp_cd
order by count(*), mcdp_cd;