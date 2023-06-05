USE sakila;

-- SELECT * -- all columns
-- FROM film;

-- specify columns with comma
-- separated list
SELECT title
	, release_year
	, length
FROM film;

-- filter with WHERE
SELECT title
	, release_year
	, length
FROM film
WHERE length > 100;

-- filter with WHERE BETWEEN
SELECT title
	, release_year
	, length
FROM film
WHERE length BETWEEN 100 AND 130;

-- filter with WHERE using >= and <=
SELECT title
	, release_year
	, length
FROM film
WHERE length >= 100 AND length <= 130;

-- Films that begin with A
-- filtering text fields
-- LIKE keyword ONLY WORKS WITH strings
SELECT title
	, release_year
	, length
FROM film
WHERE title LIKE 'A% %';

-- checking for NULL
SELECT *
FROM film
WHERE original_language_id IS NOT NULL;

-- I want all customers who have a fax #
SELECT CompanyName
	, Fax
FROM northwind.customers
WHERE Fax IS NOT NULL;

-- all long movies in order of length
SELECT title
	, release_year
	, length
FROM film
WHERE length >= 100
ORDER BY length DESC;

-- DISTINCT
-- what years do we have movies for
SELECT DISTINCT length
FROM film
ORDER BY length DESC;

-- dates are automatically converted from strings
SELECT '5/28/2023';



