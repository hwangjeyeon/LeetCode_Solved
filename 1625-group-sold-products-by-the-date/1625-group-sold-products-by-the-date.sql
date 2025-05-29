/* Write your T-SQL query statement below */
SELECT sell_date, count(PRODUCT) AS num_sold, 
string_agg(product, ',') WITHIN GROUP (ORDER BY product) as products
FROM (SELECT DISTINCT SELL_DATE, PRODUCT FROM ACTIVITIES) AC
GROUP BY AC.SELL_DATE
ORDER BY SELL_DATE