# Write your MySQL query statement below
select a.machine_id, round(avg(b.timestamp - a.timestamp), 3) as processing_time from Activity as a
inner join Activity as b on a.process_id = b.process_id
where a.activity_type = 'start' and b.activity_type = 'end' and a.machine_id = b.machine_id
group by machine_id
order by machine_id