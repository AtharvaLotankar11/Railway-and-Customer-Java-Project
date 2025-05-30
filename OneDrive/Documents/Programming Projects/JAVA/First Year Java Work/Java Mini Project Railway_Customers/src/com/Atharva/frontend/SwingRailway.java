package com.Atharva.frontend;
import com.Atharva.backend.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingRailway extends JPanel {

    private RailwayCustomerApp app;
    private JTextField trainIdField;
    private JTextField trainNameField;
    private JTextField sourceField;
    private JTextField destinationField;
    private JTextField coachField;
    private JTextField sceTimeField;
    private JTextField destTimeField;
    private JTextField durationField;
    private JTextField railwSugCountField;

    public SwingRailway(RailwayCustomerApp app) {
        this.app = app;
        initializeComponent();
    }

    private void initializeComponent() {
        setLayout(new GridLayout(10, 2));

        // Labels and fields for railway details
        add(new JLabel("Train ID:"));
        trainIdField = new JTextField();
        add(trainIdField);

        add(new JLabel("Train Name:"));
        trainNameField = new JTextField();
        add(trainNameField);

        add(new JLabel("Source:"));
        sourceField = new JTextField();
        add(sourceField);

        add(new JLabel("Destination:"));
        destinationField = new JTextField();
        add(destinationField);

        add(new JLabel("Coach:"));
        coachField = new JTextField();
        add(coachField);

        add(new JLabel("Schedule Time:"));
        sceTimeField = new JTextField();
        add(sceTimeField);

        add(new JLabel("Destination Time:"));
        destTimeField = new JTextField();
        add(destTimeField);

        add(new JLabel("Duration:"));
        durationField = new JTextField();
        add(durationField);

        add(new JLabel("Railway Suggestions Count:"));
        railwSugCountField = new JTextField();
        add(railwSugCountField);

        // Buttons for operations
        JButton addButton = new JButton("Add Railway Info");
        JButton viewButton = new JButton("View Railway Details");
        JButton viewAllButton = new JButton("View All Railway Details");
        JButton updateButton = new JButton("Update Railway Info");
        JButton deleteButton = new JButton("Delete Railway Info");
        JButton switchToCustomerButton = new JButton("Go to Customer Panel");

        add(addButton);
        add(viewButton);
        add(viewAllButton);
        add(updateButton);
        add(deleteButton);
        add(switchToCustomerButton);

        // Button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveRailwayDetails();
            }
        });

        switchToCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.switchToCustomerPanel();
            }
        });
    }

    private void saveRailwayDetails() {
        // Simulate saving railway details
        // In a real application, you would save these details to a database or file

        String trainId = trainIdField.getText();
        String trainName = trainNameField.getText();
        String source = sourceField.getText();
        String destination = destinationField.getText();
        String coach = coachField.getText();
        String sceTime = sceTimeField.getText();
        String destTime = destTimeField.getText();
        String duration = durationField.getText();
        String railwSugCount = railwSugCountField.getText();

        // For demonstration, show a message box confirming the save operation
        JOptionPane.showMessageDialog(this, "Railway details saved:\n" +
                "Train ID: " + trainId + "\n" +
                "Train Name: " + trainName + "\n" +
                "Source: " + source + "\n" +
                "Destination: " + destination + "\n" +
                "Coach: " + coach + "\n" +
                "Schedule Time: " + sceTime + "\n" +
                "Destination Time: " + destTime + "\n" +
                "Duration: " + duration + "\n" +
                "Suggestions Count: " + railwSugCount, "Save Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}
