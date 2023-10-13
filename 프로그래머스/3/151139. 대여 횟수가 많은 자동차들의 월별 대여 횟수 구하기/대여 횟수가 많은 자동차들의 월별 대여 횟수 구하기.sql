-- car_id 당 월별 
SELECT month(start_date) as month, car_id, count(*) as records
from car_rental_company_rental_history 
where car_id in (
    select car_id 
    from car_rental_company_rental_history 
    where month(start_date) between 8 and 10 
    group by car_id 
    having count(*) >= 5) and month(start_date) between 8 and 10
group by month, car_id
order by month, car_id desc