SELECT * FROM mydb.user;

INSERT INTO user (name, user_id, password, address, age)
	VALUES ('이효석', 'xenosign3', '1234', '서울시 서대문구', 40);

DELETE FROM user WHERE id_pk = 4;

UPDATE user SET age = age + 1 WHERE id_pk = 1; 

