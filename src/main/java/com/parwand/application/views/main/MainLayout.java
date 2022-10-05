package com.parwand.application.views.main;

import com.parwand.application.views.todo.ToDoView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle());
        header.setSizeFull();
        addToNavbar(header);
    }

    private void createDrawer() {
        RouterLink todo = new RouterLink("TODO", ToDoView.class);
        todo.setHighlightCondition(HighlightConditions.sameLocation());
    }
}
