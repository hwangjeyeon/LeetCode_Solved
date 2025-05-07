/* Write your T-SQL query statement below */
SELECT A.ID AS Id FROM WEATHER AS A, WEATHER AS B
WHERE DATEDIFF(dd, B.recordDate, A.recordDate) = 1
AND A.TEMPERATURE > B.TEMPERATURE
