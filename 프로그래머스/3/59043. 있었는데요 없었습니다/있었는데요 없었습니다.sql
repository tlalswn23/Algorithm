-- 코드를 입력하세요
SELECT a.animal_id as animal_id, a.name as name
from animal_ins as a
left join animal_outs as b on a.animal_id = b.animal_id
where a.datetime > b.datetime
order by a.datetime