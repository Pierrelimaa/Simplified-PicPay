--INSERT into user_tb (name, document, email, password)  values ("John", "01282834633", "test@mail.com", "12345");
CREATE TABLE IF NOT EXISTS user_tb (
    user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    document VARCHAR(14) UNIQUE NOT NULL,
    email VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_tb (
    account_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    document VARCHAR(14) UNIQUE NOT NULL,
    balance DECIMAL
);

INSERT INTO user_tb (name, document, email, password) VALUES ('Maria',  '00011122244','maria@gmail.com', '1234');
INSERT INTO account_tb (document, balance) VALUES ('00011122244', 15000);


INSERT INTO user_tb (name, document, email, password) VALUES ('Pedro',  '00011122233','pedro@gmail.com', 'abc1234');
INSERT INTO account_tb (document, balance) VALUES ('00011122233', 2000);

INSERT INTO user_tb (name, document, email, password) VALUES ('Americanas',  '12345678910001','americanas@gmail.com', 'abcd');
INSERT INTO account_tb (document, balance) VALUES ('12345678910001', 20000);