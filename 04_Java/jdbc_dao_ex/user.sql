CREATE DATABASE user_ex;
USE user_ex;

CREATE TABLE users (
                       id			INT PRIMARY KEY AUTO_INCREMENT,
                       email		VARCHAR(100) UNIQUE NOT NULL,
                       password	VARCHAR(100) NOT NULL
);

INSERT INTO users (email, password)
VALUES	('tetz', '1234'),
          ('siwan', '1234'),
          ('na', '1234');


SELECT * FROM users;