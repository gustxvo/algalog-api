CREATE TABLE occurrence(
	id serial PRIMARY KEY,
	delivery_id int NOT NULL,
	description text NOT NULL,
	register_date timestamp NOT NULL,
	CONSTRAINT fk_occurrence_delivery
	FOREIGN KEY(delivery_id) REFERENCES delivery(id)
)