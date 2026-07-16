-- Last updated: 7/16/2026, 4:08:06 PM
# Write your MySQL query statement below
SELECT E2.name AS Employee
FROM Employee E1
JOIN Employee E2
    ON E1.id = E2.managerId
WHERE E2.salary > E1.salary;