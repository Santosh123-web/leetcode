-- Last updated: 7/16/2026, 4:06:31 PM
# Write your MySQL query statement below
SELECT x,y,z,
case WHEN (x+y) > z AND (x+z) > y AND (y+z) > x THEN 'Yes' ELSE 'No' end AS triangle
FROM Triangle 