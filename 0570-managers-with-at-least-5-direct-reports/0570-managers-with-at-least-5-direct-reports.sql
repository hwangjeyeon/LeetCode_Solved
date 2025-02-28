# Write your MySQL query statement below
select a.name from Employee as a
left join Employee as b 
on a.id = b.managerId
group by a.id
having count(a.id) >= 5