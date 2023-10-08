package org.example.task5;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CorporationManagement {
    private static final String DATA_FILE = "corporation_data.txt";
    private static List<Employee> employees = new ArrayList<>();

    public static void getMenu() {
        loadDataFromFile();

        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Enter your choice: ");
        do {
            System.out.println("\nCorporation Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Edit Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search by Last Name");
            System.out.println("5. Display All Employees");
            System.out.println("6. Save Data to File");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    addEmployee(scanner);
                }
                case 2 -> {
                    editEmployee(scanner);
                }
                case 3 -> {
                    removeEmployee(scanner);
                }
                case 4 -> {
                    searchByLastName(scanner);
                }
                case 5 -> {
                    displayAllEmployees();
                }
                case 6 -> {
                    saveDataToFile();
                }
                case 7 -> {
                    saveDataToFile();
                    System.out.println("Exiting the program...");
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter Last Name: ");
        String lastName = scanner.next();

        System.out.print("Enter First Name: ");
        String firstName = scanner.next();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();
        int count = 0;
        Employee newEmployee = new Employee(lastName, firstName, age);
        for(var employee : employees){
            if(employee.getLastName().equalsIgnoreCase(lastName) && employee.getFirstName().equalsIgnoreCase(firstName)){
                count++;
            }
        }

        if (count == 0) {
            employees.add(newEmployee);
            System.out.println("Employee added successfully.");
        } else {
            System.out.println("Employee exists already in the list of employees.");
        }
    }

    private static void editEmployee(Scanner scanner) {
        System.out.print("Enter the Last Name of the employee to edit: ");
        String lastName = scanner.next();

        for (var employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("Enter new information for the employee:");

                System.out.print("New Last Name: ");
                String newLastName = scanner.next();
                employee.setLastName(newLastName);

                System.out.print("New First Name: ");
                String newFirstName = scanner.next();
                employee.setFirstName(newFirstName);

                System.out.print("New Age: ");
                int newAge = scanner.nextInt();
                employee.setAge(newAge);

                System.out.println("Employee information updated successfully.");
                return;
            }
        }
    }

    private static void removeEmployee(Scanner scanner) {
        System.out.print("Enter the Last Name of the employee to remove: ");
        String lastName = scanner.next();

        for (var employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                employees.remove(employee);
                System.out.println("Employee removed successfully.");
                return;
            }
        }

        System.out.println("Employee not found with Last Name: " + lastName);
    }

    private static void searchByLastName(Scanner scanner) {
        System.out.print("Enter the Last Name of the employee to search: ");
        String lastName = scanner.next();

        displayHeaderTable();
        for (var employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println(employee);
            }
        }
    }

    private static void displayAllEmployees() {
        displayHeaderTable();
        for (var employee : employees) {
            System.out.println(employee);
        }
    }

    private static void displayHeaderTable() {
        String formatter = "%8s                |%11s                    |%4s";
        System.out.printf(String.format(formatter, "FIRSTNAME", "LASTNAME", "AGE"));
        System.out.println();
        System.out.println("---------------------------------------------------------------");
    }

    private static void saveDataToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_FILE))) {
            oos.writeObject(employees);
            System.out.println("Data saved to file: " + DATA_FILE);
        } catch (IOException e) {
            System.err.println("Error saving data to file: " + e.getMessage());
        }
    }

    private static void loadDataFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(DATA_FILE))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Data loaded from file: " + DATA_FILE);

        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading data from file: " + e.getMessage());
        }
    }
}