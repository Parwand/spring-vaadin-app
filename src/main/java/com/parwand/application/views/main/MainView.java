package com.parwand.application.views.main;

import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Main")
@Route(value = "")
public class MainView extends VerticalLayout {
    TextField name;
    Button sayHello;

    public MainView() {
        name = new TextField("Your name");
        sayHello = new Button("Click me");

        sayHello.addClickListener(e -> Notification.show(name.getValue()));
        sayHello.addClickShortcut(Key.ENTER);
        HorizontalLayout hl = new HorizontalLayout(name, sayHello);
        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);
        add(hl);
    }

}
