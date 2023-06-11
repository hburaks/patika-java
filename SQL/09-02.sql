SELECT first_name, last_name, payment_id
FROM customer
INNER JOIN payment
ON payment.customer_id = customer.customer_id;