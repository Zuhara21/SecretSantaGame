package com.secretsanta.service;

import com.secretsanta.model.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

class SecretSantaServiceTest {

    @Test
    void testValidAssignments() {
        List<Employee> employees = List.of(
                new Employee("Alice", "alice@example.com"),
                new Employee("Bob", "bob@example.com"),
                new Employee("Charlie", "charlie@example.com")
        );
        Map<String, String> lastYearAssignments = new HashMap<>();

        SecretSantaService service = new SecretSantaService(employees, lastYearAssignments);
        Map<Employee, Employee> assignments = service.assignSecretSanta();

        assertEquals(employees.size(), assignments.size());
        for (Employee giver : employees) {
            assertNotNull(assignments.get(giver));
            assertNotEquals(giver, assignments.get(giver));
        }
    }
}