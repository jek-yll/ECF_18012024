package org.example.service;

import java.time.LocalDate;

public interface ITeacherService {

    public abstract boolean addTeacher (String registrationNbr, String firstname, String lastname, LocalDate dateBirth, Integer grade);

}
