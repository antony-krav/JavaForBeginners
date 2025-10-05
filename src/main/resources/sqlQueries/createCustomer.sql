-- createCustomer.sql
-- Вставка нового покупателя в таблицу customer

INSERT INTO customer (first_name, last_name, phone, email)
VALUES (?, ?, ?, ?);