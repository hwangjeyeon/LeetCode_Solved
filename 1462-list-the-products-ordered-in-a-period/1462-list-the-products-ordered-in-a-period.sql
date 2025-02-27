# Write your MySQL query statement below
select a.product_name, sum(b.unit) as unit from Products as a
join Orders as b on a.product_id = b.product_id
where year(order_date) = 2020 and month(order_date) = 2
group by product_name
having sum(unit) >= 100