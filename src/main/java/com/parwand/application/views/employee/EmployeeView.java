package com.parwand.application.views.employee;

import com.parwand.application.applicationservice.service.EmployeeService;
import com.parwand.application.domain.model.Employee;
import com.parwand.application.views.main.MainLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "/employee", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout {
    private final Grid<Employee> grid = new Grid<>(Employee.class, false);
    private final EmployeeService employeeService;

    public EmployeeView(EmployeeService employeeService) {
        this.employeeService = employeeService;
        grid.addColumn(Employee::getFirstname).setHeader("First Name");
        grid.addColumn(Employee::getLastname).setHeader("Last Name");
        grid.addColumn(Employee::getEmail).setHeader("Email");
        grid.setItems(employeeService.getAllEmployees());
        add(grid);
    }
}
