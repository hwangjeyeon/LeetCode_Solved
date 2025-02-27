# Write your MySQL query statement below
select user_id, name, mail from Users
where mail Regexp '^[a-zA-Z][A-Za-z0-9_\.\-]*@leetcode(\\?com)?\\.com$'