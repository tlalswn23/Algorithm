-- 코드를 입력하세요
SELECT a.name, a.datetime
from animal_ins a
left join animal_outs b on a.animal_id = b.animal_id
order by datediff(b.datetime, a.datetime), a.datetime
limit 3
