package com.example.employeeapi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class EmployeeService {

    private final List<Employee> employees = new ArrayList<>();
    private final AtomicInteger idCounter = new AtomicInteger();

    public EmployeeService() {
        // Initialize sample data
        employees.add(new Employee(idCounter.incrementAndGet(), "John Doe", "Engineering", "john.doe@example.com"));
        employees.add(new Employee(idCounter.incrementAndGet(), "Jane Smith", "Marketing", "jane.smith@example.com"));
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees);
    }

    public Optional<Employee> getEmployeeById(int id) {
        return employees.stream().filter(employee -> employee.getId() == id).findFirst();
    }

    public Employee addEmployee(String name, String department, String email) {
        int newId = idCounter.incrementAndGet();
        Employee newEmployee = new Employee(newId, name, department, email);
        employees.add(newEmployee);
        return newEmployee;
    }
}