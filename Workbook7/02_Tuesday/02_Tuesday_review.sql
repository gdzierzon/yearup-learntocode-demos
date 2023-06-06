USE northwind;

-- exercise question 6 (modified from 100 units to 50)
SELECT ProductName
	, UnitPrice
	, UnitsInStock
FROM products
WHERE UnitsInStock >= 50
ORDER BY UnitPrice DESC
	, ProductName ASC
;

/*
Rules:
I can sell only products that I have in stock OR that are on order

Question:
List the name, price and number of available units
for any products where I have 100 or more to sell

sort by number of available units
*/
SELECT ProductName
	, UnitPrice
    , UnitsInStock
    , UnitsOnOrder
    , UnitsInStock + UnitsOnOrder AS AvailableUnits
-- FROM is always the 1st clause
FROM products
WHERE (UnitsInStock + UnitsOnOrder) >= 100
-- jump to process the SELECT
-- then Process ORDER BY after the SELECT
ORDER BY AvailableUnits DESC
LIMIT 5
;

-- concatenate
SELECT Address + City
    , Region
    , PostalCode
FROM Customers;

-- ANSI Standard - American National Standards Institue
/*
SQL - SQL statements are standardized

*/

SELECT CONCAT(Address -- CONCAT function is ANSI Standard
			, ', ' 
            ,  City 
            , ', '
            , COALESCE(Region,'')  -- COALESCE replaces NULL with ''
            , ' ' 
            , PostalCode) AS FormattedAddress
FROM Customers;

-- the + is NOT ANSI Standard and each 
-- database engine can decide how they want to handle it
SELECT Address + ', ' +  City + ', ' + Region + ' ' + PostalCode
FROM Customers;




