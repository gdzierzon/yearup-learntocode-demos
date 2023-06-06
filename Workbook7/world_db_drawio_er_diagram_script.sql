CREATE TABLE city (
  ID int  ,
  Name char(35)  ,
  CountryCode char(3)  ,
  District char(20)  ,
  Population int  ,
  PRIMARY KEY (ID),
  KEY CountryCode (CountryCode)
);

CREATE TABLE country (
  Code char(3)  ,
  Name char(52)  ,
  Continent varchar(20),
  Region char(26)  ,
  SurfaceArea decimal(10,2),
  IndepYear smallint ,
  Population int  ,
  LifeExpectancy decimal(3,1),
  GNP decimal(10,2),
  GNPOld decimal(10,2),
  LocalName char(45)  ,
  GovernmentForm char(45)  ,
  HeadOfState char(60),
  Capital int,
  Code2 char(2)  ,
  PRIMARY KEY (Code)
);

CREATE TABLE countrylanguage (
  CountryCode char(3),
  Language char(30),
  IsOfficial char(1),
  Percentage decimal(4,1) ,
  PRIMARY KEY (CountryCode,Language)
);