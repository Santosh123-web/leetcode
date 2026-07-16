-- Last updated: 7/16/2026, 4:06:32 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
select id, case 
when p_id is null then 'Root'
when p_id in (select id from tree) and id in (select p_id from tree) then 'Inner'
ELSE 'Leaf'
end as type
from Tree