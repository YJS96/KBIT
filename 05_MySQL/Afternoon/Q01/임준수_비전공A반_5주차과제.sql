-- 1페이지
SHOW DATABASES;
USE employees;
SHOW TABLES;
DESCRIBE employees;
DESC employees;
SHOW COLUMNS FROM employees;


-- 2페이지
SELECT * FROM titles;
SELECT first_name FROM employees;
SELECT first_name, last_name, gender
FROM employees;


-- 3페이지
SELECT first_name AS '이름', gender AS '성별', hire_date AS '회사 입사일'
FROM employees;


-- 4페이지
USE sqldb;
SELECT * FROM usertbl
WHERE name = '김경호';

SELECT * FROM usertbl
WHERE birthyear >= 1970 AND height >= 182;


-- 5페이지
SELECT * FROM usertbl
WHERE height  >= 180 AND height <= 183;

SELECT * FROM usertbl
WHERE addr='경남' OR addr='전북';

SELECT * FROM usertbl
WHERE name LIKE '김%';


-- 6페이지
SELECT name, height FROM usertbl
WHERE height > (SELECT height FROM usertbl
                WHERE name = '김경호');
                
-- 7페이지
SELECT * FROM usertbl ORDER BY mDate;
SELECT * FROM usertbl ORDER BY mDate DESC;
SELECT * FROM usertbl ORDER BY height DESC, name DESC;


-- 8페이지
SELECT DISTINCT addr FROM usertbl ORDER BY addr;