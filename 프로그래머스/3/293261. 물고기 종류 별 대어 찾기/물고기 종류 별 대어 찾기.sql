-- 코드를 작성해주세요
select a.id as id, b.fish_name as fish_name, a.length as length
from fish_info a join fish_name_info b on a.fish_type = b.fish_type
where a.length = (select max(length) from fish_info group by fish_type having fish_type = a.fish_type)
