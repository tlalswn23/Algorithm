-- 코드를 작성해주세요
select a.dept_id as dept_id, a.dept_name_en as dept_name_en, round(avg(b.sal)) as AVG_SAL 
from HR_DEPARTMENT a right outer join HR_EMPLOYEES b on a.dept_id = b.dept_id
group by dept_id order by 3 desc;
