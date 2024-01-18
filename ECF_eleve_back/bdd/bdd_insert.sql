INSERT INTO department (department_name) VALUES
('Computer Science'),
('Mathematics'),
('History');

INSERT INTO teacher (registration_nbr, teacher_firstname, teacher_lastname, teacher_date_birth, teacher_grade, department_id) VALUES
('T001', 'John', 'Doe', '1980-05-15', 10, 1),
('T002', 'Jane', 'Smith', '1985-08-22', 8, 2),
('T003', 'Robert', 'Johnson', '1975-02-10', 12, 3);

UPDATE department SET department_manager_id = 1 WHERE department_id = 1;
UPDATE department SET department_manager_id = 2 WHERE department_id = 3;
UPDATE department SET department_manager_id = 3 WHERE department_id = 2;

INSERT INTO subject (subject_title, subject_description, subject_duration, subject_coefficient) VALUES
('Introduction to Programming', 'Basic programming concepts and techniques', 45, 3),
('Algebra', 'Fundamental algebraic concepts', 60, 4),
('World History', 'Overview of world historical events', 75, 5),
('Chemistry', 'Basic principles of chemistry', 50, 3),
('Literature', 'Study of classic literature', 40, 2),
('Physical Education', 'Physical fitness and health', 30, 1);

INSERT INTO class (class_name, class_level, department_id) VALUES
('CS101', 'Freshman', 1),
('MATH201', 'Sophomore', 2),
('HIST301', 'Junior', 3);

UPDATE teacher SET head_teacher_class_id = 1 WHERE teacher_id = 1;
UPDATE teacher SET head_teacher_class_id = 2 WHERE teacher_id = 2;
UPDATE teacher SET head_teacher_class_id = 3 WHERE teacher_id = 3;

INSERT INTO student (student_firstname, student_lastname, student_email, student_date_birth, class_id) VALUES
('Alice', 'Johnson', 'alice@gmail.com', '2000-03-08', 1),
('Bob', 'Smith', 'bob@gmail.com', '2001-07-15', 2),
('Charlie', 'Williams', 'charlie@gmail.com', '1999-01-22', 3);

INSERT INTO grade_student (student_id, grade_student_value, grade_student_comment, subject_id) VALUES
(1, 02, 'Good performance', 1),
(1, 15, 'Excellent work', 2),
(1, 13, 'atisfactory progress', 3),
(1, 12, 'Good performance', 4),
(2, 18, 'Excellent work', 2),
(3, 12, 'Satisfactory progress', 3);

INSERT INTO teach (teacher_id, subject_id) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT INTO timetable (teacher_id, subject_id, class_id, timetable_hour, timetable_day) VALUES
(1, 1, 1, '09:00:00', 'Monday'),
(2, 2, 2, '10:30:00', 'Wednesday'),
(3, 3, 3, '13:00:00', 'Friday');
