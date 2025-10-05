CREATE TABLE IF NOT EXISTS product (
    id SERIAL PRIMARY KEY,
    description TEXT NOT NULL,
    price DECIMAL(10,2) NOT NULL CHECK (price >= 0),
    quantity INTEGER NOT NULL CHECK (quantity >= 0),
    category VARCHAR(50)
);

CREATE UNIQUE INDEX product_id_idx ON product (id);

COMMENT ON TABLE product IS 'Таблица содержащая данные о продуктах';
COMMENT ON COLUMN product.id IS 'Идентификатор';
COMMENT ON COLUMN product.description IS 'Описание';
COMMENT ON COLUMN product.price IS 'Цена';
COMMENT ON COLUMN product.quantity IS 'Количество';
COMMENT ON COLUMN product.category IS 'Категория';


CREATE TABLE IF NOT EXISTS customer (
    id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    phone VARCHAR(20),
    email VARCHAR(255) UNIQUE
);

CREATE UNIQUE INDEX customer_id_idx ON customer (id);

COMMENT ON TABLE customer IS 'Таблица содержащая данные о клиентах';
COMMENT ON COLUMN customer.id IS 'Идентификатор';
COMMENT ON COLUMN customer.first_name IS 'Имя';
COMMENT ON COLUMN customer.last_name IS 'Фамилия';
COMMENT ON COLUMN customer.phone IS 'Телефон';
COMMENT ON COLUMN customer.email IS 'Адрес электронной почты';

CREATE TABLE IF NOT EXISTS order_status (
    id SERIAL PRIMARY KEY,
    status VARCHAR(20) NOT NULL
);

CREATE UNIQUE INDEX order_status_id_idx ON order_status (id);

COMMENT ON TABLE order_status IS 'Справочник статусов заказов';
COMMENT ON COLUMN order_status.id IS 'Идентификатор';
COMMENT ON COLUMN order_status.status IS 'Статус';

CREATE TABLE IF NOT EXISTS "order" (
    id SERIAL PRIMARY KEY,
    product_id INTEGER REFERENCES product(id),
    customer_id INTEGER REFERENCES customer(id),
    order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    quantity INTEGER NOT NULL CHECK (quantity > 0),
    status_id INTEGER REFERENCES order_status(id)
);

CREATE UNIQUE INDEX order_id_idx ON "order" (id);
CREATE INDEX order_product_id_idx ON "order" (product_id);
CREATE INDEX order_customer_id_idx ON "order" (customer_id);
CREATE INDEX order_order_date_idx ON "order" (order_date);
CREATE INDEX order_order_status_id_idx ON "order" (status_id);

COMMENT ON TABLE "order" IS 'Таблица содержащая данные о заказах';
COMMENT ON COLUMN "order".id IS 'Идентификатор';
COMMENT ON COLUMN "order".product_id IS 'Внешний ключ на таблицу product';
COMMENT ON COLUMN "order".customer_id IS 'Внешний ключ на таблицу customer';
COMMENT ON COLUMN "order".order_date IS 'Дата заказа';
COMMENT ON COLUMN "order".quantity IS 'Количество';
COMMENT ON COLUMN "order".status_id IS 'Внешний ключ на таблицу order_status';