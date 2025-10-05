-- updateProductPrice.sql
-- обновляет цену товара по ИД
UPDATE product
SET price = ?
WHERE id = ?;