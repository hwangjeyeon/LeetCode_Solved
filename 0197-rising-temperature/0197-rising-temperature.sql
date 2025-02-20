# Write your MySQL query statement below
select a.id as Id from Weather as a
inner join Weather as b on datediff(a.recordDate,b.recordDate) = 1
where a.temperature > b.temperature
