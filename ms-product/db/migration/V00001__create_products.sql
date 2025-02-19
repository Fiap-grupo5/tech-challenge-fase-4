CREATE TABLE products (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    description VARCHAR(255),
    category VARCHAR(100),
    price DECIMAL(10,2),
    stock INT,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY (id)
);
