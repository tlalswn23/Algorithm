-- 코드를 입력하세요
SELECT a.product_code as product_code, (a.price * b.cnt) as sales
from product a
join (select product_id, sum(sales_amount) as cnt 
      from offline_sale 
      group by product_id 
      having sum(sales_amount) > 0) 
      b on a.product_id = b.product_id
order by 2 desc, 1 asc