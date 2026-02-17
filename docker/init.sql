SET NAMES utf8mb4;

CREATE TABLE orders (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    product_id BIGINT NOT NULL,
    quantity INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO orders (product_id, quantity) VALUES
    (1, 2),
    (2, 5),
    (3, 10);

CREATE TABLE products (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL
);

INSERT INTO products (id, name, price) VALUES
    (1, '商品A', 1000),
    (2, '商品B', 2000),
    (3, '商品C', 3000);
