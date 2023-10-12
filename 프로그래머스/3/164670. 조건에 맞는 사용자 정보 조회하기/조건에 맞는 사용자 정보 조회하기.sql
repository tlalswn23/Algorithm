-- 코드를 입력하세요
SELECT user_id, nickname, concat(city, ' ', street_address1, ' ', street_address2) as 전체주소, concat(substring(tlno, 1, 3), '-', substring(tlno, 4, 4), '-', substring(tlno, 8, 4)) as 전화번호 
from used_goods_user a
inner join used_goods_board b on a.user_id = b.writer_id
group by a.user_id
having count(b.writer_id) >= 3
order by a.user_id desc