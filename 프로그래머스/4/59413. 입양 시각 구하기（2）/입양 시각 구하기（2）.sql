with recursive hour_table as(
    select 0 as hour 
    union all
    select hour + 1
    from hour_table
    where hour < 23
)

# -- 코드를 입력하세요
SELECT a.hour as hour, count(b.animal_id) as count
from hour_table a 
left outer join animal_outs b on a.hour = hour(b.datetime)
group by a.hour
order by 1