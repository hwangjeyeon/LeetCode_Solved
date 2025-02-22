# Write your MySQL query statement below
select a.employee_id from Employees as a
left join employees as b
on a.manager_id = b.employee_id
where a.salary < 30000 and b.employee_id is null and a.manager_id is not null
order by employee_id