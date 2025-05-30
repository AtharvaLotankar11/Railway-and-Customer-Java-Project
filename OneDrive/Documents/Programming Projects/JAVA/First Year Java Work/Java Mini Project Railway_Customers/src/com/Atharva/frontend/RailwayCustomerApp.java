package com.Atharva.frontend;
import com.Atharva.backend.Main;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import java.awt.*;

public class RailwayCustomerApp {

    private JFrame frame;
    private CardLayout cardLayout;
    private JPanel mainPanel;

    public RailwayCustomerApp(JFrame frame) {
        this.frame = frame;
        this.cardLayout = new CardLayout();
        this.mainPanel = new JPanel(cardLayout);
        frame.setContentPane(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }

    public void addRailwayPanel(JPanel railwayPanel) {
        mainPanel.add(railwayPanel, "Railway");
    }

    public void addCustomerPanel(JPanel customerPanel) {
        mainPanel.add(customerPanel, "Customer");
    }

    public void switchToRailwayPanel() {
        cardLayout.show(mainPanel, "Railway");
    }

    public void switchToCustomerPanel() {
        cardLayout.show(mainPanel, "Customer");
    }
}
