-- 코드를 작성해주세요
select year(a.DIFFERENTIATION_DATE) as year, (b.max_value - a.size_of_colony) as year_dev, a.id
from ecoli_data a
left join (select max(size_of_colony) as max_value, year(DIFFERENTIATION_DATE) as years from ecoli_data group by year(DIFFERENTIATION_DATE)) as b on year(a.DIFFERENTIATION_DATE) = b.years
order by 1, 2
