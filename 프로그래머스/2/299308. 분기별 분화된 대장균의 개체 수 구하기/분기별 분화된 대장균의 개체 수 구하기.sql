-- 코드를 작성해주세요
select b.quarter as quarter, count(a.id) as ecoli_count
from ecoli_data a left join (select (case when month(DIFFERENTIATION_DATE) between 1 and 3 then '1Q'
                                    when month(DIFFERENTIATION_DATE) between 4 and 6 then '2Q'
                                    when month(DIFFERENTIATION_DATE) between 7 and 9 then '3Q'
                                    else '4Q' end) as quarter, id
                                    from ecoli_data
                             ) b on a.id = b.id
                            group by b.quarter
                            order by 1