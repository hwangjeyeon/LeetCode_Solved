/* Write your T-SQL query statement below */
SELECT project_id, ROUND(SUM(1.0 * E.EXPERIENCE_YEARS) / COUNT(1.0*PROJECT_ID),2) AS average_years 
FROM PROJECT P 
RIGHT JOIN EMPLOYEE E 
ON P.EMPLOYEE_ID = E.EMPLOYEE_ID
GROUP BY P.PROJECT_ID
HAVING COUNT(1.0*PROJECT_ID) >= 1