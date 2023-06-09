
/**********************************************************
STEP 1: DROP AND RE-CREATE THE DATABASE

- first switch to sys database so we can drop and 
  re-create the city_fitness db  
**********************************************************/
USE sys;

DROP DATABASE IF EXISTS city_fitness;

CREATE DATABASE city_fitness;

-- switch to city_fitness after creating
-- so that tables are created in the correct database
USE city_fitness;



/**********************************************************
STEP 2: CREATE THE TABLES

- add foreign key constraints while creating the table 
- make sure that you create parent tables first
  because you can't create a foreign key reference
  to a table that does not yet exist
**********************************************************/
CREATE TABLE customers (
  customer_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  PRIMARY KEY (customer_id)
);
-- start auto numbering at 101
ALTER TABLE customers AUTO_INCREMENT = 101;

CREATE TABLE instructors (
  instructor_id INT NOT NULL AUTO_INCREMENT,
  first_name VARCHAR(30) NOT NULL,
  last_name VARCHAR(30) NOT NULL,
  PRIMARY KEY (instructor_id)
);
-- start auto numbering at 201
ALTER TABLE instructors AUTO_INCREMENT = 201;

CREATE TABLE classes (
  class_id INT NOT NULL AUTO_INCREMENT,
  class_name VARCHAR(30) NOT NULL,
  instructor_id INT NOT NULL,
  days VARCHAR(10) NOT NULL,
  start_time TIME NOT NULL,
  end_time TIME NOT NULL,
  monthly_price DECIMAL(5,2) NOT NULL,
  PRIMARY KEY (class_id),
  FOREIGN KEY (instructor_id) REFERENCES instructors(instructor_id)
);
-- start auto numbering at 301
ALTER TABLE classes AUTO_INCREMENT = 301;

CREATE TABLE customer_classes (
  customer_id INT NOT NULL,
  class_id INT NOT NULL,
  PRIMARY KEY (customer_id, class_id),
  FOREIGN KEY (customer_id) REFERENCES customers(customer_id),
  FOREIGN KEY (class_id) REFERENCES classes(class_id)
);

/**********************************************************
Step 3: INSERT DATA
- make sure that you add the data in the correct order
  so that no foreign key constraints are violated
**********************************************************/

INSERT INTO customers(first_name, last_name)
VALUES  ('Benjamin', 'Wilson')
		, ('Sophia','Torres')
		, ('Lucas','Armstrong')
		, ('Natalie','Gibson')
		, ('Carter','Reynolds')
		, ('Amelia','Davis')
		, ('Iris','Peterson');
        
INSERT INTO instructors(first_name, last_name)
VALUES  ('Vivia', 'Harper')
		, ('Gabrielle','Saunders')
		, ('Harrison','Price')
		, ('Isabella','Ferguson')
		, ('Ethan','Thompson');
        
INSERT INTO classes(class_name, instructor_id, days, start_time, end_time, monthly_price)
VALUES  ('Functional Fitness',201,'T H','17:00:00','18:00:00',20)
		, ('CrossFit - 1',202,'M W F','06:00:00','07:30:00',45)
		, ('Muay Thai - Advanced',203,'M W F','18:30:00','19:30:00',30)
		, ('Step Aerobics',204,'M W F','08:00:00','09:00:00',30)
		, ('Spin/Cycling',202,'M W','12:00:00','12:45:00',15)
		, ('Muay Thai - Beginner',203,'T H','16:30:00','19:30:00',20)
		, ('HIIT',204,'T H','08:00:00','09:00:00',20)
		, ('CrossFit - 1',205,'T H','20:00:00','21:00:00',20);
        
INSERT INTO customer_classes(customer_id, class_id)
VALUES  (101,301)
		, (102, 302)
		, (103, 303)
		, (104, 304)
		, (105, 305)
		, (102, 306)
		, (105, 303)
		, (103, 307)
		, (101, 302)
		, (106, 308)
		, (107, 304);

