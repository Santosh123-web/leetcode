-- Last updated: 7/16/2026, 4:06:28 PM
# Write your MySQL query statement below
SELECT *
FROM cinema c
WHERE c.id % 2 =1
    AND
    c.description != 'boring'
ORDER BY c.rating DESC;