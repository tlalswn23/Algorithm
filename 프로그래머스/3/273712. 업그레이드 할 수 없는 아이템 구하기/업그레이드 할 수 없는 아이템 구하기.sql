-- 코드를 작성해주세요
select a.item_id, a.item_name, a.RARITY 
from item_info a left join item_tree b
on a.item_id = b.PARENT_ITEM_ID
group by a.item_id
having count(b.parent_item_id) = 0
order by 1 desc;
