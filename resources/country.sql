CREATE TABLE country (
  Code String ;
  Name String ;
  Continent String DEFAULT 'Asia',
  Region String ;
  SurfaceArea double ;
  IndepYear int ;
  Population int ;
  LifeExpectancy double ;
  GNP double ;
  GNPOld double ;
  LocalName String ;
  GovernmentForm String ;
  HeadOfState text,
  Capital int ;
  Code2 String DEFAULT NULL
