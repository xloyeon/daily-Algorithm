-- 코드를 입력하세요
-- 2022년 1월 기준 -> where 조건
-- 저자별, 카테고리별 매출액(판매량*판매가) -> 함수
-- 저자 id, 저자명, 카테고리, 매출액 -> select
-- 저자 id 오름차, 카테고리 내림차 -> 정렬

SELECT AUTHOR_ID, AUTHOR_NAME, CATEGORY, SUM(TOTAL_SALES) AS TOTAL_SALES
FROM
(SELECT C.AUTHOR_ID, C.AUTHOR_NAME, B.CATEGORY, (A.SALES * B.PRICE) AS TOTAL_SALES
FROM
(SELECT BOOK_ID, SALES_DATE, SALES
FROM BOOK_SALES
WHERE EXTRACT(YEAR FROM SALES_DATE) = 2022
AND EXTRACT(MONTH FROM SALES_DATE) = 1) A,
BOOK B,
AUTHOR C
WHERE A.BOOK_ID = B.BOOK_ID
AND B.AUTHOR_ID = C.AUTHOR_ID) F
GROUP BY AUTHOR_ID, CATEGORY
ORDER BY AUTHOR_ID, CATEGORY DESC;
