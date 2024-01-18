DROP DATABASE ecf_18012024;
CREATE DATABASE IF NOT EXISTS ecf_18012024;
USE ecf_18012024;

CREATE TABLE IF NOT EXISTS department(
   department_id INT NOT NULL AUTO_INCREMENT,
   department_name VARCHAR(50),
   department_manager_id INT REFERENCES teacher(teacher_id),
   PRIMARY KEY(department_id)
);

CREATE TABLE IF NOT EXISTS class(
   class_id INT NOT NULL AUTO_INCREMENT,
   class_name VARCHAR(50),
   class_level VARCHAR(50),
   department_id INT NOT NULL,
   PRIMARY KEY(class_id),
   FOREIGN KEY(department_id) REFERENCES department(department_id)
);

CREATE TABLE IF NOT EXISTS teacher(
   teacher_id INT NOT NULL AUTO_INCREMENT,
   registration_nbr VARCHAR(50),
   teacher_firstname VARCHAR(50) NOT NULL,
   teacher_lastname VARCHAR(50) NOT NULL,
   teacher_date_birth DATE,
   teacher_grade INT,
   head_teacher_class_id INT UNIQUE,
   department_id INT,
   PRIMARY KEY(teacher_id),
   FOREIGN KEY(department_id) REFERENCES department(department_id),
   FOREIGN KEY(head_teacher_class_id) REFERENCES class(class_id)
);

CREATE TABLE IF NOT EXISTS subject(
   subject_id INT NOT NULL AUTO_INCREMENT,
   subject_title VARCHAR(50),
   subject_description VARCHAR(500),
   subject_duration INT,
   subject_coefficient INT,
   PRIMARY KEY(subject_id)
);

CREATE TABLE IF NOT EXISTS student(
   student_id INT NOT NULL AUTO_INCREMENT,
   student_firstname VARCHAR(50) NOT NULL,
   student_lastname VARCHAR(50) NOT NULL,
   student_email VARCHAR(255) CHECK (student_email LIKE '%@gmail.com'),
   student_date_birth DATE,
   class_id INT NOT NULL,
   PRIMARY KEY(student_id),
   FOREIGN KEY(class_id) REFERENCES class(class_id)
);

CREATE TABLE IF NOT EXISTS grade_student(
   student_id INT NOT NULL,
   grade_student_value INT CHECK (grade_student_value >= 0 AND grade_student_value <= 20),
   grade_student_comment VARCHAR(500),
   subject_id INT NOT NULL,
   PRIMARY KEY(student_id, subject_id),
   FOREIGN KEY(student_id) REFERENCES student(student_id),
   FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE IF NOT EXISTS teach(
   teacher_id INT,
   subject_id INT,
   PRIMARY KEY(teacher_id, subject_id),
   FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id),
   FOREIGN KEY(subject_id) REFERENCES subject(subject_id)
);

CREATE TABLE IF NOT EXISTS timetable(
   teacher_id INT,
   subject_id INT,
   class_id INT,
   timetable_hour TIME,
   timetable_day VARCHAR(50),
   PRIMARY KEY(teacher_id, subject_id, class_id),
   FOREIGN KEY(teacher_id) REFERENCES teacher(teacher_id),
   FOREIGN KEY(subject_id) REFERENCES subject(subject_id),
   FOREIGN KEY(class_id) REFERENCES class(class_id)
);