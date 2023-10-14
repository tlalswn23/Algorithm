-- 2022-04-13 취소되지 않은 흉부외과(CS) 진료 예약 내역
SELECT a.apnt_no, b.pt_name, b.pt_no, c.mcdp_cd, c.dr_name, a.apnt_ymd
from appointment a
left join patient b on a.pt_no = b.pt_no
left join doctor c on a.mddr_id = c.dr_id
where a.apnt_cncl_yn = 'N' and a.mcdp_cd = 'CS' and a.apnt_ymd like '2022-04-13%'
order by a.apnt_ymd