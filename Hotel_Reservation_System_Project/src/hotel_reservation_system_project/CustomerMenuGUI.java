package hotel_reservation_system_project;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerMenuGUI extends JFrame {

    private Customer customer;

    public CustomerMenuGUI(Customer customer) {
        this.customer = customer;
        setTitle("Customer Menu");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        JLabel welcomeLabel = new JLabel("Welcome, " + customer.getName());
        welcomeLabel.setBounds(50, 20, 300, 25);
        panel.add(welcomeLabel);
        JButton viewCheckInDateButton = new JButton("View Check-in Date");
        viewCheckInDateButton.setBounds(50, 60, 150, 25);
        panel.add(viewCheckInDateButton);
        JButton viewCheckOutDateButton = new JButton("View Check-out Date");
        viewCheckOutDateButton.setBounds(50, 100, 150, 25);
        panel.add(viewCheckOutDateButton);
        JButton requestRoomButton = new JButton("Request Room");
        requestRoomButton.setBounds(50, 140, 150, 25);
        panel.add(requestRoomButton);
        JButton changeNameButton = new JButton("Change Name");
        changeNameButton.setBounds(50, 180, 150, 25);
        panel.add(changeNameButton);
        JButton changeEmailButton = new JButton("Change Email");
        changeEmailButton.setBounds(50, 220, 150, 25);
        panel.add(changeEmailButton);
        JButton changePhoneButton = new JButton("Change Phone");
        changePhoneButton.setBounds(50, 260, 150, 25);
        panel.add(changePhoneButton);
        JButton changePasswordButton = new JButton("Change Password");
        changePasswordButton.setBounds(50, 300, 150, 25);
        panel.add(changePasswordButton);

        JButton viewProfileButton = new JButton("View Profile");
        viewProfileButton.setBounds(50, 340, 150, 25);
        panel.add(viewProfileButton);
        viewProfileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewProfile();
            }
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(50, 380, 150, 25);
        panel.add(logoutButton);

        viewCheckInDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your check-in date is: " + customer.getCheckInDate());
            }
        });
        viewCheckOutDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your check-out date is: " + customer.getCheckOutDate());
            }
        });
        requestRoomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                requestRoom();
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

    private void requestRoom() {
        JTextField noOfRoomsField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.add(new JLabel("Number of Rooms:"));
        myPanel.add(noOfRoomsField);
        int result = JOptionPane.showConfirmDialog(null, myPanel,
                "Please Enter Room Request Details", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            int noOfRooms = Integer.parseInt(noOfRoomsField.getText());
            customer.requestRoom(noOfRooms);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);

            JOptionPane.showMessageDialog(this, "You have requested " + noOfRooms + " room(s).");
        }
    }

    private void changeName() {
        String newName = JOptionPane.showInputDialog(this, "Enter your new name:");
        if (newName != null) {
            customer.setName(newName);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);

            JOptionPane.showMessageDialog(this, "Name changed successfully!");
        }
    }

    private void changeEmail() {
        String newEmail = JOptionPane.showInputDialog(this, "Enter your new email:");
        if (newEmail != null) {
            customer.setEmail(newEmail);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);

            JOptionPane.showMessageDialog(this, "Email changed successfully!");
        }
    }

    private void changePhone() {
        String newPhone = JOptionPane.showInputDialog(this, "Enter your new phone:");
        if (newPhone != null) {
            customer.setPhone(newPhone);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);

            JOptionPane.showMessageDialog(this, "Phone changed successfully!");
        }
    }

    private void changePassword() {
        String newPassword = JOptionPane.showInputDialog(this, "Enter your new password:");
        if (newPassword != null) {
            customer.setPassword(newPassword);
            Customer.writeToFile(Hotel_Reservation_System_Project.customers);
            JOptionPane.showMessageDialog(this, "Password changed successfully!");
        }
    }

    private void viewProfile() {
        StringBuilder profile = new StringBuilder();
        profile.append("Name: ").append(customer.getName()).append("\n");
        profile.append("Email: ").append(customer.getEmail()).append("\n");
        profile.append("Phone: ").append(customer.getPhone()).append("\n");
        profile.append("Password: ").append("********");
        JOptionPane.showMessageDialog(this, profile.toString(), "Customer Profile", JOptionPane.INFORMATION_MESSAGE);
    }
}
