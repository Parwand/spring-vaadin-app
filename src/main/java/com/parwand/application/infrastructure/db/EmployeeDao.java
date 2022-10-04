package com.parwand.application.infrastructure.db;

import com.parwand.application.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    List<Employee> findAll();
}
