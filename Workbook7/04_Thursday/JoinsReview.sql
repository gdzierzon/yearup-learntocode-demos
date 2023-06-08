use northwind;

/*
6.	List the 

	order id
    , order date
    , ship name
    , ship address 
    
    of all orders that 
    ordered "Sasquatch Ale"?  
*/

SELECT *
FROM Orders;

SELECT *
FROM Products
WHERE ProductName LIKE 'Sas q%';

SELECT o.OrderId
	, o.OrderDate
    , o.ShipName
    , o.ShipAddress
    -- , p.ProductName
    , c.CompanyName
FROM orders AS o
INNER JOIN customers as c
	ON o.CustomerId = c.CustomerId
INNER JOIN `order details` AS od
	ON o.OrderId = od.OrderId
INNER JOIN products AS p
	ON od.ProductId = p.ProductId
WHERE p.ProductName = 'Sasquatch Ale';


SELECT CompanyName
	, OrderId
	, OrderDate
FROM customers as c
INNER JOIN orders as o
	ON c.CustomerId = o.CustomerId
WHERE c.CustomerId = 'ALFKI';

SELECT CompanyName
	, OrderId
	, OrderDate
FROM customers AS c
	, orders AS o
WHERE o.CustomerId = c.CustomerId
	AND c.CustomerId = 'ALFKI';

