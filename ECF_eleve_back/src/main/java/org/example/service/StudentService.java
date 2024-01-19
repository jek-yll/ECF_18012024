package org.example.service;

import org.example.entity.Classe;
import org.example.entity.Student;
import org.example.impl.ClassDAOImpl;
import org.example.impl.StudentDAOImpl;

import java.time.LocalDate;

public class StudentService implements IStudentService{

    StudentDAOImpl studentDAO;
    ClassDAOImpl classDAO;

    public StudentService() {
        this.studentDAO = new StudentDAOImpl();
        this.classDAO = new ClassDAOImpl();
    }

    @Override
    public boolean addStudent(String firstname, String lastname, String email, LocalDate dateBirth, Integer classId) {

        if (firstname.length() >= 3 && lastname.length() >= 3){
            Student student = new Student(firstname,lastname,email,dateBirth);
            Classe studentClass = classDAO.get(classId);
            student.setClassField(studentClass);

            studentDAO.create(student);
            return true;
        } else {
            System.out.println("Erreur lors de la saisi des information de l'étudiant");
            return false;
        }
    }
}
