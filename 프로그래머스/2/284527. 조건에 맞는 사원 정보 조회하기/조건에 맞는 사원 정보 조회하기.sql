-- 코드를 작성해주세요

with best as (
    select emp_no, sum(score) as score
    from hr_grade
    where year = '2022'
    group by emp_no
)  

select b.score, b.emp_no, a.emp_name, a.position, a.email
from hr_employees a
cross join best b on a.emp_no = b.emp_no
order by 1 desc
limit 1


