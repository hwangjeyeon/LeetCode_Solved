# Write your MySQL query statement below
select customer_id from Customer as a
group by a.customer_id
having count(distinct a.product_key) = (select count(b.product_key) from Product as b);