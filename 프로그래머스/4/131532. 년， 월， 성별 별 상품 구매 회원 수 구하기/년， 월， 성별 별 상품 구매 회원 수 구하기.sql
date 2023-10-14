-- 코드를 입력하세요
SELECT year(a.sales_date) as year, month(a.sales_date) as month, b.gender, count(distinct a.user_id) as users
from online_sale a
left join user_info b on a.user_id = b.user_id
where b.gender is not null
group by year(a.sales_date), month(a.sales_date), b.gender
order by 1, 2, 3