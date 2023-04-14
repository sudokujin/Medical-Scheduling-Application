-- STEP 3
BEGIN TRANSACTION;

-- users
INSERT INTO users (username,password_hash,role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username,password_hash,role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO users (username,password_hash,role) 
VALUES ('qing','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

INSERT INTO users (username,password_hash,role) 
VALUES ('Jordan','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

INSERT INTO users (username,password_hash,role) 
VALUES ('Salaj','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

INSERT INTO users (username,password_hash,role) 
VALUES ('DomTheFrontEndPro','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

INSERT INTO users (username,password_hash,role) 
VALUES ('JordanTheHappyBoi','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

INSERT INTO users (username,password_hash,role) 
VALUES ('YoungjinLovesCake','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_DOCTOR');

--- doctors
INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(3, 'Qing','Jin','Dermontology',3, 3000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(4, 'Jordan','Bruntz','Bones',4, 4000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(6, 'Dom','Lorenz','Heart Surgeon', 5, 6000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(5, 'Salaj','Choudhary','Brain doctor', 6, 8000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(8, 'Youngjin','Kwon','Psychologist', 7, 9000);


-- patients
INSERT INTO patient(
	first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES ('Pan', 'Bam', 'Panda Land', 'Tokyo', 'Japan', '33333', 'pan@gmail', '3333333000', '2023/09/09');
	
INSERT INTO public.review(
	review_title, review_body, review_rating, review_date, doctor_id, patient_id)
	VALUES ('bad doctor', 'really bad', 1, '2023/09/08', 3, 1);
	
INSERT INTO public.appointment(
	patient_id, doctor_id, appointment_duration, description, appointment_date, appointment_time)
	VALUES (1, 3, 30, 'brain fog', '2023/08/08', '8:00:00');
	
COMMIT TRANSACTION;
