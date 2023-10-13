-- 7월 주문량 + 상반기 주문량 큰 순서대로 3위 
SELECT a.flavor 
from first_half a
left outer join july b on a.flavor = b.flavor
group by a.flavor
order by b.total_order+sum(a.total_order) desc
limit 3