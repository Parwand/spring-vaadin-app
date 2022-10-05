package com.parwand.application.applicationservice.repository;

import com.parwand.application.domain.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmployeeRepository {

    void save(Employee employee);
    List<Employee> findAll();

    List<Employee> findEmployeeByName(String filterText);

}
