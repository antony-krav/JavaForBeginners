-- Top3Buyers
-- Топ 3 покупателя по сумме покупок
select
	c.first_name || ' ' || c.last_name as "Имя",
	sum(p.price * o.quantity)  as "Сумма покупок"
from customer c
inner join "order" o
	on c.id  = o.customer_id
inner join product p
	on o.product_id  = p.id
group by c.first_name || ' ' || c.last_name
order by 2 desc
limit 3;

-- Top3Products
-- Топ-3 самых популярных товара
select p.description , sum(o.quantity) from "order" o
inner join product p
	on o.product_id  = p.id
group by p.description
order by 2 desc
limit 3;

-- Top3ProductsByCanceledOrders
-- Топ-3 товаров по количеству отмененных заказов
select p.description, sum(o.quantity) as "Кол-во отмененных позиций" from "order" o
inner join order_status os
	on o.status_id  = os.id
inner join product p
	on o.product_id  = p.id
where os.status  = 'Отменен'
group by  p.description
limit 3;

-- TopCustomersWithCanceledOrders
-- Покупатели с наибольшим кол-вом отмененных заказов
select
	c.id as "id покупателя",
	c.first_name || ' ' || c.last_name as "Покупатель",
	count(o.id) as "Кол-во отмененных заказов",
	sum(p.price * o.quantity) as "Сумма отмененных заказов"
from "order" o
inner join customer c
	on o.customer_id  = c.id
inner join order_status os
	on o.status_id  = os.id
inner join product p
	on o.product_id  = p.id
where os.status = 'Отменен'
group by
	c.id,
	c.first_name || ' ' || c.last_name
order by 4
limit 10;