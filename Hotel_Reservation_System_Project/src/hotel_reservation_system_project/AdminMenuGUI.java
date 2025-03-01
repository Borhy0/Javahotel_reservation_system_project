package hotel_reservation_system_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuGUI extends JFrame {

    private Admin admin;

    public AdminMenuGUI(Admin admin) {
        this.admin = admin;
        setTitle("Admin Menu");
        setSize(400, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel welcomeLabel = new JLabel("Welcome, " + admin.getName());
        welcomeLabel.setBounds(50, 20, 300, 25);
        panel.add(welcomeLabel);
        JButton generateRoomReportButton = new JButton("Generate Room Report");
        generateRoomReportButton.setBounds(50, 60, 200, 25);
        panel.add(generateRoomReportButton);

        JButton generateCheckoutReportButton = new JButton("Generate Checkout Report");
        generateCheckoutReportButton.setBounds(50, 100, 200, 25);
        panel.add(generateCheckoutReportButton);
        generateRoomReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateRoomReport();
            }
        });

        generateCheckoutReportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generateCheckoutReport();
            }
        });

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.setBounds(50, 140, 150, 25);
        panel.add(addEmployeeButton);

        JButton addCustomerButton = new JButton("Add Customer");
        addCustomerButton.setBounds(50, 180, 150, 25);
        panel.add(addCustomerButton);

        JButton addRoomButton = new JButton("Add Room");
        addRoomButton.setBounds(50, 220, 150, 25);
        panel.add(addRoomButton);

        JButton updateEmployeeButton = new JButton("Update Employee");
        updateEmployeeButton.setBounds(50, 260, 150, 25);
        panel.add(updateEmployeeButton);

        JButton updateCustomerButton = new JButton("Update Customer");
        updateCustomerButton.setBounds(50, 300, 150, 25);
        panel.add(updateCustomerButton);

        JButton updateRoomButton = new JButton("Update Room");
        updateRoomButton.setBounds(50, 340, 150, 25);
        panel.add(updateRoomButton);

        JButton deleteEmployeeButton = new JButton("Delete Employee");
        deleteEmployeeButton.setBounds(50, 380, 150, 25);
        panel.add(deleteEmployeeButton);

        JButton deleteCustomerButton = new JButton("Delete Customer");
        deleteCustomerButton.setBounds(50, 420, 150, 25);
        panel.add(deleteCustomerButton);

        JButton deleteRoomButton = new JButton("Delete Room");
        deleteRoomButton.setBounds(50, 460, 150, 25);
        panel.add(deleteRoomButton);

        JButton changeNameButton = new JButton("Change Name");
        changeNameButton.setBounds(50, 500, 150, 25);
        panel.add(changeNameButton);

        JButton changeEmailButton = new JButton("Change Email");
        changeEmailButton.setBounds(50, 540, 150, 25);
        panel.add(changeEmailButton);

        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(50, 580, 150, 25);
        panel.add(changePasswordButton);

        JButton changePhoneButton = new JButton("Change Phone");
        changePhoneButton.setBounds(50, 620, 150, 25);
        panel.add(changePhoneButton);

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(50, 660, 150, 25);
        panel.add(viewProfileButton);

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 700, 150, 25);
        panel.add(logoutButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });

        addCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        addRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRoom();
            }
        });

        updateEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateEmployee();
            }
        });

        updateCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCustomer();
            }
        });

        updateRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateRoom();
            }
        });

        deleteEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteEmployee();
            }
        });

        deleteCustomerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteCustomer();
            }
        });

        deleteRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteRoom();
            }
        });

        changeNameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeName();
            }
        });

        changeEmailButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changeEmail();
            }
        });

        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePassword();
            }
        });

        changePhoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePhone();
            }
        });

        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfile();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginGUI().setVisible(true);
            }
        });

        add(panel);
    }

    private void generateRoomReport() {
        Report report = new Report();
        String roomReport = report.generateRoomReport(Hotel_Reservation_System_Project.rooms);
        JOptionPane.showMessageDialog(this, roomReport, "Room Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private void generateCheckoutReport() {
        Report report = new Report();
        String checkoutReport = report.generateNearCheckoutReport(Hotel_Reservation_System_Project.customers);
        JOptionPane.showMessageDialog(this, checkoutReport, "Checkout Report", JOptionPane.INFORMATION_MESSAGE);
    }

    private void addEmployee() {
        JTextField nameField = new JTextField(5);
        JTextField phoneField = new JTextField(5);
        JTextField emailField = new JTextField(5);
        JTextField passwordField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Phone:"));
        myPanel.add(phoneField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Password:"));
        myPanel.add(passwordField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            Employee employee = admin.addEmployee(name, phone, email, password);
            Hotel_Reservation_System_Project.employees.add(employee);
            Employee.writeToFile(Hotel_Reservation_System_Project.employees);
            JOptionPane.showMessageDialog(this, "Employee added successfully!");
        }
    }

    private void addCustomer() {
        JTextField nameField = new JTextField(5);
        JTextField phoneField = new JTextField(5);
        JTextField emailField = new JTextField(5);
        JTextField passwordField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Phone:"));
        myPanel.add(phoneField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Password:"));
        myPanel.add(passwordField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Customer Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String phone = phoneField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            Customer customer = admin.addCustomer(name, phone, email, password);
            Hotel_Reservation_System_Project.customers.add(customer);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);
            JOptionPane.showMessageDialog(this, "Customer added successfully!");
        }
    }

    private void addRoom() {
        JTextField roomNoField = new JTextField(5);
        JTextField roomTypeField = new JTextField(5);
        JTextField roomPriceField = new JTextField(5);
        JTextField roomServiceField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Room No:"));
        myPanel.add(roomNoField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Room Type:"));
        myPanel.add(roomTypeField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Room Price:"));
        myPanel.add(roomPriceField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Room Service:"));
        myPanel.add(roomServiceField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Room Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int roomNo = Integer.parseInt(roomNoField.getText());
            String roomType = roomTypeField.getText();
            int roomPrice = Integer.parseInt(roomPriceField.getText());
            String roomService = roomServiceField.getText();
            Room room = admin.addRoom(roomNo, roomType, true, roomPrice, roomService);
            Hotel_Reservation_System_Project.rooms.add(room);
            Room.writeToFile(Hotel_Reservation_System_Project.rooms);
            JOptionPane.showMessageDialog(this, "Room added successfully!");
        }
    }

    private void updateEmployee() {
        JTextField empIdField = new JTextField(5);
        JTextField nameField = new JTextField(5);
        JTextField emailField = new JTextField(5);
        JTextField phoneField = new JTextField(5);
        JTextField passwordField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Employee ID:"));
        myPanel.add(empIdField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Email:"));
        myPanel.add(emailField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Phone:"));
        myPanel.add(phoneField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Password:"));
        myPanel.add(passwordField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Employee Update Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int empId = Integer.parseInt(empIdField.getText());
            String newName = nameField.getText();
            String newEmail = emailField.getText();
            String newPhone = phoneField.getText();
            String newPassword = passwordField.getText();
            Employee empToUpdate = null;
            for (Employee emp : Hotel_Reservation_System_Project.employees) {
                if (emp.getId() == empId) {
                    empToUpdate = emp;
                    break;
                }
            }
            if (empToUpdate != null) {
                admin.updateEmployee(newName, newEmail, newPhone, newPassword, empToUpdate);
                Employee.writeToFile(Hotel_Reservation_System_Project.employees);

                JOptionPane.showMessageDialog(this, "Employee updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }
        }
    }

    private void updateCustomer() {
        JTextField custIdField = new JTextField(5);
        JTextField nameField = new JTextField(5);
        JTextField emailField = new JTextField(5);
        JTextField phoneField = new JTextField(5);
        JTextField passwordField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Customer ID:"));
        myPanel.add(custIdField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Name:"));
        myPanel.add(nameField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Email:"));
        myPanel.add(emailField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Phone:"));
        myPanel.add(phoneField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Password:"));
        myPanel.add(passwordField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Customer Update Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int custId = Integer.parseInt(custIdField.getText());
            String newName = nameField.getText();
            String newEmail = emailField.getText();
            String newPhone = phoneField.getText();
            String newPassword = passwordField.getText();
            Customer custToUpdate = null;
            for (Customer cust : Hotel_Reservation_System_Project.customers) {
                if (cust.getId() == custId) {
                    custToUpdate = cust;
                    break;
                }
            }
            if (custToUpdate != null) {
                admin.updateCustomer(newName, newEmail, newPhone, newPassword, custToUpdate);
                Customer.writeToFile(Hotel_Reservation_System_Project.customers);

                JOptionPane.showMessageDialog(this, "Customer updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.");
            }
        }
    }

    private void updateRoom() {
        JTextField roomNoField = new JTextField(5);
        JTextField roomTypeField = new JTextField(5);
        JTextField roomStatusField = new JTextField(5);
        JTextField roomPriceField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Room No:"));
        myPanel.add(roomNoField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Type:"));
        myPanel.add(roomTypeField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Status (true for occupied, false for vacant):"));
        myPanel.add(roomStatusField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("New Price:"));
        myPanel.add(roomPriceField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Room Update Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int roomNo = Integer.parseInt(roomNoField.getText());
            String newRoomType = roomTypeField.getText();
            boolean newRoomStatus = Boolean.parseBoolean(roomStatusField.getText());
            int newRoomPrice = Integer.parseInt(roomPriceField.getText());
            Room roomToUpdate = null;
            for (Room room : Hotel_Reservation_System_Project.rooms) {
                if (room.getRoom_no() == roomNo) {
                    roomToUpdate = room;
                    break;
                }
            }
            if (roomToUpdate != null) {
                admin.updateRoom(newRoomType, newRoomStatus, newRoomPrice, roomToUpdate);
                Room.writeToFile(Hotel_Reservation_System_Project.rooms);

                JOptionPane.showMessageDialog(this, "Room updated successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Room not found.");
            }
        }
    }

    private void deleteEmployee() {
        JTextField empIdField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Employee ID:"));
        myPanel.add(empIdField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Employee ID to Delete", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int empId = Integer.parseInt(empIdField.getText());
            Employee empToDelete = null;
            for (Employee emp : Hotel_Reservation_System_Project.employees) {
                if (emp.getId() == empId) {
                    empToDelete = emp;
                    break;
                }
            }
            if (empToDelete != null) {
                admin.deleteEmployee(Hotel_Reservation_System_Project.employees, empToDelete);
                Employee.writeToFile(Hotel_Reservation_System_Project.employees);

                JOptionPane.showMessageDialog(this, "Employee deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Employee not found.");
            }
        }
    }

    private void deleteCustomer() {
        JTextField custIdField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Customer ID:"));
        myPanel.add(custIdField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Customer ID to Delete", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int custId = Integer.parseInt(custIdField.getText());
            Customer custToDelete = null;
            for (Customer cust : Hotel_Reservation_System_Project.customers) {
                if (cust.getId() == custId) {
                    custToDelete = cust;
                    break;
                }
            }
            if (custToDelete != null) {
                admin.deleteCustomer(Hotel_Reservation_System_Project.customers, custToDelete);
                Customer.writeToFile(Hotel_Reservation_System_Project.customers);

                JOptionPane.showMessageDialog(this, "Customer deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Customer not found.");
            }
        }
    }

    private void deleteRoom() {
        JTextField roomNoField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Room No:"));
        myPanel.add(roomNoField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Room Number to Delete", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int roomNo = Integer.parseInt(roomNoField.getText());
            Room roomToDelete = null;
            for (Room room : Hotel_Reservation_System_Project.rooms) {
                if (room.getRoom_no() == roomNo) {
                    roomToDelete = room;
                    break;
                }
            }
            if (roomToDelete != null) {
                admin.deleteRoom(Hotel_Reservation_System_Project.rooms, roomToDelete);
                Room.writeToFile(Hotel_Reservation_System_Project.rooms);

                JOptionPane.showMessageDialog(this, "Room deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(this, "Room not found.");
            }
        }
    }

    private void changeName() {
        String newName = JOptionPane.showInputDialog(this, "Enter your new name:");
        if (newName != null) {
            admin.setName(newName);
            Admin.writeToFile(Hotel_Reservation_System_Project.admins);

            JOptionPane.showMessageDialog(this, "Name changed successfully!");
        }
    }

    private void changeEmail() {
        String newEmail = JOptionPane.showInputDialog(this, "Enter your new email:");
        if (newEmail != null) {
            admin.setEmail(newEmail);
            Admin.writeToFile(Hotel_Reservation_System_Project.admins);

            JOptionPane.showMessageDialog(this, "Email changed successfully!");
        }
    }

    private void changePassword() {
        String newPassword = JOptionPane.showInputDialog(this, "Enter your new password:");
        if (newPassword != null) {
            admin.setPassword(newPassword);
            Admin.writeToFile(Hotel_Reservation_System_Project.admins);

            JOptionPane.showMessageDialog(this, "Password changed successfully!");
        }
    }

    private void changePhone() {
        String newPhone = JOptionPane.showInputDialog(this, "Enter your new phone:");
        if (newPhone != null) {
            admin.setPhone(newPhone);
            Admin.writeToFile(Hotel_Reservation_System_Project.admins);
            JOptionPane.showMessageDialog(this, "Phone changed successfully!");
        }
    }

    private void viewProfile() {
        StringBuilder profile = new StringBuilder();
        profile.append("Name: ").append(admin.getName()).append("\n");
        profile.append("Email: ").append(admin.getEmail()).append("\n");
        profile.append("Phone: ").append(admin.getPhone()).append("\n");
        profile.append("Password: ").append("********");
        JOptionPane.showMessageDialog(this, profile.toString(), "Admin Profile", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        Admin admin = new Admin("Admin", "admin@example.com", "1234567890", "password", 5000);
        AdminMenuGUI adminMenuGUI = new AdminMenuGUI(admin);
        adminMenuGUI.setVisible(true);
    }
}
