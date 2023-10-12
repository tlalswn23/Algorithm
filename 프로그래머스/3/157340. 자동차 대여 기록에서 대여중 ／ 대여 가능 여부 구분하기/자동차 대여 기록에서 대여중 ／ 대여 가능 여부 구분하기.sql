-- 코드를 입력하세요
# SELECT distinct car_id, if(car_id in (select distinct car_id from car_rental_company_rental_history where '2022-10-06' between start_date and end_date), '대여중', '대여 가능') as AVAILABILTIY
# from car_rental_company_rental_history
# order by car_id desc

SELECT DISTINCT CAR_ID, 
IF(CAR_ID IN (SELECT DISTINCT CAR_ID FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE), '대여중', '대여 가능') AS AVAILABILTIY 
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY 
ORDER BY CAR_ID DESC