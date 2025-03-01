# Write your MySQL query statement below
select a.user_id, ifnull(round((select count(c.user_id) from Confirmations as c
where action = 'confirmed' and c.user_id = a.user_id
group by user_id)/count(b.user_id)
,2),0) as confirmation_rate from Signups as a
left join Confirmations as b on a.user_id = b.user_id
group by a.user_id

