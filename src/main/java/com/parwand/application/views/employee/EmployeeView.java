package com.parwand.application.views.employee;

import com.parwand.application.applicationservice.service.EmployeeService;
import com.parwand.application.domain.model.Employee;
import com.parwand.application.views.main.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
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
        addNewEmployee();
    }

    public void addNewEmployee() {
        TextField firstname = new TextField("Firstname");
        TextField lastname  = new TextField("Lastname");
        TextField email = new TextField("Email");
        Button saveButton = new Button("Save");
        saveButton.addClickListener(e -> {
            Employee employee = new Employee(firstname.getValue(), lastname.getValue(), email.getValue());
            employeeService.saveEmployee(employee);
            Notification.show("Employee saved");
        });
        VerticalLayout vl = new VerticalLayout(new HorizontalLayout(firstname, lastname, email), saveButton);
        add(vl);
    }
}
