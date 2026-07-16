-- Last updated: 7/16/2026, 4:08:02 PM
SELECT name as Customers
from Customers
where id not in (
    select customerId
    from Orders
);