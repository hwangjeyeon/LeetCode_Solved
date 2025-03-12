# Write your MySQL query statement below
(select b.name as results from MovieRating as a
left join Users as b
on a.user_id = b.user_id
group by a.user_id
order by count(*) desc, name
limit 1)
union all
(select title as results from MovieRating as a
left join Movies as b on a.movie_id = b.movie_id
where year(created_at) = '2020' and month(created_at) = '2'
group by a.movie_id
order by avg(a.rating) desc, title
limit 1)
