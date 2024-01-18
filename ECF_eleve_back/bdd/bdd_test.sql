USE ecf_18012024;

/* Afficher la liste des classes (sans les eleves). */

SELECT * FROM class;

/* Afficher le nombre de matière d'un élève. */

SELECT count(ti.subject_id) AS nb_cours, student_id FROM timetable ti
JOIN class cl on cl.class_id = ti.class_id
JOIN student st on st.class_id = cl.class_id
GROUP BY student_id;

/* Afficher la liste des notes d'un eleve (avec les détails). */

SELECT grade_student_value, grade_student_comment, subject_title, subject_coefficient, st.student_id FROM grade_student gs
JOIN subject sub on sub.subject_id = gs.subject_id
JOIN student st on st.student_id = gs.subject_id;

/* Aficher la moyenne d'un eleve. */

SELECT avg(grade_student_value), st.student_id FROM grade_student gs
JOIN student st ON st.student_id = gs.student_id
GROUP BY st.student_id;

SELECT sum(grade_student.grade_student_value * subject.subject_coefficient) / SUM(subject.subject_coefficient) as moyenne, student.student_id  FROM grade_student
JOIN subject on subject.subject_id = grade_student.subject_id
JOIN student on student.student_id = grade_student.student_id
GROUP BY student.student_id;

/* Afficher le nombre d'eleve d'un département. */

SELECT COUNT(student.student_id), department.department_name FROM student
JOIN class on class.class_id = student.class_id
JOIN department ON department.department_id = class.department_id
GROUP BY department_name;

/* Afficher tous les noms des eleves d'un niveau. */

SELECT student_firstname, student_lastname, class_level
FROM student JOIN class ON student.class_id = class.class_id;

/* Suppression d'un eleve, supprimera sa note mais pas sa classe. */
/* Suppression classe => supprime uniquement les éléves de cette classe. */
/* Suppression d'un departement => Supprime toutes les classes et tous les professeurs. */