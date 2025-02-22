# Write your MySQL query statement below
delete a from Person as a, Person as b
where a.email = b.email 
and a.id > b.id;