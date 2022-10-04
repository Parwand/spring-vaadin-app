package com.parwand.application.applicationservice.repository;

import com.parwand.application.domain.model.Employee;

import java.util.List;

public interface EmployeeRepository {

    void save(Employee employee);
    List<Employee> findAll();
}
