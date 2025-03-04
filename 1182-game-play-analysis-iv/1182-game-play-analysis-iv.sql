# Write your MySQL query statement below
select 
round(count(a.player_id)/(select count(distinct(c.player_id)) from Activity as c), 2)
as fraction
from Activity as a
where (a.player_id, date_sub(event_date, interval 1 day)) in 
(select b.player_id, min(event_date) from Activity as b
group by b.player_id
)