-- 보호 기간이 가장 길었던 동물 두 마리의 아이디와 이름 
SELECT a.animal_id, a.name
from animal_ins a
inner join animal_outs b on a.animal_id = b.animal_id
order by datediff(b.datetime, a.datetime) desc
limit 2