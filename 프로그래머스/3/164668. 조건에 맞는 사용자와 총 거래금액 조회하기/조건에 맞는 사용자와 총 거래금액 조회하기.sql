-- 코드를 입력하세요
SELECT b.user_id, b.nickname, sum(a.price) as total_sales
from used_goods_board a
left join used_goods_user b on b.user_id = a.writer_id
where status = 'DONE'
group by b.user_id
having sum(price) >= 700000
order by total_sales
