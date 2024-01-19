package org.example.service;

import java.time.LocalDate;

public interface IStudentService {

    public abstract boolean addStudent(String firstname, String lastname, String email, LocalDate dateBirth, Integer classId);

}
