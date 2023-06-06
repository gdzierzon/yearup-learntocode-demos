USE world;

-- start by looking at the rows in the city table
-- so that I can know what data I am dealing with
SELECT *
FROM city;

-- counts all cities
SELECT COUNT(*)
FROM city;

-- look at columns and data available
-- in the country table
SELECT *
FROM country;

-- count all countries
SELECT COUNT(*) AS NumberOfCountries
	, COUNT(IndepYear) AS IndependentCountries
    , MIN(IndepYear) AS FirstIndependenceYear
    , MAX(IndepYear) AS LastIndependeceYear
FROM country;

-- count all countries that have an independence year
SELECT COUNT(*) as IndependentCountryCount
FROM country
WHERE IndepYear IS NOT NULL; -- only include countries who have an independece year

-- sort by population to see the unaggregated data
SELECT * 
FROM country
ORDER BY population ASC;

-- perform different aggregations on the population
SELECT SUM(population) AS WorldPopulation
	, AVG(population) AS AveragePopulation
    , MIN(population) AS LowestPopulation
    , MAX(population) AS HighestPopulation
FROM country
WHERE population > 0;

-- Use a SUB-QUERY to get the 
-- name and lifeexpectancy of the most populated country
SELECT `Name`
	, LifeExpectancy
FROM country
WHERE population = (
					 -- the only purpose of this sub-query is to determine the 
                     -- highest population
                     SELECT MAX(population) FROM country
				   );
                   
-- another way to get the
-- answer without a sub query
-- this is only possible because
-- we are interested in the most populated country
SELECT `Name`
	, LifeExpectancy
FROM country
WHERE population 
ORDER BY population DESC
LIMIT 1;


-- GROUP BY and HAVING

-- query to help us focus on
-- a subset of the data
SELECT Name
	, Continent
    , Region
    , Population
FROM country;

-- GROUP BY is required for non-aggregated 
-- columns if ANY column has an aggregation function
SELECT continent
	, SUM(population) AS population
FROM country
GROUP BY continent
ORDER BY population DESC;

-- just looking at data - so that I can decide how to group
SELECT Continent
    , Region
    , Population
FROM country
ORDER BY Continent
	, Region;
    

SELECT Continent
    , Region
    , AVG(population) AS AveragePopulation
FROM country
GROUP BY Continent
	, Region
ORDER BY Continent
	, Region;
  

-- if I want to see the continent
-- and region for all regions
-- who have less than 5 countries in the region
SELECT Continent
	, Region
	, COUNT(*) as CountryCount
FROM country
-- WHERE CountryCount < 5 -- WHERE is a filter only for columns that exist in the table
GROUP BY Continent
	, Region
-- WE want to filter AFTER the grouping
HAVING COUNT(*) < 5 -- HAVING is a filter for after the grouping has finished
ORDER BY Continent
	, CountryCount
LIMIT 1;

  
-- the IN function

-- what if I want the names
-- of all cities in the British Islands
SELECT *
FROM city
WHERE CountryCode IN('GBR', 'IRL', 'CUB');

SELECT *
FROM city
WHERE CountryCode IN (
	SELECT Code
	FROM country
	WHERE Region = 'Caribbean' -- 'British Islands';
);

