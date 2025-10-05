INSERT INTO customer (first_name, last_name, phone, email)
VALUES
	('Онуфрий', 'Гришин', '(925)681-30-88', 'Onufrii.Grishin@ya.ru'),
	('Анна', 'Горшкова', '(901)404-31-72', 'Anna_Gorshkova@mail.ru'),
	('Влас', 'Медведев', '(980)913-96-66', 'Vlas.Medvedev92@yahoo.com'),
	('Всемил', 'Медведев', '(997)718-99-88', 'Vsemil_Medvedev@yandex.ru'),
	('Нина', 'Самсонова', '(959)111-82-89', 'Nina.Samsonova@gmail.com'),
	('Агафья', 'Наумова', '(944)821-16-71', 'Agafukya_Naumova73@mail.ru'),
	('Ольга', 'Шарова', '(993)949-60-80', 'Olukga.Sharova56@ya.ru'),
	('Болеслав', 'Захаров', '(932)746-12-16', 'Boleslav_Zakharov12@mail.ru'),
	('Лора', 'Соловьева', '(954)718-80-75', 'Lora_Solovukeva5@mail.ru'),
	('Анастасия', 'Панфилова', '(927)530-83-02', 'Anastasiya_Panfilova97@yandex.ru')
;
INSERT INTO product (description, price, quantity, category)
VALUES
	('Ноутбук HUAWEI MateBook D 16', 49999, 5, 'Ноутбуки'),
	('Ноутбук Apple MacBook Air 13 M1', 69999, 15, 'Ноутбуки'),
	('Ноутбук игровой MSI Katana 17', 84999, 2, 'Ноутбуки'),
	('Ноутбук игровой MSI Titan 18', 439999, 1, 'Ноутбуки'),
	('Холодильник Hisense RB390N4BFE2', 47999, 3, 'Холодильники и морозильные камеры'),
	('Холодильник Indesit ITS 5200 W', 35999, 1, 'Холодильники и морозильные камеры'),
	('Смартфон Apple iPhone 16 Pro Max 256GB Black Titanium', 137999, 20, 'Смартфоны'),
	('Смартфон Apple iPhone 13 128GB Midnight', 49999, 4, 'Смартфоны'),
	('Смартфон Apple iPhone 17 Pro Max 2TB Sim/eSim Silver', 477777, 1, 'Смартфоны'),
	('Смартфон realme Note 60x 3/64GB Black (RMX3938)', 5999, 6, 'Смартфоны')
;
INSERT INTO order_status (status)
VALUES
	('Новый'),
	('Принят в работу'),
	('Выполняется'),
	('Выполнен'),
	('Отложен'),
	('Отменен')
;
INSERT INTO "order" (product_id, customer_id, order_date, quantity, status_id)
VALUES
	(5, 1, '2025-10-05 18:23:48', 1, 2),
	(2, 2, '2025-10-01 09:09:09', 2, 4),
	(4, 3, '2025-10-04 16:23:22', 1, 3),
	(9, 4, '2025-10-02 04:43:34', 10, 6),
	(10, 5, '2025-10-03 20:54:12', 1, 5),
	(6, 6, '2025-10-01 13:19:37', 1, 4),
	(1, 7, '2025-10-04 11:11:11', 1, 3),
	(3, 8, '2025-10-04 18:41:39', 2, 2),
	(7, 9, '2025-10-05 19:12:30', 1, 1),
	(8, 1, '2025-10-05 20:22:57', 2, 1),
	(9, 3, '2025-10-05 16:02:41', 2, 3)
;