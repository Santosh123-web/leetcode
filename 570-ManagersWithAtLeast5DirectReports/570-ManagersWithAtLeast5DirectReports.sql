-- Last updated: 7/16/2026, 4:06:53 PM
# Write your MySQL query statement below
# Write your MySQL query statement below
select e.name 
from Employee e
join Employee  emp  
on e.id = emp.managerId 
group by e.name,e.id
having count(*) > 4 ;
/*SELECT m.name
FROM Employee m
JOIN Employee e
ON m.id = e.managerId
GROUP BY m.id, m.name
HAVING COUNT(*) >= 5;*/