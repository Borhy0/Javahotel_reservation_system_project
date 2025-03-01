package hotel_reservation_system_project;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Employee extends Person {
    private double salary;

    public Employee() {
        super();
    }

    public Employee(String name, String phone, String email, String password) {
        super(name, phone, email, password);
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public ArrayList<Room> FilterRoomsByType(ArrayList<Room> rooms, String Type) {
        ArrayList<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (Type.equals(room.getRoom_type())) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    public ArrayList<Room> FilterRoomsByStatus(ArrayList<Room> rooms, boolean status) {
        ArrayList<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (status == room.isRoom_status()) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    public ArrayList<Room> FilterRoomsByPrice(ArrayList<Room> rooms, double price) {
        ArrayList<Room> filteredRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (price == room.getRoom_price()) {
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    public String GetRoomType(Room room) {
        return room.getRoom_type();
    }

    public double GetRoomPrice(Room room) {
        return room.getRoom_price();
    }

    public boolean GetRoomStatus(Room room) {
        return room.isRoom_status();
    }

    private List<RoomAssignment> roomAssignments = new ArrayList<>();

    private boolean isCustomerAssigned(Customer customer) {
        for (RoomAssignment assignment : roomAssignments) {
            if (assignment.getCustomer().equals(customer)) {
                return true;
            }
        }
        return false;
    }

    private Room getRoomAssignedToCustomer(Customer customer) {
        for (RoomAssignment assignment : roomAssignments) {
            if (assignment.getCustomer().equals(customer)) {
                return assignment.getRoom();
            }
        }
        return null;
    }

    public boolean assignRoomToCustomer(Room room, Customer customer, Date checkInDate, Date checkOutDate) {
        if (isCustomerAssigned(customer)) {
            return false;
        }
        if (!room.isRoom_status()) {
            room.setRoom_status(true);
            RoomAssignment assignment = new RoomAssignment(room, customer, checkInDate, checkOutDate);
            roomAssignments.add(assignment);
            return true;
        } else {
            return false;
        }
    }

    public List<RoomAssignment> getAllRoomAssignments() {
        return new ArrayList<>(roomAssignments);
    }

    public void updateCheckoutDate(Customer customer, Date newCheckoutDate) {
        customer.setCheckOutDate(newCheckoutDate);
    }

    public static void writeToFile(ArrayList<Employee> employees) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.employeePath))) {
        for (Employee employee : employees) {
            writer.write(employee.getName() + "," + employee.getPhone() + "," + employee.getEmail() + "," + employee.getPassword() + "," + employee.getSalary());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static ArrayList<Employee> readFromFile() {
    ArrayList<Employee> employees = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(path.employeePath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                Employee employee = new Employee(parts[0], parts[1], parts[2], parts[3]);
                employee.setSalary(Double.parseDouble(parts[4]));
                employees.add(employee);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Employee file not found, creating a new one.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return employees;
}
}