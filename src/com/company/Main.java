package com.company;

import com.company.database.StudentDatabase;
import com.company.dto.Student;
import com.company.utils.ConsoleUtils;

public class Main {



    public static void main(String[] args) {
        StudentDatabase studentDatabase = new StudentDatabase();

        studentDatabase.save(readStudent());

        studentDatabase.printStudents();
        studentDatabase.save(readStudent());

        studentDatabase.printStudents();
        studentDatabase.save(readStudent());
        studentDatabase.printStudents();
        System.out.println();
        System.out.println();
        Student student = new Student(3, "john doe", "Drawing", "draw-1", 1);
        studentDatabase.saveOrUpdate(student);

        studentDatabase.printStudents();
    }

    public static Student readStudent() {
        ConsoleUtils.print("Enter full name:");
        String name = ConsoleUtils.read();

        ConsoleUtils.print("Enter group name:");
        String group = ConsoleUtils.read();


        ConsoleUtils.print("Enter major:");
        String major = ConsoleUtils.read();

        ConsoleUtils.print("Year of education");
        Integer yearOfEducation = ConsoleUtils.readDigit();

        return new Student(null, name, major, group, yearOfEducation);
    }


}
