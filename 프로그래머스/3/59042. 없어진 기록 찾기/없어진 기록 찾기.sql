-- 코드를 입력하세요
SELECT b.animal_id, b.name
from animal_ins a
right join animal_outs b on a.animal_id = b.animal_id
where b.datetime is not null and a.datetime is null
order by a.name

