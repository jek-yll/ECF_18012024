package org.example.controller;

import org.example.service.DepartmentService;
import org.example.service.TeacherService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppConsole {

    private Scanner sc;
    private String choix;

    private DepartmentService _departmentService;
    private TeacherService _teacherService;

    public AppConsole(DepartmentService departmentService, TeacherService teacherService){
        sc = new Scanner(System.in);
        _departmentService = departmentService;
        _teacherService = teacherService;
    }

    public void start(){

        do {
            menu();
            choix = sc.nextLine();

            switch (choix){
                case "1":
                    createDepartment();
                    break;
                case "2":
                    createTeacher();
                    break;
                case "3":
                    createStudent();
                    break;
            }

        } while (!choix.equals("0"));

    }

    public void menu(){
        System.out.println("CREATION");
        System.out.println("1- Creation d'un département");
        System.out.println("2- Creation d'un enseignant");
        System.out.println("3- Creation d'un etudiant");
        System.out.println("4- Creation d'une matière");
        System.out.println("5- Ajout d'une note");
        System.out.println("6- Creation d'une classe");

    }

    public void createDepartment(){
        System.out.println("########## Nouveau département ##########");
        System.out.println("Saisir le nom du nouveau departement");
        String name = sc.nextLine();

        System.out.println("Saisir l'identifiant de l'enseignant référent");
        Integer teacherManagerId = sc.nextInt();sc.nextLine();

        if (_departmentService.addDepartment(name, teacherManagerId)){
            System.out.println("Département crée avec succès");
        } else {
            System.out.println("Echec lors de la création du département");
        }
    }

    public void createTeacher(){
        System.out.println("########## Nouveau professeur ##########");
        System.out.println("Saisir le matricule du professeur");
        String registration = sc.nextLine();

        System.out.println("Saisir le prénom du professeur");
        String firstname = sc.nextLine();

        System.out.println("Saisir le nom du professeur");
        String lastname = sc.nextLine();

        System.out.println("Saisir la date de naissance du professeur (dd-MM-yyyy)");
        String dateInput = sc.nextLine();
        LocalDate dateBirth = LocalDate.parse(dateInput, DateTimeFormatter.ofPattern("dd-MM-yyyy"));

        System.out.println("Saisir le grade de l'enseignant");
        Integer grade = sc.nextInt();

        if (_teacherService.addTeacher(
                registration,
                firstname,
                lastname,
                dateBirth,
                grade
        )){
            System.out.println("Enseignant ajouté avec succès");
        } else {
            System.out.println("Echec lors de l'enregistrement de l'enseignant");
        }
    }

    public void createStudent(){

    }

}
