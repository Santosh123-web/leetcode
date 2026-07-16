-- Last updated: 7/16/2026, 4:06:20 PM
# Write your MySQL query statement below
select player_id,min(event_date) as first_login
from Activity
group by player_id