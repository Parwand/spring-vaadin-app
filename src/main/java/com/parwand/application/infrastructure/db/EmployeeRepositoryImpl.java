package com.parwand.application.infrastructure.db;

import com.parwand.application.applicationservice.repository.EmployeeRepository;
import com.parwand.application.domain.model.Employee;

import java.util.List;

public class EmployeeRepositoryImpl implements EmployeeRepository {

    private final EmployeeDao employeeDao;

    public EmployeeRepositoryImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public void save(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
