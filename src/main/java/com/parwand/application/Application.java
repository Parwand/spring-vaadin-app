package com.parwand.application;

import com.parwand.application.applicationservice.service.EmployeeService;
import com.parwand.application.domain.model.Employee;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.PWA;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "mytodo")
@PWA(name = "My Todo", shortName = "My Todo", offlineResources = {})
@NpmPackage(value = "line-awesome", version = "1.3.0")
public class Application implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeService employeeService) {
        return args -> {
            employeeService.saveEmployee(new Employee("Lea", "lea", "lea.alsino@mail.de"));
            employeeService.saveEmployee(new Employee("alex", "alsino", "alexa.alsino@mail.de"));
            employeeService.saveEmployee(new Employee("Irina", "alsino", "Irina.alsino@mail.de"));
        };
    }

}
