-- Last updated: 7/16/2026, 4:08:04 PM
# Write your MySQL query statement below
SELECT email
FROM Person
GROUP BY email
HAVING COUNT(email) > 1;