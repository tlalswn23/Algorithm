-- 코드를 입력하세요
SELECT hour(datetime) as hour, count(animal_id) as count
from animal_outs
where hour(datetime) >= 9 and hour(datetime) <= 19
group by hour(datetime)
order by 1