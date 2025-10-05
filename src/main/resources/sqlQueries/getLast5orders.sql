-- last5orders
-- вывод последних 5 заказов с указанием товара и покупателя
select
	o.id as "order_id",
	c.first_name || ' ' || c.last_name as "customer",
	p.description,
	o.quantity,
	p.price,
	o.order_date,
	os.status
from "order" o
inner join customer c
	on o.customer_id  = c.id
inner join product p
	on o.product_id = p.id
inner join order_status os
	on o.status_id = os.id
where o.order_date > now() - interval '7 days'
order by o.order_date desc
limit 5;