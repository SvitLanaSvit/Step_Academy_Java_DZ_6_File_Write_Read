package org.example.task4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 4:
        //Користувач з клавіатури вводить шлях до файлу і масив цілих чисел. Необхідно зберегти вихідний масив
        //в першому рядку файлу, парні значення із масиву в другому рядку файлі, непарні в третьому, обернений
        //масив в четвертому.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            for (var num : array) {
                writer.write(num + " ");
            }

            writer.newLine();
            for (var num : array) {
                if(num % 2 == 0){
                    writer.write(num + " ");
                }
            }

            writer.newLine();
            for (var num : array) {
                if(num % 2 != 0){
                    writer.write(num + " ");
                }
            }

            writer.newLine();
            for (int i = n - 1; i >= 0 ; i--) {
                writer.write(array[i] + " ");
            }
        } catch (IOException e) {
            System.err.println("Error reading the files: " + e.getMessage());
        }

        System.out.println("Arrays saved to the file.");
    }
}
