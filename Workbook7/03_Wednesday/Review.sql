USE northwind;

-- Aggregation/Calculation Exercise
-- problem 9
SELECT ProductId
	, ProductName
    , UnitPrice * UnitsInStock AS InventoryValue
FROM products
ORDER BY InventoryValue DESC
	, ProductName;



-- Sub-Query Exercise

-- problem 2
-- demo query to find the shipper id by name
-- I will use this for a sub-query
SELECT ShipperId
FROM shippers
WHERE CompanyName = 'Federal Shipping';

-- write the query without filtering
SELECT OrderId
	, ShipName
    , ShipAddress
    , ShipCity
    , ShipRegion
    , ShipPostalCode
    , ShipVia
FROM orders;
    
-- the final query, with sub-query filter
SELECT OrderId
	, ShipName
    , ShipAddress
    , ShipCity
    , ShipRegion
    , ShipPostalCode
    , ShipVia
FROM orders
WHERE ShipVia = (
	SELECT ShipperId
	FROM shippers
	WHERE CompanyName = 'Federal Shipping'
);