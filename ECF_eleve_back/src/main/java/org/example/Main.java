package org.example;

import org.example.controller.AppConsole;
import org.example.service.DepartmentService;
import org.example.service.TeacherService;

public class Main {

    public static void main(String[] args) {
        new AppConsole(
                new DepartmentService(),
                new TeacherService()
        ).start();
    }
}
