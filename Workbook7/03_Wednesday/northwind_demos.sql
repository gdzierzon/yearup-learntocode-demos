USE northwind;

-- give me every customer name
-- and the name and price of products that they have ordered
SELECT c.CustomerId
	, c.CompanyName
	, p.ProductName
	, p.UnitPrice
FROM customers AS c
INNER JOIN orders as o
	ON c.customerId = o.customerId
INNER JOIN `order details` as od
	ON o.orderId = od.orderId
INNER JOIN products AS p
	ON od.productId = p.productId;
    
    
-- self-join

-- list all employee names and their managers name
SELECT CONCAT(emp.FirstName, ' ', emp.LastName) AS Employee
    , CONCAT(mgr.FirstName, ' ', mgr.LastName) AS Manager
FROM employees AS emp
LEFT JOIN employees AS mgr
	ON emp.ReportsTo = mgr.EmployeeId;




