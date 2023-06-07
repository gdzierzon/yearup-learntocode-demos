USE chores;

-- look at each table individually
SELECT *
FROM person;

SELECT *
FROM task;

/*********************************
           INNER JOIN
*********************************/
-- all columns from all tables
SELECT *
FROM person
INNER JOIN task
	ON person.person_id = task.person_id;

-- specifying column names
SELECT person.person_id
	, person.person_name
    , task.task_id
    , task.task_name
FROM person
JOIN task -- INNER is implied
	ON person.person_id = task.person_id;
    

-- use table aliases
SELECT p.person_id
	, p.person_name
    , t.task_id
    , t.task_name
FROM person AS p
INNER JOIN task AS t
	ON p.person_id = t.person_id;
    
    
-- I want ALL people - even if they don't have a job
-- this is done with OUTER JOINS

SELECT p.person_id
	, p.person_name
    , t.task_id
    , t.task_name
FROM person AS p 
LEFT OUTER JOIN task AS t
	ON t.person_id = p.person_id;
    

-- I want ALL tasks - even if they aren't assigned

SELECT p.person_id
	, p.person_name
    , t.task_id
    , t.task_name
FROM person AS p 
RIGHT JOIN task AS t -- OUTER is implied
	ON t.person_id = p.person_id;
    
/****************************
	  FULL OUTER JOIN
****************************/
-- MySQL does NOT support FULL OUTER JOIN directly
-- this means that MySQL is not ANSI compliant in this regard
-- you can fake a FULL JOIN though

-- use a UNION statement
-- to combine a LEFT JOIN
-- and a RIGHT JOIN
SELECT p.person_id
	, p.person_name
    , t.task_id
    , t.task_name
FROM person AS p 
LEFT OUTER JOIN task AS t
	ON t.person_id = p.person_id
    
UNION

SELECT p.person_id
	, p.person_name
    , t.task_id
    , t.task_name
FROM person AS p 
RIGHT OUTER JOIN task AS t
	ON t.person_id = p.person_id;
    
    


-- Give me every person who DOES NOT have a job
-- this requires an OUTER JOIN
SELECT p.person_id
	, p.person_name
FROM person AS p 
LEFT JOIN task AS t 
	ON t.person_id = p.person_id
WHERE t.task_id IS NULL;

-- can also be done with a sub-query
SELECT *
FROM person AS p
WHERE NOT EXISTS(
	SELECT person_id
    FROM task AS t
    WHERE p.person_id = t.person_id
);


