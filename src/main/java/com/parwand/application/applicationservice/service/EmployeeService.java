package com.parwand.application.applicationservice.service;

import com.parwand.application.applicationservice.repository.EmployeeRepository;
import com.parwand.application.domain.model.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}
