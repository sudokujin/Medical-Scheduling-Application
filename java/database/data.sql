-- STEP 3
BEGIN TRANSACTION;

INSERT INTO doctor
(first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time)
VALUES('Qing','Jin','Dermontology',3, 3000,'2023/10/08' , '8:00:00', '5:00:00');
INSERT INTO doctor
(first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time)
VALUES('Jordan','Bruntz','Bones',4, 4000, '2023/10/08', '8:00:00', '5:00:00');
INSERT INTO doctor
(first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time)
VALUES('Dom','Lorenz','Heart Surgeon', 5, 6000, '2023/10/10', '8:00:00', '5:00:00');
INSERT INTO doctor
(first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time)
VALUES('Salaj','Choudhary','Brain doctor', 6, 8000, '2023/10/09', '8:00:00', '5:00:00');
INSERT INTO doctor
(first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time)
VALUES('Youngjin','Kwon','Psychologist', 7, 9000, '2023/10/09', '8:00:00', '5:00:00');

INSERT INTO patient(
	first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES ('Pan', 'Bam', 'Panda Land', 'Tokyo', 'Japan', '33333', 'pan@gmail', '3333333000', '2023/09/09');

COMMIT TRANSACTION;
