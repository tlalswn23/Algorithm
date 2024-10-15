-- 코드를 입력하세요
SELECT a.car_id, a.car_type, floor(a.daily_fee * 30 * (100 - c.discount_rate) / 100) as fee
from CAR_RENTAL_COMPANY_CAR as a
left join CAR_RENTAL_COMPANY_RENTAL_HISTORY as b on a.car_id = b.car_id and b.start_date <= '2022-11-30' and b.end_date >= '2022-11-01'
inner join CAR_RENTAL_COMPANY_DISCOUNT_PLAN as c on a.car_type = c.car_type and c.DURATION_TYPE = '30일 이상'
where a.car_type in ('세단', 'SUV') and b.start_date is null
having fee >= 500000 and fee < 2000000
order by fee desc, a.car_type, a.car_id desc
