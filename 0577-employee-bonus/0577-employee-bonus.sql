/* Write your T-SQL query statement below */
SELECT name, bonus FROM EMPLOYEE AS E
LEFT JOIN BONUS AS B ON E.EMPID = B.EMPID
WHERE BONUS < 1000 OR BONUS IS NULL