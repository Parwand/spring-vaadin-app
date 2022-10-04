package com.parwand.application.views.todo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("/todo")
public class ToDoView extends VerticalLayout {

    public ToDoView() {
        VerticalLayout todoList = new VerticalLayout();
        TextField todoField = new TextField("Todo");
        Button addButton = new Button("Add Todo to List");

        addButton.addClickListener(e -> {
            Checkbox checkbox = new Checkbox(todoField.getValue());
            todoList.add(checkbox);
        });

        HorizontalLayout hl = new HorizontalLayout(todoField, addButton);
        hl.setDefaultVerticalComponentAlignment(Alignment.BASELINE);

        add(new H1("Vaadin Todos"),
                todoList, hl);
    }
}
