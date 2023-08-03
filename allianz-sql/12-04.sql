SELECT customer_id, COUNT(customer_id) as num
FROM payment
GROUP BY customer_id
ORDER BY num DESC;