/* Write your T-SQL query statement below */
SELECT name, population, area FROM WORLD
WHERE AREA >= 3000000
OR POPULATION >= 25000000;