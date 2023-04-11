BEGIN TRANSACTION;
DROP TABLE IF EXISTS doctor;

CREATE TABLE doctor (
	doctor_id SERIAL NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	specialty varchar(50) NOT NULL,
	suite_number int NOT NULL,
	costPerHour int NOT NULL,
	appt_date date NOT NULL,
	start_time time NOT NULL,
	end_time time NOT NULL,
	
	CONSTRAINT pk_doctor_doctor_id PRIMARY KEY (doctor_id)
);
COMMIT TRANSACTION;