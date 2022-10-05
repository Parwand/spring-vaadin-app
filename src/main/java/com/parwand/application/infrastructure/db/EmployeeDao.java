package com.parwand.application.infrastructure.db;

import com.parwand.application.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeDao extends JpaRepository<Employee, Long> {
    List<Employee> findAll();

    @Query("SELECT e FROM Employee e WHERE e.firstname like %:name% or e.lastname like %:name%")
    List<Employee> findByName(@Param("name") String filterText);
}
