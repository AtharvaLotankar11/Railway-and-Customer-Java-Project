import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * Fully Integrated Railway Customer Management System Complete application with
 * Customer and Railway management tabs
 */
public class RailwayManagementApp extends JFrame {

    // Data structures
    static class Customer {

        int id;
        String firstName, lastName, email, mobile;
        int age;
        double budget;

        Customer(int id, String firstName, String lastName, int age, String email, String mobile, double budget) {
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.email = email;
            this.mobile = mobile;
            this.budget = budget;
        }
    }

    static class Railway {

        int trainId;
        String trainName, source, destination;
        int departureTime, arrivalTime;

        Railway(int trainId, String trainName, String source, String destination, int departureTime, int arrivalTime) {
            this.trainId = trainId;
            this.trainName = trainName;
            this.source = source;
            this.destination = destination;
            this.departureTime = departureTime;
            this.arrivalTime = arrivalTime;
        }
    }

    private List<Customer> customers;
    private List<Railway> railways;

    public RailwayManagementApp() {
        super("Railway Customer Management System - Working Integration");

        // Initialize data
        customers = new ArrayList<>();
        railways = new ArrayList<>();
        initializeSampleData();

        // Setup GUI
        setupGUI();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 700);
        setLocationRelativeTo(null);
    }

    private void initializeSampleData() {
        customers.add(new Customer(1, "John", "Doe", 25, "john@email.com", "9876543210", 5000.0));
        customers.add(new Customer(2, "Jane", "Smith", 30, "jane@email.com", "9876543211", 7500.0));

        railways.add(new Railway(1, "Rajdhani Express", "New Delhi", "Mumbai Central", 1630, 830));
        railways.add(new Railway(2, "Shatabdi Express", "New Delhi", "Chandigarh", 715, 1045));
    }

    private void setupGUI() {
        setLayout(new BorderLayout());

        // Header with logo
        JPanel header = createHeader();
        add(header, BorderLayout.NORTH);

        // Main tabbed pane
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
        tabbedPane.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));

        // Create panels
        JPanel customerPanel = createCustomerPanel();
        JPanel railwayPanel = createRailwayPanel();

        // Add tabs
        tabbedPane.addTab("👥 Customer Management", customerPanel);
        tabbedPane.addTab("🚂 Railway Management", railwayPanel);

        // Add tabbed pane to center
        add(tabbedPane, BorderLayout.CENTER);

        // Footer
        JPanel footer = new JPanel(new BorderLayout());
        footer.setBackground(new Color(240, 240, 240));
        footer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        
        JLabel copyrightLabel = new JLabel("<html><center>© 2023 - Atharva Lotankar, Aaryan Shetye (Railway GUI Implementors)<br>& Ronit Sahoo, Ishaan Khan (Customer GUI Implementors)</center></html>");
        copyrightLabel.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 10));
        copyrightLabel.setForeground(new Color(100, 100, 100));
        copyrightLabel.setHorizontalAlignment(SwingConstants.CENTER);
        
        footer.add(copyrightLabel, BorderLayout.CENTER);
        add(footer, BorderLayout.SOUTH);
    }

    private JPanel createHeader() {
        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(new Color(63, 81, 181));
        header.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        // Logo
        JLabel logoLabel = new JLabel(createTrainIcon());

        // Title
        JLabel titleLabel = new JLabel("Railway Customer Management System");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));

        header.add(logoLabel, BorderLayout.WEST);
        header.add(titleLabel, BorderLayout.CENTER);

        return header;
    }

    private ImageIcon createTrainIcon() {
        int size = 50;
        java.awt.image.BufferedImage icon = new java.awt.image.BufferedImage(size, size, java.awt.image.BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = icon.createGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.WHITE);
        g2d.fillRoundRect(5, 15, 40, 15, 5, 5);
        g2d.fillRoundRect(2, 18, 8, 8, 3, 3);

        g2d.setColor(new Color(63, 81, 181));
        g2d.fillRoundRect(10, 18, 6, 5, 2, 2);
        g2d.fillRoundRect(20, 18, 6, 5, 2, 2);
        g2d.fillRoundRect(30, 18, 6, 5, 2, 2);

        g2d.setColor(Color.WHITE);
        g2d.fillOval(8, 28, 6, 6);
        g2d.fillOval(18, 28, 6, 6);
        g2d.fillOval(28, 28, 6, 6);
        g2d.fillOval(38, 28, 6, 6);

        g2d.dispose();
        return new ImageIcon(icon);
    }

    private JPanel createCustomerPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Customer table
        String[] columns = {"ID", "First Name", "Last Name", "Age", "Email", "Mobile", "Budget"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);

        // Populate table
        for (Customer customer : customers) {
            Object[] row = {customer.id, customer.firstName, customer.lastName, customer.age, customer.email, customer.mobile, String.format("₹%.2f", customer.budget)};
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 200));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Customer Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Form fields
        JSpinner idSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        idSpinner.setPreferredSize(new Dimension(200, 30));
        idSpinner.setEnabled(false);

        JTextField firstNameField = new JTextField(20);
        firstNameField.setPreferredSize(new Dimension(200, 30));

        JTextField lastNameField = new JTextField(20);
        lastNameField.setPreferredSize(new Dimension(200, 30));

        JSpinner ageSpinner = new JSpinner(new SpinnerNumberModel(18, 1, 120, 1));
        ageSpinner.setPreferredSize(new Dimension(200, 30));

        JTextField emailField = new JTextField(20);
        emailField.setPreferredSize(new Dimension(200, 30));

        JTextField mobileField = new JTextField(20);
        mobileField.setPreferredSize(new Dimension(200, 30));

        JSpinner budgetSpinner = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 999999.0, 100.0));
        budgetSpinner.setPreferredSize(new Dimension(200, 30));

        // Add fields to form
        addFormField(formPanel, gbc, 0, "Customer ID:", idSpinner);
        addFormField(formPanel, gbc, 1, "First Name:", firstNameField);
        addFormField(formPanel, gbc, 2, "Last Name:", lastNameField);
        addFormField(formPanel, gbc, 3, "Age:", ageSpinner);
        addFormField(formPanel, gbc, 4, "Email:", emailField);
        addFormField(formPanel, gbc, 5, "Mobile:", mobileField);
        addFormField(formPanel, gbc, 6, "Budget:", budgetSpinner);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JButton addBtn = new JButton("Add Customer");
        JButton updateBtn = new JButton("Update Customer");
        JButton deleteBtn = new JButton("Delete Customer");
        JButton clearBtn = new JButton("Clear Form");

        addBtn.setBackground(new Color(46, 125, 50));
        addBtn.setForeground(Color.WHITE);
        updateBtn.setBackground(new Color(25, 118, 210));
        updateBtn.setForeground(Color.WHITE);
        deleteBtn.setBackground(new Color(211, 47, 47));
        deleteBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(new Color(158, 158, 158));
        clearBtn.setForeground(Color.WHITE);

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);

        gbc.gridy = 7;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        panel.add(formPanel, BorderLayout.EAST);

        // Event handlers
        // Table selection listener
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Customer customer = customers.get(selectedRow);
                    idSpinner.setValue(customer.id);
                    firstNameField.setText(customer.firstName);
                    lastNameField.setText(customer.lastName);
                    ageSpinner.setValue(customer.age);
                    emailField.setText(customer.email);
                    mobileField.setText(customer.mobile);
                    budgetSpinner.setValue(customer.budget);
                }
            }
        });

        addBtn.addActionListener(e -> {
            try {
                int newId = customers.stream().mapToInt(c -> c.id).max().orElse(0) + 1;
                Customer customer = new Customer(newId, firstNameField.getText(), lastNameField.getText(),
                        (Integer) ageSpinner.getValue(), emailField.getText(), mobileField.getText(),
                        ((Number) budgetSpinner.getValue()).doubleValue());
                customers.add(customer);

                Object[] row = {customer.id, customer.firstName, customer.lastName, customer.age, customer.email, customer.mobile, String.format("₹%.2f", customer.budget)};
                tableModel.addRow(row);

                JOptionPane.showMessageDialog(panel, "Customer added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                int selectedRow = table.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(panel, "Please select a customer to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Customer customer = customers.get(selectedRow);
                customer.firstName = firstNameField.getText();
                customer.lastName = lastNameField.getText();
                customer.age = (Integer) ageSpinner.getValue();
                customer.email = emailField.getText();
                customer.mobile = mobileField.getText();
                customer.budget = ((Number) budgetSpinner.getValue()).doubleValue();

                // Update table row
                tableModel.setValueAt(customer.id, selectedRow, 0);
                tableModel.setValueAt(customer.firstName, selectedRow, 1);
                tableModel.setValueAt(customer.lastName, selectedRow, 2);
                tableModel.setValueAt(customer.age, selectedRow, 3);
                tableModel.setValueAt(customer.email, selectedRow, 4);
                tableModel.setValueAt(customer.mobile, selectedRow, 5);
                tableModel.setValueAt(String.format("₹%.2f", customer.budget), selectedRow, 6);

                JOptionPane.showMessageDialog(panel, "Customer updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(panel, "Please select a customer to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Customer customer = customers.get(selectedRow);
            int result = JOptionPane.showConfirmDialog(panel, 
                "Are you sure you want to delete customer: " + customer.firstName + " " + customer.lastName + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                customers.remove(selectedRow);
                tableModel.removeRow(selectedRow);
                // Clear form
                idSpinner.setValue(0);
                firstNameField.setText("");
                lastNameField.setText("");
                ageSpinner.setValue(18);
                emailField.setText("");
                mobileField.setText("");
                budgetSpinner.setValue(0.0);
                JOptionPane.showMessageDialog(panel, "Customer deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearBtn.addActionListener(e -> {
            idSpinner.setValue(0);
            firstNameField.setText("");
            lastNameField.setText("");
            ageSpinner.setValue(18);
            emailField.setText("");
            mobileField.setText("");
            budgetSpinner.setValue(0.0);
            table.clearSelection();
        });

        return panel;
    }

    private JPanel createRailwayPanel() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Railway table
        String[] columns = {"Train ID", "Train Name", "Source", "Destination", "Departure", "Arrival"};
        DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
        JTable table = new JTable(tableModel);
        table.setRowHeight(25);

        // Populate table
        for (Railway railway : railways) {
            Object[] row = {railway.trainId, railway.trainName, railway.source, railway.destination,
                formatTime(railway.departureTime), formatTime(railway.arrivalTime)};
            tableModel.addRow(row);
        }

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(700, 200));
        panel.add(scrollPane, BorderLayout.CENTER);

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createTitledBorder("Railway Details"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Form fields
        JSpinner trainIdSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 9999, 1));
        trainIdSpinner.setPreferredSize(new Dimension(200, 30));
        trainIdSpinner.setEnabled(false);

        JTextField trainNameField = new JTextField(20);
        trainNameField.setPreferredSize(new Dimension(200, 30));

        String[] stations = {
            "Mumbai Central", "New Delhi", "Kolkata", "Chennai Central", "Bangalore City",
            "Hyderabad", "Pune", "Ahmedabad", "Jaipur", "Lucknow", "Kanpur", "Nagpur",
            "Indore", "Bhopal", "Patna", "Guwahati", "Kochi", "Thiruvananthapuram",
            "Coimbatore", "Madurai", "Vijayawada", "Visakhapatnam", "Bhubaneswar",
            "Cuttack", "Raipur", "Bilaspur", "Jabalpur", "Gwalior", "Agra", "Varanasi",
            "Shirdi", "Nashik", "Aurangabad", "Solapur", "Hubli", "Mysore", "Mangalore"
        };
        JComboBox<String> sourceCombo = new JComboBox<>(stations);
        sourceCombo.setPreferredSize(new Dimension(200, 30));

        JComboBox<String> destinationCombo = new JComboBox<>(stations);
        destinationCombo.setPreferredSize(new Dimension(200, 30));

        JSpinner departureSpinner = new JSpinner(new SpinnerNumberModel(800, 0, 2359, 1));
        departureSpinner.setPreferredSize(new Dimension(200, 30));

        JSpinner arrivalSpinner = new JSpinner(new SpinnerNumberModel(1200, 0, 2359, 1));
        arrivalSpinner.setPreferredSize(new Dimension(200, 30));

        // Add fields to form
        addFormField(formPanel, gbc, 0, "Train ID:", trainIdSpinner);
        addFormField(formPanel, gbc, 1, "Train Name:", trainNameField);
        addFormField(formPanel, gbc, 2, "Source:", sourceCombo);
        addFormField(formPanel, gbc, 3, "Destination:", destinationCombo);
        addFormField(formPanel, gbc, 4, "Departure:", departureSpinner);
        addFormField(formPanel, gbc, 5, "Arrival:", arrivalSpinner);

        // Buttons
        JPanel buttonPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        JButton addBtn = new JButton("Add Railway");
        JButton updateBtn = new JButton("Update Railway");
        JButton deleteBtn = new JButton("Delete Railway");
        JButton clearBtn = new JButton("Clear Form");

        addBtn.setBackground(new Color(46, 125, 50));
        addBtn.setForeground(Color.WHITE);
        updateBtn.setBackground(new Color(25, 118, 210));
        updateBtn.setForeground(Color.WHITE);
        deleteBtn.setBackground(new Color(211, 47, 47));
        deleteBtn.setForeground(Color.WHITE);
        clearBtn.setBackground(new Color(158, 158, 158));
        clearBtn.setForeground(Color.WHITE);

        buttonPanel.add(addBtn);
        buttonPanel.add(updateBtn);
        buttonPanel.add(deleteBtn);
        buttonPanel.add(clearBtn);

        gbc.gridy = 6;
        gbc.gridx = 0;
        gbc.gridwidth = 2;
        formPanel.add(buttonPanel, gbc);

        panel.add(formPanel, BorderLayout.EAST);

        // Event handlers
        // Table selection listener
        table.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow >= 0) {
                    Railway railway = railways.get(selectedRow);
                    trainIdSpinner.setValue(railway.trainId);
                    trainNameField.setText(railway.trainName);
                    sourceCombo.setSelectedItem(railway.source);
                    destinationCombo.setSelectedItem(railway.destination);
                    departureSpinner.setValue(railway.departureTime);
                    arrivalSpinner.setValue(railway.arrivalTime);
                }
            }
        });

        addBtn.addActionListener(e -> {
            try {
                int newId = railways.stream().mapToInt(r -> r.trainId).max().orElse(0) + 1;
                Railway railway = new Railway(newId, trainNameField.getText(),
                        sourceCombo.getSelectedItem().toString(), destinationCombo.getSelectedItem().toString(),
                        (Integer) departureSpinner.getValue(), (Integer) arrivalSpinner.getValue());
                railways.add(railway);

                Object[] row = {railway.trainId, railway.trainName, railway.source, railway.destination,
                    formatTime(railway.departureTime), formatTime(railway.arrivalTime)};
                tableModel.addRow(row);

                JOptionPane.showMessageDialog(panel, "Railway added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        updateBtn.addActionListener(e -> {
            try {
                int selectedRow = table.getSelectedRow();
                if (selectedRow < 0) {
                    JOptionPane.showMessageDialog(panel, "Please select a railway to update", "No Selection", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                Railway railway = railways.get(selectedRow);
                railway.trainName = trainNameField.getText();
                railway.source = sourceCombo.getSelectedItem().toString();
                railway.destination = destinationCombo.getSelectedItem().toString();
                railway.departureTime = (Integer) departureSpinner.getValue();
                railway.arrivalTime = (Integer) arrivalSpinner.getValue();

                // Update table row
                tableModel.setValueAt(railway.trainId, selectedRow, 0);
                tableModel.setValueAt(railway.trainName, selectedRow, 1);
                tableModel.setValueAt(railway.source, selectedRow, 2);
                tableModel.setValueAt(railway.destination, selectedRow, 3);
                tableModel.setValueAt(formatTime(railway.departureTime), selectedRow, 4);
                tableModel.setValueAt(formatTime(railway.arrivalTime), selectedRow, 5);

                JOptionPane.showMessageDialog(panel, "Railway updated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(panel, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        deleteBtn.addActionListener(e -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow < 0) {
                JOptionPane.showMessageDialog(panel, "Please select a railway to delete", "No Selection", JOptionPane.WARNING_MESSAGE);
                return;
            }
            Railway railway = railways.get(selectedRow);
            int result = JOptionPane.showConfirmDialog(panel, 
                "Are you sure you want to delete railway: " + railway.trainName + "?",
                "Confirm Delete", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                railways.remove(selectedRow);
                tableModel.removeRow(selectedRow);
                // Clear form
                trainIdSpinner.setValue(0);
                trainNameField.setText("");
                sourceCombo.setSelectedIndex(0);
                destinationCombo.setSelectedIndex(0);
                departureSpinner.setValue(800);
                arrivalSpinner.setValue(1200);
                JOptionPane.showMessageDialog(panel, "Railway deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        clearBtn.addActionListener(e -> {
            trainIdSpinner.setValue(0);
            trainNameField.setText("");
            sourceCombo.setSelectedIndex(0);
            destinationCombo.setSelectedIndex(0);
            departureSpinner.setValue(800);
            arrivalSpinner.setValue(1200);
            table.clearSelection();
        });

        return panel;
    }

    private void addFormField(JPanel panel, GridBagConstraints gbc, int row, String label, JComponent field) {
        gbc.gridy = row;
        gbc.gridx = 0;
        panel.add(new JLabel(label), gbc);
        gbc.gridx = 1;
        panel.add(field, gbc);
    }

    private String formatTime(int time) {
        int hours = time / 100;
        int minutes = time % 100;
        return String.format("%02d:%02d", hours, minutes);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                    if ("Nimbus".equals(info.getName())) {
                        UIManager.setLookAndFeel(info.getClassName());
                        break;
                    }
                }
            } catch (Exception e) {
                // Use default
            }

            JOptionPane.showMessageDialog(null,
                    "🎉 Railway Customer Management System - Complete!\n\n"
                    + "✅ Customer Management: Add, Update, Delete, Clear\n"
                    + "✅ Railway Management: Add, Update, Delete, Clear\n"
                    + "✅ Scrollable ID and Budget fields\n"
                    + "✅ All major Indian cities (35+ stations)\n"
                    + "✅ Table selection to populate forms\n"
                    + "✅ Complete CRUD operations for both modules\n\n"
                    + "Ready to use!",
                    "System Ready",
                    JOptionPane.INFORMATION_MESSAGE);

            new RailwayManagementApp().setVisible(true);
        });
    }
}
