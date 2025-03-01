package hotel_reservation_system_project;

import java.util.*;
import javax.swing.SwingUtilities;
import java.io.*;

public class Hotel_Reservation_System_Project {
    public static ArrayList<Admin> admins = new ArrayList<>();
    public static ArrayList<Employee> employees = new ArrayList<>();
    public static ArrayList<Customer> customers = new ArrayList<>();
    public static ArrayList<Room> rooms = new ArrayList<>();

   public static void main(String[] args) {

    loadData();

    // Sample data for testing (optional)
//    Admin admin = new Admin("Admin", "admin", "1234567890", "123", 10000);
//    admins.add(admin);
//    Employee employee = new Employee("Employee", "employee", "0987654321", "123");
//    employees.add(employee);
//    Customer customer = new Customer("Customer", "customer", "1122334455", "123");
//    customers.add(customer);

    // Save initial data to files (optional)
    saveData();

    // Launch the Login GUI
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            new LoginGUI().setVisible(true);
        }
    });
}

public static void loadData() {
    admins = Admin.readFromFile();
    employees = Employee.readFromFile();
    customers = Customer.readFromFile();
    rooms = Room.readFromFile();
}

public static void saveData() {
    Admin.writeToFile(admins);
    Employee.writeToFile(employees);
    Customer.writeToFile(customers);
    Room.writeToFile(rooms);
}

    public static Admin authenticateAdmin(String email, String password) {
        for (Admin admin : admins) {
            if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
                return admin;
            }
        }
        return null;
    }

    public static Employee authenticateEmployee(String email, String password) {
        for (Employee employee : employees) {
            if (employee.getEmail().equals(email) && employee.getPassword().equals(password)) {
                return employee;
            }
        }
        return null;
    }

    public static Customer authenticateCustomer(String email, String password) {
    for (Customer customer : customers) {
        if (customer.getEmail().equals(email) && customer.getPassword().equals(password)) {
            return customer;
        }
    }
    return null;
}
}