/* Write your T-SQL query statement below */
SELECT query_name, ROUND( 
    SUM((RATING * 1.0) / (POSITION*1.0))
/ COUNT(QUERY_NAME)
, 2) AS quality, 
ROUND(SUM(
    CASE
    WHEN RATING < 3
    THEN 1 ELSE 0
    END
)* 100.0 / COUNT(RATING) , 2) AS poor_query_percentage 
FROM QUERIES
GROUP BY QUERY_NAME 
