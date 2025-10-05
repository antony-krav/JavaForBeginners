-- Top3Products
-- Топ-3 самых популярных товара
select p.description , sum(o.quantity) from order o
inner join product p
	on o.product_id  = p.id
group by p.description
order by 2 desc
limit 3;