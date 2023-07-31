package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Ilya Galaktionov");
        student.setGroup(15);
        student.setAdmission(new Date());

        System.out.println(student.getFullName() + " joined the group № "
                            + student.getGroup() + " " + student.getAdmission());
    }
}
