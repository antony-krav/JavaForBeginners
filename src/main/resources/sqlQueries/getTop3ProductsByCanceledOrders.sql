-- Top3ProductsByCanceledOrders
-- Топ-3 товаров по количеству отмененных заказов
select p.description, sum(o.quantity) as "Кол-во отмененных позиций" from order o
inner join order_status os
	on o.status_id  = os.id
inner join product p
	on o.product_id  = p.id
where os.status  = 'Отменен'
group by  p.description
limit 3;