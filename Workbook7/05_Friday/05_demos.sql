/*
DML = Data Manipulation Language
	SELECT
    INSERT
    UPDATE
    DELETE

DDL - Data Definition Language
	CREATE
    ALTER
    DROP
*/

-- create table syntax

CREATE TABLE instructors_two
(
--  name data_type [optional parameters]
	instructor_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(30) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    
--  after all columns we can add constraints
	PRIMARY KEY(instructor_id)
);

CREATE TABLE classes_two 
(
	class_id INT,
	class_name VARCHAR(30),
	instructor_id INT,
	days VARCHAR(15),
	start_time TIME,
	end_time TIME,
	monthly_price DECIMAL(5,2),
	PRIMARY KEY (class_id), 
    
--  FOREIGN KEY is always defined in the child table
	FOREIGN KEY (instructor_id) REFERENCES instructors_two (instructor_id)
);


