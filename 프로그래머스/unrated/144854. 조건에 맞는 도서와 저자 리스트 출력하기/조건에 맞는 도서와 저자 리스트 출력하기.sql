-- 코드를 입력하세요
select b.book_id, a.author_name, to_char(b.published_date, 'yyyy-mm-dd')
from book b, author a
where b.author_id = a.author_id
and b.category = '경제'
order by b.published_date;