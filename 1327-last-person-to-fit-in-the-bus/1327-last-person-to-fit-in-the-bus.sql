# Write your MySQL query statement below
select person_name from Queue as a1
where 1000 >= (select sum(weight) from Queue as a2 where a2.turn <= a1.turn)
order by turn desc
limit 1