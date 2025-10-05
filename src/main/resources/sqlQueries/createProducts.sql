-- createProduct.sql
-- Вставка нового товара в таблицу product

INSERT INTO product (description, price, quantity, category)
VALUES (?, ?, ?, ?);