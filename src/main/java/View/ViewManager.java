package view;

import interface_adapter.ViewManagerModel;

import interface_adapter.ViewManagerModelListener;
import javax.swing.*;
import java.awt.*;


/**
 * The View Manager for the program. It listens for property change events
 * in the ViewManagerModel and updates which View should be visible.
 */
public class ViewManager implements ViewManagerModelListener {
    private final CardLayout cardLayout;
    private final JPanel views;
    private final ViewManagerModel viewManagerModel;

    public ViewManager(JPanel views, CardLayout cardLayout, ViewManagerModel viewManagerModel) {
        this.views = views;
        this.cardLayout = cardLayout;
        this.viewManagerModel = viewManagerModel;
        this.viewManagerModel.addListener(this);
    }


    @Override
    public void viewChanged() {
        cardLayout.show(views, viewManagerModel.getCurrentViewName());
    }
}