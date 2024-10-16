with rank_member as(
    select member_id, rank () over(order by count(review_id) desc) as ranking
    from rest_review 
    group by member_id
)

-- 코드를 입력하세요
SELECT member_name, a.review_text, date_format(a.review_date,'%Y-%m-%d') as review_date
from rest_review a
left join member_profile b on a.member_id = b.member_id
left join rank_member c on a.member_id = c.member_id
where c.ranking = 1
order by 3, 2

-- 리뷰를 가장 많이 작성한 회원의 리뷰 목록 조회
