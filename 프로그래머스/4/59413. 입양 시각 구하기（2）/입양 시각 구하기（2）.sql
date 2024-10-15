-- 코드를 입력하세요
with recursive time as(
    select 0 as hour
    union all 
    select hour + 1 from time
    where hour < 23
)

SELECT b.hour as hour, count(a.animal_id) as count
from animal_outs as a
right outer join time as b on hour(a.datetime) = b.hour
group by b.hour
order by 1, 2
