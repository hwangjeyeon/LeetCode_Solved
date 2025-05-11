/* Write your T-SQL query statement below */
SELECT A.student_id, A.student_name, C.subject_name, (count(B.subject_name)) as attended_exams
FROM Students A 
CROSS JOIN Subjects C
LEFT JOIN Examinations B ON A.student_id = B.student_id 
AND C.subject_name = B.subject_name
GROUP BY A.student_id, A.student_name, C.subject_name
ORDER BY A.student_id, A.student_name, C.subject_name
