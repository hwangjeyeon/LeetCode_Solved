/* Write your T-SQL query statement below */
SELECT user_id, CONCAT(SUBSTRING(UPPER(NAME), 1,1), SUBSTRING(LOWER(NAME), 2, LEN(NAME)-1)) as name
FROM USERS
ORDER BY USER_ID