package hotel_reservation_system_project;

import java.io.*;
import java.util.ArrayList;

public class Admin extends Person {
    private double salary;

    public Admin(String name, String email, String phone, String password) {
        super(name, email, phone, password);
    }

    public Admin() {}

    public Admin(String name, String email, String phone, String password, double salary) {
        super(name, email, phone, password);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setSalaryToEmployee(Employee employee, double salary) {
        employee.setSalary(salary);
    }

    public Employee addEmployee(String name, String phone, String email, String password) {
        Employee employee = new Employee(name, phone, email, password);
        return employee;
    }

    public Customer addCustomer(String name, String phone, String email, String password) {
        Customer customer = new Customer(name, phone, email, password);
        return customer;
    }

    public Room addRoom(int room_no, String room_type, boolean room_status, int room_price, String room_service) {
        Room room = new Room(room_no, room_type, room_status, room_price, room_service);
        return room;
    }

    public void updateEmployee(String name, String email, String phone, String password, Employee emp) {
        emp.setName(name);
        emp.setEmail(email);
        emp.setPhone(phone);
        emp.setPassword(password);
    }

    public void updateCustomer(String name, String email, String phone, String password, Customer cust) {
        cust.setName(name);
        cust.setEmail(email);
        cust.setPhone(phone);
        cust.setPassword(password);
    }

    public void updateRoom(String room_type, boolean room_status, int room_price, Room room) {
        room.setRoom_status(room_status);
        room.setRoom_type(room_type);
        room.setRoom_price(room_price);
    }

    public void deleteEmployee(ArrayList<Employee> employees, Employee employee) {
        employees.remove(employee);
    }

    public void deleteCustomer(ArrayList<Customer> customers, Customer customer) {
        customers.remove(customer);
    }

    public void deleteRoom(ArrayList<Room> rooms, Room room) {
        rooms.remove(room);
    }

    public static void writeToFile(ArrayList<Admin> admins) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.adminPath))) {
        for (Admin admin : admins) {
            writer.write(admin.getName() + "," + admin.getEmail() + "," + admin.getPhone() + "," + admin.getPassword() + "," + admin.getSalary());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static ArrayList<Admin> readFromFile() {
    ArrayList<Admin> admins = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(path.adminPath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                Admin admin = new Admin(parts[0], parts[1], parts[2], parts[3], Double.parseDouble(parts[4]));
                admins.add(admin);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Admin file not found, creating a new one.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return admins;
}
}