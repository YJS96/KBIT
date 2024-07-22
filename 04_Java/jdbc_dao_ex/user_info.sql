USE user_ex;

CREATE TABLE user_info (
    id      INT PRIMARY KEY,
    name    VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES users (id) ON DELETE CASCADE
);

INSERT INTO user_info (id, name)
VALUES  ('1', '이효석'),
        ('2', '김시완'),
        ('3', '나건우');