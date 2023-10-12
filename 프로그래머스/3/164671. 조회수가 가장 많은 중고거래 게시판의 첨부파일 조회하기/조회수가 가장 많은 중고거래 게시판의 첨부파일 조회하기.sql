-- 코드를 입력하세요
SELECT concat('/home/grep/src/',a.board_id,'/',a.file_id, a.file_name, a.file_ext) as FILE_PATH
from used_goods_file a
where a.board_id = (select board_id from used_goods_board order by views desc limit 1)
order by a.file_id desc