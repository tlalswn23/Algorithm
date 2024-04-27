-- 코드를 작성해주세요
select a.item_id as ITEM_ID, a.item_name as ITEM_NAME, a.RARITY as RARITY
from item_info as a join item_tree b
on a.item_id = b.item_id
where b.parent_item_id in (select item_id from item_info where RARITY = 'RARE')
order by a.item_id desc