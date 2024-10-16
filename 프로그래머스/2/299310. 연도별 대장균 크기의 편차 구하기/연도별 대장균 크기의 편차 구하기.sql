-- 코드를 작성해주세요
with max_colony as (
    select max(size_of_colony) as max_size, year(differentiation_date) as year
    from ecoli_data
    group by year(differentiation_date)
)

select year(a.differentiation_date) as year, (b.max_size - a.size_of_colony) as year_dev, a.id
from ecoli_data a
left join max_colony b on year(a.differentiation_date) = b.year
order by 1, 2