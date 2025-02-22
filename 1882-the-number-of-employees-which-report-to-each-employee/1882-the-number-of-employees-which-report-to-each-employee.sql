# Write your MySQL query statement below
select employee_id, name, (
    select count(reports_to) from Employees as b where a.employee_id = b.reports_to 
) as reports_count, 
round((select avg(age) from Employees as b where a.employee_id = b.reports_to ))
as average_age
from Employees as a
group by employee_id
having average_age is not null
order by employee_id