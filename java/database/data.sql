-- STEP 3
BEGIN TRANSACTION;

-- user/admin
INSERT INTO users (username,password_hash,role) 
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (username,password_hash,role) 
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

-------------------------------------------------------------------------------------------------------------------
-- users/doctor RUN THIS FIRST
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

-- doctors CHANGE USER_ID ACCODRINGLY 
INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(__, 'Qing','Jin','Dermontology',3, 3000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(__, 'Jordan','Bruntz','Bones',4, 4000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(__, 'Dom','Lorenz','Heart Surgeon', 5, 6000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(__, 'Salaj','Choudhary','Brain doctor', 6, 8000);

INSERT INTO doctor
(user_id, first_name,last_name,specialty,suite_number, costperhour)
VALUES(__, 'Youngjin','Kwon','Psychologist', 7, 9000);
-------------------------------------------------------------------------------------------------------

-- patient/user RUN THIS FIRST
INSERT INTO users (username,password_hash,role) 
VALUES ('Anthony','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT');

INSERT INTO users (username,password_hash,role) 
VALUES ('Max','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT');

INSERT INTO users (username,password_hash,role) 
VALUES ('Jordan Junior', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT');

INSERT INTO users (username,password_hash,role) 
VALUES ('Little Qing', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT');

INSERT INTO users (username,password_hash,role) 
VALUES ('David', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PATIENT');

-- patients CHANGE USER_ID ACCODRINGLY 

INSERT INTO patient(
	user_id, first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES (__, 'Anthony', 'Orlando', 'Anthony Land', 'Philly', 'Japan', '33333', 'ann@gmail', '3333333000', '2023/09/12');

INSERT INTO patient(
	user_id, first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES (__, 'Max', 'Orlando', 'Max Land', 'Tokyo', 'Japan', '33333', 'pan@gmail', '3333333000', '2023/09/09');
INSERT INTO patient(
	user_id, first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES (__, 'Jordan', 'Orlando', 'Jordan Land', 'Tokyo', 'Japan', '3333999', 'pan@gmail', '3333333000', '2023/09/08');
	
INSERT INTO patient(
	user_id, first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES (__, 'Qing', 'Orlando', 'Panda Land', 'Tokyo', 'Japan', '3334477', 'pan@gmail', '3333333000', '2023/09/10');
		
INSERT INTO patient(
	user_id, first_name, last_name, address, city, states, zipcode, email_address, patient_number, birthdate)
	VALUES (__, 'David', 'Orlando', 'David Land', 'Tokyo', 'Japan', '33333', 'pan@gmail', '3333333000', '2023/09/11');	
----------------------------------------------------------------------------------------------------------------------------
-- review
INSERT INTO review(
	review_title, review_body, review_rating, review_date, doctor_id, patient_id)
	VALUES ('Qing is the BEST doctor ever!', 'I LOVE HER!!!', 10, '2023/09/08', __, __);
	
-- appointment	
INSERT INTO appointment(
	patient_id, doctor_id, appointment_duration, description, appointment_date, appointment_time)
	VALUES (__, __, __, 'brain fog', '2023/08/08', '8:00:00');
	
COMMIT TRANSACTION;
