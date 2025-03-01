package hotel_reservation_system_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class EmployeeMenuGUI extends JFrame {

    private Employee employee;

    public EmployeeMenuGUI(Employee employee) {
        this.employee = employee;
        setTitle("Employee Menu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("Welcome, " + employee.getName());
        welcomeLabel.setBounds(50, 20, 300, 25);
        panel.add(welcomeLabel);
        JButton filterRoomsButton = new JButton("Filter Rooms");
        filterRoomsButton.setBounds(50, 60, 150, 25);
        panel.add(filterRoomsButton);
        JButton assignRoomButton = new JButton("Assign Room");
        assignRoomButton.setBounds(50, 100, 150, 25);
        panel.add(assignRoomButton);
        JButton changeNameButton = new JButton("Change Name");
        changeNameButton.setBounds(50, 140, 150, 25);
        panel.add(changeNameButton);
        JButton changeEmailButton = new JButton("Change Email");
        changeEmailButton.setBounds(50, 180, 150, 25);
        panel.add(changeEmailButton);
        JButton changePhoneButton = new JButton("Change Phone");
        changePhoneButton.setBounds(50, 220, 150, 25);
        panel.add(changePhoneButton);
        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(50, 260, 150, 25);
        panel.add(changePasswordButton);
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 340, 150, 25);
        panel.add(logoutButton);

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(50, 300, 150, 25);
        panel.add(viewProfileButton);
        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfile();
            }
        });
        filterRoomsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                filterRooms();
            }
        });
        assignRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                assignRoom();
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
        changePhoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePhone();
            }
        });
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePassword();
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

    private void filterRooms() {
        String[] options = {"Type", "Status", "Price"};
        String filterType = (String) JOptionPane.showInputDialog(this, "Filter by:", "Filter Rooms",
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (filterType != null) {
            switch (filterType) {
                case "Type":
                    String type = JOptionPane.showInputDialog(this, "Enter room type:");
                    if (type != null) {
                        ArrayList<Room> roomsByType = employee.FilterRoomsByType(Hotel_Reservation_System_Project.rooms, type);
                        displayRooms(roomsByType);
                    }
                    break;
                case "Status":
                    String statusStr = JOptionPane.showInputDialog(this, "Enter room status (true for occupied, false for vacant):");
                    if (statusStr != null) {
                        boolean status = Boolean.parseBoolean(statusStr);
                        ArrayList<Room> roomsByStatus = employee.FilterRoomsByStatus(Hotel_Reservation_System_Project.rooms, status);
                        displayRooms(roomsByStatus);
                    }
                    break;
                case "Price":
                    String priceStr = JOptionPane.showInputDialog(this, "Enter room price:");
                    if (priceStr != null) {
                        double price = Double.parseDouble(priceStr);
                        ArrayList<Room> roomsByPrice = employee.FilterRoomsByPrice(Hotel_Reservation_System_Project.rooms, price);
                        displayRooms(roomsByPrice);
                    }
                    break;
            }
        }
    }

    private void displayRooms(ArrayList<Room> rooms) {
        StringBuilder message = new StringBuilder("Rooms:\n");
        for (Room room : rooms) {
            message.append("Room No: ").append(room.getRoom_no())
                    .append(", Type: ").append(room.getRoom_type())
                    .append(", Status: ").append(room.isRoom_status() ? "Occupied" : "Vacant")
                    .append(", Price: ").append(room.getRoom_price())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(this, message.toString());
    }

    private void assignRoom() {
        JTextField roomNoField = new JTextField(5);
        JTextField customerIdField = new JTextField(5);
        JTextField checkInDateField = new JTextField(10);
        JTextField checkOutDateField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Room No:"));
        myPanel.add(roomNoField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Customer ID:"));
        myPanel.add(customerIdField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Check-in Date (yyyy-MM-dd):"));
        myPanel.add(checkInDateField);
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Check-out Date (yyyy-MM-dd):"));
        myPanel.add(checkOutDateField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Room Assignment Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int roomNo = Integer.parseInt(roomNoField.getText());
            int customerId = Integer.parseInt(customerIdField.getText());
            String checkInDateStr = checkInDateField.getText();
            String checkOutDateStr = checkOutDateField.getText();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date checkInDate = sdf.parse(checkInDateStr);
                Date checkOutDate = sdf.parse(checkOutDateStr);
                Room roomToAssign = null;
                for (Room room : Hotel_Reservation_System_Project.rooms) {
                    if (room.getRoom_no() == roomNo) {
                        roomToAssign = room;
                        break;
                    }
                }
                Customer customerToAssign = null;
                for (Customer customer : Hotel_Reservation_System_Project.customers) {
                    if (customer.getId() == customerId) {
                        customerToAssign = customer;
                        break;
                    }
                }
                if (roomToAssign != null && customerToAssign != null) {
                    if (employee.assignRoomToCustomer(roomToAssign, customerToAssign, checkInDate, checkOutDate)) {
                        JOptionPane.showMessageDialog(this, "Room assigned successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to assign room.");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Room or Customer not found.");
                }
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(this, "Invalid date format.");
            }
        }
    }

    private void changeName() {
        String newName = JOptionPane.showInputDialog(this, "Enter your new name:");
        if (newName != null) {
            employee.setName(newName);
            Employee.writeToFile(Hotel_Reservation_System_Project.employees);
            JOptionPane.showMessageDialog(this, "Name changed successfully!");
        }
    }

    private void changeEmail() {
        String newEmail = JOptionPane.showInputDialog(this, "Enter your new email:");
        if (newEmail != null) {
            employee.setEmail(newEmail);
            Employee.writeToFile(Hotel_Reservation_System_Project.employees);
            JOptionPane.showMessageDialog(this, "Email changed successfully!");
        }
    }

    private void changePhone() {
        String newPhone = JOptionPane.showInputDialog(this, "Enter your new phone:");
        if (newPhone != null) {
            employee.setPhone(newPhone);
            Employee.writeToFile(Hotel_Reservation_System_Project.employees);
            JOptionPane.showMessageDialog(this, "Phone changed successfully!");
        }
    }

    private void changePassword() {
        String newPassword = JOptionPane.showInputDialog(this, "Enter your new password:");
        if (newPassword != null) {
            employee.setPassword(newPassword);
            Employee.writeToFile(Hotel_Reservation_System_Project.employees);
            JOptionPane.showMessageDialog(this, "Password changed successfully!");
        }
    }

    private void viewProfile() {
        StringBuilder profile = new StringBuilder();
        profile.append("Name: ").append(employee.getName()).append("\n");
        profile.append("Email: ").append(employee.getEmail()).append("\n");
        profile.append("Phone: ").append(employee.getPhone()).append("\n");
        profile.append("Password: ").append("********");
        JOptionPane.showMessageDialog(this, profile.toString(), "Employee Profile", JOptionPane.INFORMATION_MESSAGE);
    }
}
