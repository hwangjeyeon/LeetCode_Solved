# Write your MySQL query statement below
select b.contest_id, round((count(distinct a.user_id)*100 / (
    select count(user_id) from Users
)) , 2)
as percentage from Users as a
inner join Register as b 
on a.user_id = b.user_id
group by contest_id
order by percentage desc, contest_id asc