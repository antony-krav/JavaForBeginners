-- createOrder.sql
-- Создание нового заказа
INSERT INTO "order" (product_id, customer_id, quantity, status_id, order_date)
VALUES (?, ?, ?, ?, NOW());
