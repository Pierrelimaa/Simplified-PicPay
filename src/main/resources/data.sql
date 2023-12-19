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

INSERT INTO user_tb (name, document, email, password) VALUES ('maria',  '10324567600','maria@gmail.com', '1234');
INSERT INTO account_tb (document, balance) VALUES ('10324567600', 15000);