/* Write your T-SQL query statement below */
SELECT class FROM COURSES
GROUP BY CLASS
HAVING COUNT(STUDENT) >= 5