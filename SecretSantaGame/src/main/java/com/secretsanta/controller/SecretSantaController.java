package com.secretsanta.controller;

import com.secretsanta.model.Employee;
import com.secretsanta.service.SecretSantaService;
import com.secretsanta.repository.CSVHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/secretsanta")
public class SecretSantaController {
    private final SecretSantaService secretSantaService;

    public SecretSantaController(SecretSantaService secretSantaService) {
        this.secretSantaService = secretSantaService;
    }

    @GetMapping("/assign")
    public String assignSecretSanta() {
        try {
            List<Employee> employees = CSVHandler.readEmployees("employees.csv");
            Map<String, String> lastYearAssignments = CSVHandler.readLastYearAssignments("last_year.csv");
            
            SecretSantaService santaService = new SecretSantaService(employees, lastYearAssignments);
            Map<Employee, Employee> assignments = santaService.assignSecretSanta();
            
            CSVHandler.writeAssignments("secret_santa_output.csv", assignments);
            return "Secret Santa assignments saved successfully.";
        } catch (IOException e) {
            return "Error: " + e.getMessage();
        }
    }
}