-- 코드를 입력하세요
select a.history_id as history, floor(b.daily_fee * (datediff(a.end_date, a.start_date) +1)* ((100 - ifnull(c.discount_rate, 0))/100)) as fee
from(SELECT *,
             CASE
                 WHEN datediff(end_date, start_date) + 1 < 7 THEN NULL
                 WHEN datediff(end_date, start_date) + 1 < 30 THEN '7일 이상'
                 WHEN datediff(end_date, start_date) + 1 < 90 THEN '30일 이상'
                 ELSE '90일 이상'
                 END duration_type
      FROM car_rental_company_rental_history) as a
left join CAR_RENTAL_COMPANY_CAR as b on a.car_id = b.car_id
left join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as c on b.car_type = c.car_type and a.duration_type = c.duration_type
where b.car_type = '트럭'
order by 2 desc, 1 desc
