-- 리뷰를 가장 많이 작성한 회원의 리뷰 
SELECT member_name, a.review_text, date_format(a.review_date, '%Y-%m-%d') as review_date
from rest_review a
left join member_profile b on a.member_id = b.member_id 
where a.member_id = (select member_id from rest_review group by member_id order by count(*) desc limit 1)
order by a.review_date, a.review_text