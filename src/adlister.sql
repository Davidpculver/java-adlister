use adlister_db;

DROP TABLE IF EXISTS users;

CREATE TABLE users

(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS ads;

CREATE TABLE ads

(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    user_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    description VARCHAR(500) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);