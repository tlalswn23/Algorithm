-- 생산일자가 2022-05인 식품 정보
SELECT a.product_id, a.product_name, sum(b.amount*a.price) as total_sales
from food_product a
inner join food_order b on a.product_id = b.product_id
where b.produce_date like '2022-05-%'
group by b.product_id 
order by 3 desc, 1