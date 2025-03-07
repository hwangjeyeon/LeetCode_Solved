# Write your MySQL query statement below
select distinct a1.num as ConsecutiveNums from Logs as a1, Logs as a2, Logs as a3
where a1.id = a2.id-1 and  a2.id = a3.id-1 and a1.num = a2.num and a2.num = a3.num