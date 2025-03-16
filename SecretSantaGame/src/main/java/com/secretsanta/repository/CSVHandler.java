package com.secretsanta.repository;

import com.secretsanta.model.Employee;
import com.opencsv.*;
import org.springframework.stereotype.Repository;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Repository
public class CSVHandler {
    public static List<Employee> readEmployees(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Employee(parts[0].trim(), parts[1].trim()))
                .collect(Collectors.toList());
    }

    public static Map<String, String> readLastYearAssignments(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath))
                .skip(1)
                .map(line -> line.split(","))
                .collect(Collectors.toMap(parts -> parts[1].trim(), parts -> parts[3].trim()));
    }

    public static void writeAssignments(String filePath, Map<Employee, Employee> assignments) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("Employee_Name,Employee_EmailID,Secret_Child_Name,Secret_Child_EmailID\n");
            for (Map.Entry<Employee, Employee> entry : assignments.entrySet()) {
                writer.write(entry.getKey().getName() + "," + entry.getKey().getEmail() + "," +
                             entry.getValue().getName() + "," + entry.getValue().getEmail() + "\n");
            }
        }
    }
}