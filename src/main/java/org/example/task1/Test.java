package org.example.task1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Завдання 1:
        //Користувач вводить з клавіатури шляхи до двох файлів. Програма повинна перевірити чи збігаються їх
        //рядки. Якщо ні, то вивести рядки, що не збігаються із кожного з файлів.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the first file: ");
        String filePath1 = scanner.next();
        System.out.print("Enter the path of the second file: ");
        String filePath2 = scanner.next();

        List<String> lines1 = new ArrayList<>();
        List<String> lines2 = new ArrayList<>();

        try(BufferedReader reader1 = new BufferedReader(new FileReader(filePath1));
        BufferedReader reader2 = new BufferedReader(new FileReader(filePath2))){
            String line1;
            String line2;

            while((line1 = reader1.readLine()) != null){
                lines1.add(line1);
            }

            while((line2 = reader2.readLine()) != null){
                lines2.add(line2);
            }

        } catch (IOException e) {
            System.err.println("Error reading the files: " + e.getMessage());
        }

        int lines = Math.abs(lines1.size() - lines2.size());
        if(lines1.size() != lines2.size()){
            for (int i = 0; i < lines; i++) {
                if(lines1.size() < lines2.size()){
                    lines1.add("no line");
                }
                else{
                    lines2.add("no line");
                }
            }
        }

        List<String> nonMatchingElements = new ArrayList<>();
        for (int i = 0; i < lines1.size(); i++) {
            if(!lines1.get(i).equals(lines2.get(i))){
                nonMatchingElements.add("lines1: " + lines1.get(i) + ", lines2: " + lines2.get(i));
            }
        }

        for (var line : nonMatchingElements) {
            System.out.println(line);
        }
    }
}
