package com.parwand.application.views.main;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
    }

    private void createHeader() {
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle());
        header.setSizeFull();
        addToNavbar(header);
    }
}
