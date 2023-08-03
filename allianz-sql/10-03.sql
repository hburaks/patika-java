SELECT rental_id,  first_name, last_name
FROM customer
FULL JOIN rental
ON customer.customer_id = rental.customer_id;