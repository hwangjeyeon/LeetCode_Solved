SELECT employee_id,
(CASE 
    WHEN COUNT(department_id) = 1 THEN MAX(department_id)
    WHEN COUNT(department_id) > 1 AND MAX(primary_flag) = 'Y' 
    THEN MAX(CASE WHEN primary_flag = 'Y' THEN department_id END)
    END 
    ) AS department_id
FROM EMPLOYEE
GROUP BY EMPLOYEE_ID
