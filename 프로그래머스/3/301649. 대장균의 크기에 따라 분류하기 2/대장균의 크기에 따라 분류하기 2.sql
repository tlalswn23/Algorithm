-- 코드를 작성해주세요
with rank_info as(
    select id, percent_rank() over(order by size_of_colony desc) as size_rank
    from ecoli_data
)

select id, (case when size_rank <= 0.25 then 'CRITICAL'
           when size_rank <= 0.50 then 'HIGH'
           when size_rank <= 0.75 then 'MEDIUM'
           when size_rank <= 100 then 'LOW' end) as colony_name
           from rank_info
           order by id
