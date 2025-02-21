CREATE TABLE logistics (
    id BIGINT NOT NULL AUTO_INCREMENT,
    order_id BIGINT NOT NULL,
    delivery VARCHAR(100),
    status VARCHAR(20),
    estimated_date DATETIME,
    delivery_date DATETIME,
    created_at DATETIME,
    updated_at DATETIME,
    PRIMARY KEY (id)
);
