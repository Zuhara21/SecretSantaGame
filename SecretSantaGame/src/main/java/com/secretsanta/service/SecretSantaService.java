package com.secretsanta.service;

import com.secretsanta.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecretSantaService {
    private final List<Employee> employees;
    private final Map<String, String> lastYearAssignments;

    public SecretSantaService(List<Employee> employees, Map<String, String> lastYearAssignments) {
        this.employees = employees;
        this.lastYearAssignments = lastYearAssignments;
    }

    public Map<Employee, Employee> assignSecretSanta() {
        List<Employee> availableChildren = new ArrayList<>(employees);
        Collections.shuffle(availableChildren);
        
        Map<Employee, Employee> assignments = new HashMap<>();
        for (Employee giver : employees) {
            Employee receiver = findValidReceiver(giver, availableChildren);
            if (receiver == null) {
                throw new RuntimeException("Valid Secret Santa assignment not possible");
            }
            assignments.put(giver, receiver);
            availableChildren.remove(receiver);
        }
        return assignments;
    }

    private Employee findValidReceiver(Employee giver, List<Employee> availableChildren) {
        for (Employee receiver : availableChildren) {
            if (!giver.getEmail().equals(receiver.getEmail()) &&
                !lastYearAssignments.getOrDefault(giver.getEmail(), "").equals(receiver.getEmail())) {
                return receiver;
            }
        }
        return null;
    }
}