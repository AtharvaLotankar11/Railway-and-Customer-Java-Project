package com.Atharva.frontend;
import com.Atharva.backend.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingCustomer extends JPanel {

    private RailwayCustomerApp app;
    private JTextField customerIdField;
    private JTextField customerNameField;
    private JTextField customerAgeField;
    private JTextField customerGenderField;
    private JTextField customerEmailField;
    private JTextField customerAddressField;
    private JTextField customerMobileField;
    private JTextField customerDisabilityField;
    private JTextField customerBudgetField;

    public SwingCustomer(RailwayCustomerApp app) {
        this.app = app;
        initializeComponent();
    }

    private void initializeComponent() {
        setLayout(new GridLayout(12, 2));

        // Labels and fields for customer details
        add(new JLabel("Customer ID:"));
        customerIdField = new JTextField();
        add(customerIdField);

        add(new JLabel("Customer Name:"));
        customerNameField = new JTextField();
        add(customerNameField);

        add(new JLabel("Customer Age:"));
        customerAgeField = new JTextField();
        add(customerAgeField);

        add(new JLabel("Customer Gender:"));
        customerGenderField = new JTextField();
        add(customerGenderField);

        add(new JLabel("Customer Email:"));
        customerEmailField = new JTextField();
        add(customerEmailField);

        add(new JLabel("Customer Address:"));
        customerAddressField = new JTextField();
        add(customerAddressField);

        add(new JLabel("Customer Mobile:"));
        customerMobileField = new JTextField();
        add(customerMobileField);

        add(new JLabel("Customer Disability:"));
        customerDisabilityField = new JTextField();
        add(customerDisabilityField);

        add(new JLabel("Customer Budget:"));
        customerBudgetField = new JTextField();
        add(customerBudgetField);

        // Buttons for operations
        JButton addButton = new JButton("Add Customer");
        JButton viewButton = new JButton("View Customer Details");
        JButton viewAllButton = new JButton("View All Customer Details");
        JButton updateButton = new JButton("Update Customer Info");
        JButton deleteButton = new JButton("Delete Customer Info");
        JButton switchToRailwayButton = new JButton("Go to Railway Panel");

        add(addButton);
        add(viewButton);
        add(viewAllButton);
        add(updateButton);
        add(deleteButton);
        add(switchToRailwayButton);

        // Button listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveCustomerDetails();
            }
        });

        switchToRailwayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                app.switchToRailwayPanel();
            }
        });
    }

    private void saveCustomerDetails() {
        // Simulate saving customer details
        // In a real application, you would save these details to a database or file

        String customerId = customerIdField.getText();
        String customerName = customerNameField.getText();
        String customerAge = customerAgeField.getText();
        String customerGender = customerGenderField.getText();
        String customerEmail = customerEmailField.getText();
        String customerAddress = customerAddressField.getText();
        String customerMobile = customerMobileField.getText();
        String customerDisability = customerDisabilityField.getText();
        String customerBudget = customerBudgetField.getText();

        // For demonstration, show a message box confirming the save operation
        JOptionPane.showMessageDialog(this, "Customer details saved:\n" +
                "ID: " + customerId + "\n" +
                "Name: " + customerName + "\n" +
                "Age: " + customerAge + "\n" +
                "Gender: " + customerGender + "\n" +
                "Email: " + customerEmail + "\n" +
                "Address: " + customerAddress + "\n" +
                "Mobile: " + customerMobile + "\n" +
                "Disability: " + customerDisability + "\n" +
                "Budget: " + customerBudget, "Save Confirmation", JOptionPane.INFORMATION_MESSAGE);
    }
}
