CREATE TABLE delivery (
    id serial PRIMARY KEY,
	client_id bigint NOT NULL,
	fee decimal(10,2) NOT NULL,
	status varchar(20) NOT NULL,
	request_date timestamp NOT NULL,
	finish_date timestamp,

	addressee_name varchar(60) NOT NULL,
	addressee_street varchar(255) NOT NULL,
	addressee_number varchar(30) NOT NULL,
	addressee_complement varchar(60),
	addressee_district varchar(30) NOT NULL,

	CONSTRAINT fk_client
	FOREIGN KEY(client_id) REFERENCES client(id)
	ON DELETE CASCADE
)