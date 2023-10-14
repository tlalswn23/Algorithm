-- 서울에 위치한 식당 정보 
SELECT a.rest_id, a.rest_name, a.food_type, a.favorites, a.address, round(avg(b.review_score), 2) as score
from rest_info a
right join rest_review b on a.rest_id = b.rest_id
where a.address like '서울%'
group by b.rest_id
order by 6 desc, 4 desc
