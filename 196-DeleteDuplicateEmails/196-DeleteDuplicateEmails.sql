-- Last updated: 7/16/2026, 4:07:53 PM
# Write your MySQL query statement below
DELETE
   p1
FROM
   person as p1
INNER JOIN
   person as p2
ON 
   p1.email = p2.email
   AND
   p1.id>p2.id