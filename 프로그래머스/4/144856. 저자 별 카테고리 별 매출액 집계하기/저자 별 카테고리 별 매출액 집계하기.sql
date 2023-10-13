-- 2022년 1월의 도서판매 데이터를 바탕으로 저자별, 카테고리별 매출액(판매량*가격)
SELECT a.author_id, b.author_name, a.category, sum(a.price*c.sales) as total_sales
from book a
right join book_sales c on a.book_id = c.book_id
left join author b on a.author_id = b.author_id
where c.sales_date like '2022-01%'
group by author_id, category
order by a.author_id, a.category desc