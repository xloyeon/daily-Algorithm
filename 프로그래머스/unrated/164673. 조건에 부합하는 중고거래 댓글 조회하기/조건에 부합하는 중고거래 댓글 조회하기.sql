-- 코드를 입력하세요
SELECT A.TITLE,
       A.BOARD_ID,
       B.REPLY_ID,
       B.WRITER_ID,
       B.CONTENTS,
       TO_CHAR(B.CREATED_DATE, 'YYYY-MM-DD')
FROM USED_GOODS_BOARD A, USED_GOODS_REPLY B
WHERE A.BOARD_ID = B.BOARD_ID
AND EXTRACT(YEAR FROM A.CREATED_DATE) = 2022
AND EXTRACT(MONTH FROM A.CREATED_DATE) = 10
ORDER BY B.CREATED_DATE, A.TITLE;