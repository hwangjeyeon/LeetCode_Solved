/* Write your T-SQL query statement below */
SELECT patient_id, patient_name, conditions FROM PATIENTS 
WHERE CONDITIONS LIKE 'DIAB1%' OR CONDITIONS LIKE '% DIAB1%'