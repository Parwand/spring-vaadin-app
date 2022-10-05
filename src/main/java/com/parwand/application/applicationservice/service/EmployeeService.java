package com.parwand.application.applicationservice.service;

import com.parwand.application.applicationservice.repository.EmployeeRepository;
import com.parwand.application.domain.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(String filterText) {
        if (filterText == null || filterText.isEmpty()) {
            return employeeRepository.findAll();
        } else {
            return employeeRepository.findEmployeeByName(filterText);
        }
    }

}
