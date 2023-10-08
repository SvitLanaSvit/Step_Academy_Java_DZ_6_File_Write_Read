package org.example.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        //Завдання 2:
        //Користувач з клавіатури вводить шлях до файлу. Програма повинна знайти довжину самого довгого рядка.
        //Після роботи програми на екран відображається отримане число і сам рядок.
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the path of the file: ");
        String filePath = scanner.next();

        Map<Integer, List<String>> map = new TreeMap<>(Collections.reverseOrder());
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                Integer lineLength = line.length();
                if (map.containsKey(lineLength)) {
                    List<String> existingList = map.get(lineLength);
                    existingList.add(line);
                } else {
                    List<String> newList = new ArrayList<>();
                    newList.add(line);
                    map.put(lineLength, newList);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the files: " + e.getMessage());
        }

        Optional<Map.Entry<Integer, List<String>>> firstElemOfMap = map.entrySet().stream().findFirst();
        if (firstElemOfMap.isPresent()) {
            var entry = firstElemOfMap.get();
            System.out.println(entry.getKey() + " " + entry.getValue());
        } else {
            System.out.println("Map is empty.");
        }
    }
}
