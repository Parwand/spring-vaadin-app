package com.parwand.application.views.employee;

import com.parwand.application.applicationservice.service.EmployeeService;
import com.parwand.application.domain.model.Employee;
import com.parwand.application.views.main.MainLayout;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

@Route(value = "/employee", layout = MainLayout.class)
public class EmployeeView extends VerticalLayout {
    private final Grid<Employee> grid = new Grid<>(Employee.class, false);
    private final EmployeeService employeeService;

    private final TextField filterText = new TextField();

    public EmployeeView(EmployeeService employeeService) {
        addClassName("list-view");
        this.employeeService = employeeService;
        configureGrid();
        updateList();
        configureFilter();
        add(filterText, grid);
        addNewEmployee();
    }

    private void configureGrid() {
        grid.addClassName("contact-grid");
        grid.addColumn(Employee::getFirstname).setHeader("First Name");
        grid.addColumn(Employee::getLastname).setHeader("Last Name");
        grid.addColumn(Employee::getEmail).setHeader("Email");
        grid.getColumns().forEach( col -> col.setAutoWidth(true));
    }

    private void configureFilter() {
        filterText.setPlaceholder("Filter by Name..");
        filterText.setClearButtonVisible(true);
        filterText.setValueChangeMode(ValueChangeMode.LAZY);
        filterText.addValueChangeListener(e -> {
           updateList();
        });
    }

    public void addNewEmployee() {
        FormLayout formLayout = new FormLayout();
        TextField firstname = new TextField("Firstname");
        TextField lastname  = new TextField("Lastname");
        TextField email = new TextField("Email");
        Button saveButton = new Button("Save");
        saveButton.addClickListener(e -> {
            Employee employee = new Employee(firstname.getValue(), lastname.getValue(), email.getValue());
            employeeService.saveEmployee(employee);
            Notification.show("Employee saved");
            UI.getCurrent().getPage().reload();
        });
        VerticalLayout vl = new VerticalLayout(new HorizontalLayout(firstname, lastname, email), saveButton);
        formLayout.add(vl);
        add(formLayout);
    }

    private void updateList() {
        grid.setItems(employeeService.getAllEmployees(filterText.getValue()));
    }
}
