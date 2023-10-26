ALTER TABLE cars ADD PRIMARY KEY (id);
ALTER TABLE users ADD PRIMARY KEY (id);
ALTER TABLE orders ADD PRIMARY KEY (id);
ALTER TABLE details ADD PRIMARY KEY (id);

ALTER TABLE orders 
	ADD CONSTRAINT fk_user_id FOREIGN KEY (client_id) REFERENCES users (id);
	
ALTER TABLE details 
	ADD CONSTRAINT fk_car_id FOREIGN KEY (car_id) REFERENCES cars (id),
	ADD CONSTRAINT fk_order_id FOREIGN KEY (order_id) REFERENCES orders (id);
	