package lesson_6;

import java.util.*;

public class PhoneBookDemo {
    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        System.out.println("-----Добавление записей в справочник-----\n");

        phoneBook.add("Иванов", "+7-111-111-11-11");
        phoneBook.add("Петров", "+7-222-222-22-22");
        phoneBook.add("Сидорова", "+7-333-333-33-33");
        phoneBook.add("Иванов", "+7-444-444-44-44");
        phoneBook.add("Иванов", "+7-555-555-55-55");
        phoneBook.add("Козлов", "+7-666-666-66-66");
        phoneBook.add("Петров", "+7-777-777-77-77");

        phoneBook.printAll();

        System.out.println("\n-----Поиск номера телефона по фамилии-----\n");

        System.out.print("Телефоны Иванова: ");
        System.out.println(phoneBook.get("Иванов"));

        System.out.print("Телефоны Петрова: ");
        System.out.println(phoneBook.get("Петров"));

        System.out.print("Телефоны Козлова: ");
        System.out.println(phoneBook.get("Козлов"));

        System.out.print("Телефоны Смирнова: "); //такой фамилии нет в записях
        System.out.println(phoneBook.get("Смирнов"));
    }
}
