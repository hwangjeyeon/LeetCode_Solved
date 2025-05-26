/* Write your T-SQL query statement below */
SELECT user_id, COUNT(DISTINCT FOLLOWER_ID) as followers_count 
FROM FOLLOWERS
GROUP BY USER_ID