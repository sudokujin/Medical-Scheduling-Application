BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, doctor, patient, appointment, review;

CREATE TABLE users (
	user_id SERIAL PRIMARY KEY,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL
);

CREATE TABLE doctor (
	doctor_id SERIAL NOT NULL,
	user_id int NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	specialty varchar(50) NOT NULL,
	suite_number int NOT NULL,
	costPerHour int NOT NULL,
	appt_date date NOT NULL,
	start_time int NOT NULL,
	end_time int NOT NULL,
	
	CONSTRAINT pk_doctor_doctor_id PRIMARY KEY (doctor_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE patient (
	patient_id SERIAL NOT NULL,
	user_id int NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	address varchar(100) NOT NULL,
	city varchar(50) NOT NULL,
	states varchar(50) NOT NULL,
	zipcode varchar(50) NOT NULL,
	email_address varchar(50) NOT NULL,
	patient_number varchar(50) NOT NULL,
	birthdate date NOT NULL,
	
	CONSTRAINT pk_patient_patient_id PRIMARY KEY (patient_id),
	FOREIGN KEY (user_id) REFERENCES users (user_id)
);

CREATE TABLE appointment (
	appointment_id SERIAL NOT NULL,
	patient_id int NOT NULL,
	doctor_id int NOT NULL,
	appointment_duration int NOT NULL,
	description varchar(100) NOT NULL,
	
	CONSTRAINT pk_appointment_appointment_id PRIMARY KEY (appointment_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id)
);

CREATE TABLE review (
	review_id SERIAL NOT NULL,
	review_title varchar(500) NOT NULL,
	review_body varchar(500) NOT NULL,
	review_rating int NOT NULL,
	review_date date NOT NULL,
	doctor_id int NOT NULL,
	patient_id int NOT NULL,
	
	CONSTRAINT pk_review_review_id PRIMARY KEY (review_id),
	CONSTRAINT fk_doctor FOREIGN KEY (doctor_id) REFERENCES doctor (doctor_id),
	CONSTRAINT fk_patient FOREIGN KEY (patient_id) REFERENCES patient (patient_id)
);


COMMIT TRANSACTION;