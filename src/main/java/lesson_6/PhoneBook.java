package lesson_6;

import java.util.*;

public class PhoneBook {
    private Map<String, List<String>> phoneBook;

    public PhoneBook() {
        phoneBook = new HashMap<>();
    }

    public void add(String lastName, String phoneNumber) {
        if (!phoneBook.containsKey(lastName)) {
            phoneBook.put(lastName, new ArrayList<>());
        }
        phoneBook.get(lastName).add(phoneNumber);
        System.out.println("Добавлена запись: фамилия - " + lastName + ", номер телефона - " + phoneNumber);
    }
    public List<String> get(String lastName) {
        return phoneBook.getOrDefault(lastName, new ArrayList<>());
    }

    public void printAll() {
        if (phoneBook.isEmpty()) {
            System.out.println("Телефонный справочник пуст");
            return;
        }

        System.out.println("\n-----Телефонный справочник-----\n");
        for (Map.Entry<String, List<String>> entry : phoneBook.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println("\n=============================");
    }
}
