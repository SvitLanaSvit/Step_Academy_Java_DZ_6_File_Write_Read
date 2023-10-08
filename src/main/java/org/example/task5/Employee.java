package org.example.task5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
public class Employee implements Serializable {
    private String lastName;
    private String firstName;
    private int age;

    @Override
    public String toString() {
        String formatter = "%-25s| %-30s| %4s";
        return String.format(formatter, firstName, lastName, age);
    }
}
