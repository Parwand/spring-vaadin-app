package com.parwand.application.views.employee;

import com.parwand.application.applicationservice.service.EmployeeService;
import com.parwand.application.domain.model.Employee;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/employee")
public class EmployeeView extends VerticalLayout {
    private final Grid<Employee> grid = new Grid<>(Employee.class, true);
    private EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public EmployeeView() {
        grid.addColumn(Employee::getFirstname).setHeader("First Name");
        grid.addColumn(Employee::getLastname).setHeader("First Name");
        grid.addColumn(Employee::getEmail).setHeader("First Name");

        grid.setItems(employeeService.getAllEmployees());
    }
}
