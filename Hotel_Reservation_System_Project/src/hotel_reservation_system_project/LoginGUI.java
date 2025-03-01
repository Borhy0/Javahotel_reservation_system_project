package hotel_reservation_system_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;
    private JComboBox<String> userTypeComboBox;

    public LoginGUI() {
        setTitle("Hotel Reservation System - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(50, 50, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField(20);
        emailField.setBounds(150, 50, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 100, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(150, 100, 165, 25);
        panel.add(passwordField);

        JLabel userTypeLabel = new JLabel("User Type:");
        userTypeLabel.setBounds(50, 150, 80, 25);
        panel.add(userTypeLabel);

        String[] userTypes = {"Admin", "Employee", "Customer"};
        userTypeComboBox = new JComboBox<>(userTypes);
        userTypeComboBox.setBounds(150, 150, 165, 25);
        panel.add(userTypeComboBox);

        loginButton = new JButton("Login");
        loginButton.setBounds(150, 200, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());
                String userType = (String) userTypeComboBox.getSelectedItem();
                handleLogin(email, password, userType);
            }
        });

        add(panel);
    }

   private void handleLogin(String email, String password, String userType) {
    switch (userType) {
        case "Admin":
            Admin admin = Hotel_Reservation_System_Project.authenticateAdmin(email, password);
            if (admin != null) {
                JOptionPane.showMessageDialog(this, "Admin login successful!");
                new AdminMenuGUI(admin).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Admin credentials.");
            }
            break;
        case "Employee":
            Employee employee = Hotel_Reservation_System_Project.authenticateEmployee(email, password);
            if (employee != null) {
                JOptionPane.showMessageDialog(this, "Employee login successful!");
                new EmployeeMenuGUI(employee).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Employee credentials.");
            }
            break;
        case "Customer":
            Customer customer = Hotel_Reservation_System_Project.authenticateCustomer(email, password);
            if (customer != null) {
                JOptionPane.showMessageDialog(this, "Customer login successful!");
                new CustomerMenuGUI(customer).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Customer credentials.");
            }
            break;
    }
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LoginGUI().setVisible(true);
            }
        });
    }
}
