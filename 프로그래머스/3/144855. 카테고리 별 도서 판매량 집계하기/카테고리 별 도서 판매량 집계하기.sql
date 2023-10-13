-- 2022년 1월의 카테고리 별 판매량 
SELECT b.category, sum(a.sales) as total_sales
from book_sales a
left join book b on a.book_id = b.book_id
where a.sales_date like '2022-01%' 
group by b.category
order by b.category