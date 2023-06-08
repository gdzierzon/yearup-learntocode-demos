USE world;

/*
CRUD

C - Create => INSERT
R - Read   => SELECT
U - Update => UPDATE
D - Delete => DELETE

*/

-- INSERT
/*
Syntax

INSERT INTO <table_name> (columns...)
VALUES (<values for each column>);

*/

INSERT INTO city (Name, CountryCode, District, Population)
VALUES ('Grantsville', 'USA', 'Utah', 11000);

SELECT * 
FROM city
WHERE District = 'Utah';

-- This will fail because WHO is NOT a country in our database
--    - the CountryCode is a Foreign Key constraint which prevents this
INSERT INTO city (Name, CountryCode, District, Population)
VALUES ('Whoville', 'WHO', 'Whooligans', 1000);

SELECT *
FROM city
WHERE CountryCode = 'WHO';

INSERT INTO country (Code, Name)
VALUES ('WHO', 'Who Knew');

SELECT *
FROM country
WHERE Code = 'WHO';


-- UPDATE
/*
Syntax

UPDATE <table_name>
SET <column1> = <value>
	[, <column2> = <value>]
WHERE <filter>;

*/

SELECT *
FROM city
WHERE Name = 'Grantsville';

-- this allows update without 
-- specifying the PK field in the WHERE clause
SET SQL_SAFE_UPDATES=0;

UPDATE city
SET population = 13574
	, CountryCode = 'USA'
WHERE Name = 'Grantsville';

-- DELETE
/*
Syntax

DELETE FROM <table_name>
WHERE <filter>;

*/

DELETE FROM city
WHERE Name = 'Grantsville';

SELECT * 
FROM city
WHERE Name = 'Grantsville' ;

-- before I can delete country WHO
-- I MUST delete any cities in that country

DELETE FROM city
WHERE CountryCode = 'WHO';

-- I can now delete the country
-- because there are no cities with that code
DELETE FROM country
WHERE Code = 'WHO';



















