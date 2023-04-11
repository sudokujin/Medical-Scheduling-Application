INSERT INTO users 
(user_id, username,password_hash, role) 
VALUES(3, 'qj','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_DOCTOR');

INSERT INTO users 
(user_id, username,password_hash, role) 
VALUES(4, 'jb','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_DOCTOR');

INSERT INTO users 
(user_id, username,password_hash, role) 
VALUES(5, 'dl','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_DOCTOR');

INSERT INTO users 
(user_id, username,password_hash, role) 
VALUES(6, 'sc','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_DOCTOR');

INSERT INTO users 
(user_id, username,password_hash, role) 
VALUES(7, 'yk','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC', 'ROLE_DOCTOR');


INSERT INTO doctor 
(user_id, first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) 
VALUES(3, 'Qing','Jin','Dermontology',3, 3000,'2023/10/08' , 8, 5);
INSERT INTO doctor 
(user_id, first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) 
VALUES(4, 'Jordan','Bruntz','Bones',4, 4000, '2023/10/08', 9, 4);
INSERT INTO doctor 
(user_id, first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) 
VALUES(5, 'Dom','Lorenz','Heart Surgeon', 5, 6000, '2023/10/10', 10, 10);
INSERT INTO doctor 
(user_id, first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) 
VALUES(6, 'Salaj','Choudhary','Brain doctor', 6, 8000, '2023/10/09', 8, 5);
INSERT INTO doctor 
(user_id, first_name,last_name,specialty,suite_number, costperhour, appt_date, start_time, end_time) 
VALUES(7, 'Youngjin','Kwon','Psychologist', 7, 9000, '2023/10/09', 8, 5);