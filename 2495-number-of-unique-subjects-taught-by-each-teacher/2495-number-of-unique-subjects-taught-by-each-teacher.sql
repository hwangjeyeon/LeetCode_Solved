/* Write your T-SQL query statement below */
SELECT teacher_id, COUNT(DISTINCT SUBJECT_ID) as cnt FROM TEACHER
GROUP BY teacher_id