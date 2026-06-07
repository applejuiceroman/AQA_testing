package lesson_6;

import java.util.*;

public class StudentManagement {

    public static void removePoorStudents(Collection<Student> students) {
        Iterator<Student> iterator = students.iterator();
        int removedCount = 0;

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageGrade() < 3.0) {
                System.out.println("Удален студент: " + student.getName() +
                        " (средний балл: " + student.getAverageGrade() + ")");
                iterator.remove();
                removedCount++;
            }
        }
    }

    public static void promoteStudents(Collection<Student> students) {
        int promotedCount = 0;

        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                int oldCourse = student.getCourse();
                student.setCourse(oldCourse + 1);
                System.out.println("Студент " + student.getName() +
                        " переведен с " + oldCourse + " на " + (oldCourse + 1) + "курс");
                promotedCount++;
            } else {
                System.out.println("Студент " + student.getName() +
                        " не переведен на следующий курс, его средний балл: " + student.getAverageGrade());
            }
        }

        System.out.println("Всего переведено студентов: " + promotedCount);
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("\n-----Студенты на " + course + " курсе-----");

        boolean found = false;
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println("  - " + student.getName() +
                        " (группа: " + student.getGroup() +
                        ", средний балл: " + student.getAverageGrade() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("  На курсе " + course + " нет студентов");
        }
        System.out.println();
    }
}
