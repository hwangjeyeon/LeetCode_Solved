# Write your MySQL query statement below
select x, y, z, 
IF(x+y>z and y+z>x and z+x>y, "Yes", "No")
as triangle 
from Triangle