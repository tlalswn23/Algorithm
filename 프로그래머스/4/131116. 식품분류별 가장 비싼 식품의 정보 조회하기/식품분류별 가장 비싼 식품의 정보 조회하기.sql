-- 각 카테고리에서 제일 비싼 식품의 정보 
SELECT a.category, a.price as max_price, b.product_name
from (select category, max(price) as price
     from food_product 
     where category in ('과자', '국', '김치', '식용유')
    group by category) a
inner join food_product b on a.category = b.category and a.price = b.price
order by 2 desc