# Write your MySQL query statement below
with employee_department as 
(
    select a.id, a.name as department, salary as salary, b.name as Employee,
    dense_rank()over(partition by a.id order by salary desc) as rnk
    from department a
    join employee b
    on a.id = b.departmentId
)

select Department, Employee, Salary
from employee_department
where rnk <= 3
