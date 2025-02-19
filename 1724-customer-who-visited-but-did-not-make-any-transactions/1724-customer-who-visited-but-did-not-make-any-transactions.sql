# Write your MySQL query statement below
select a.customer_id, count(a.customer_id) as count_no_trans from Visits as a
left join Transactions as b on a.visit_id = b.visit_id 
where b.visit_id is null
group by a.customer_id