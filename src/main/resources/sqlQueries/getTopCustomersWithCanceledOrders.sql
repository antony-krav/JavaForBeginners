-- TopCustomersWithCanceledOrders
-- Покупатели с наибольшим кол-вом отмененных заказов
select
	c.id as "id покупателя",
	c.first_name || ' ' || c.last_name as "Покупатель",
	count(o.id) as "Кол-во отмененных заказов",
	sum(p.price * o.quantity) as "Сумма отмененных заказов"
from order o
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