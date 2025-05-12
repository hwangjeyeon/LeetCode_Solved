/* Write your T-SQL query statement below */
SELECT id, movie, description, rating FROM CINEMA
WHERE DESCRIPTION <> 'boring' AND id % 2 = 1
ORDER BY rating DESC;