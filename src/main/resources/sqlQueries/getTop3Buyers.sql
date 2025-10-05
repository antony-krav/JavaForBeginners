-- Top3Buyers
-- Топ 3 покупателя по сумме покупок
select
	c.first_name || ' ' || c.last_name as "Имя",
	sum(p.price * o.quantity)  as "Сумма покупок"
from customer c
inner join order o
	on c.id  = o.customer_id
inner join product p
	on o.product_id  = p.id
group by c.first_name || ' ' || c.last_name
order by 2 desc
limit 3;