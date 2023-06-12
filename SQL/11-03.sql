SELECT first_name
FROM customer
EXCEPT
SELECT first_name
FROM actor;