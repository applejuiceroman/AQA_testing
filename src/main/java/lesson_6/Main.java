package lesson_6;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иванов Иван", "Группа А", 1,
                Arrays.asList(5, 4, 5, 4, 5)));
        students.add(new Student("Петров Петр", "Группа А", 1,
                Arrays.asList(3, 2, 3, 2, 2))); // Средний балл < 3
        students.add(new Student("Федорова Федора ", "Группа Б", 2,
                Arrays.asList(5, 5, 4, 5, 5)));
        students.add(new Student("Дмитриев Дмитрий", "Группа Б", 2,
                Arrays.asList(2, 2, 3, 2, 2))); // Средний балл < 3
        students.add(new Student("Владимирова Влада", "Группа Б", 3,
                Arrays.asList(4, 4, 4, 4, 3)));

        System.out.println("\n-----Все студенты-----\n");
        for (Student s : students) {
            System.out.println(s);
        }

        StudentManagement.printStudents(students, 1);
        StudentManagement.printStudents(students, 2);
        StudentManagement.printStudents(students, 3);

        System.out.println("==============================");

        System.out.println("\n-----Удаление студентов со средним баллов ниже 3-----\n");
        StudentManagement.removePoorStudents(students);

        System.out.println("\n==============================");

        System.out.println("\n-----Оставшиеся студенты-----\n");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\n==============================");

        System.out.println("\n-----Переход студентов на следующий курс-----\n");
        StudentManagement.promoteStudents(students);

        System.out.println("\n==============================");

        System.out.println("\n-----Студенты после перехода-----\n");
        for (Student s : students) {
            System.out.println(s);
        }

        System.out.println("\n==============================");

        StudentManagement.printStudents(students, 2);
        StudentManagement.printStudents(students, 3);
        StudentManagement.printStudents(students, 4);
    }
}
