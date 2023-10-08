package org.example.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        //Завдання 3:
        //В файлі на різних рядках находяться елементи масивів цілих чисел. Перший рядок містить елементи
        //першого масиву, другий — другого і т. д. Наприклад:
        //1 23 43 9
        //6 33 77 88
        //Необхідно завантажити дані із файлу в різні масиви, вивести кожен масив на екран, показати максимум і
        //мінімум в кожному масиві, суму елементів кожного масиву, а також загальну суму всіх масивів.
        String filePath ="file_massive.txt";

        int sumAllArrays = 0;
        int countLines = 1;
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                String[] strArray = line.split(" ");
                Integer[] intArray = new Integer[strArray.length];

                System.out.print("Array" + countLines + ": ");
                for (int i = 0; i < strArray.length; i++) {
                    intArray[i] = Integer.parseInt(strArray[i]);
                    System.out.print(intArray[i] + " ");
                }

                System.out.println();
                int sumArray = getSumArr(intArray);
                System.out.println("Max" + countLines + ": " + findMax(intArray));
                System.out.println("Min" + countLines + ": " + findMin(intArray));
                System.out.println("Sum" + countLines + ": " + sumArray);
                sumAllArrays += sumArray;
                countLines++;
                System.out.println("------------------------------");
            }
        } catch (IOException e) {
            System.err.println("Error reading the files: " + e.getMessage());
        }

        System.out.println("Sum of all arrays from file: " + sumAllArrays);
    }

    private static int findMax(Integer[] arr){
        int max = arr[0];
        for (var elem : arr){
            if(elem > max){
                max = elem;
            }
        }
        return max;
    }

    private static int findMin(Integer[] arr){
        int min = arr[0];
        for (var elem : arr){
            if(elem < min){
                min = elem;
            }
        }
        return min;
    }

    private static int getSumArr(Integer[] arr){
        int sum = 0;
        for (var elem : arr){
            sum += elem;
        }
        return sum;
    }
}
