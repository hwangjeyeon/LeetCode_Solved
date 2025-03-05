# Write your MySQL query statement below
select a.product_id, a.year as first_year, a.quantity, a.price from Sales as a
where (a.product_id, a.year) in 
(select c.product_id, min(c.year) from Sales as c 
group by product_id)