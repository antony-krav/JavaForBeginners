-- updateProductQuantity.sql
-- обновляет количество позиций товара по id
UPDATE product
SET quantity = ?
WHERE id = ?;