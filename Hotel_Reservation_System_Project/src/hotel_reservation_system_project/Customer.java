package hotel_reservation_system_project;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;

public class Customer extends Person {
    private Date checkInDate;
    private Date checkOutDate;
    private int noOfRoomRequest;
    private Room RoomRequest;
    private static int noOfCustomers = 0;

    public Customer(String name, String email, String phone, String password) {
        super(name, email, phone, password);
        noOfCustomers++;
    }

    public Customer() {}

    public Customer(String name, String email, String phone, String password, Date checkInDate, Date checkOutDate, int noOfRoomRequest, Room RoomRequest) {
        super(name, email, phone, password);
        noOfCustomers++;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.noOfRoomRequest = noOfRoomRequest;
        this.RoomRequest = RoomRequest;
    }

    public void setCheckInDate(Date checkInDate) {
        this.checkInDate = checkInDate;
    }

    public void setCheckOutDate(Date checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date viewCheckOutDate() {
        return checkOutDate;
    }

    public Bill viewBill(Bill b1) {
        return b1;
    }

    public static int getnoOfCustomers() {
        return noOfCustomers;
    }

    public void requestRoom(int noOfRoom) {
        noOfRoomRequest = noOfRoom;
    }

    public void requestRoom(Room r1) {
        RoomRequest = r1;
    }

    public static void writeToFile(ArrayList<Customer> customers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.customerPath))) {
            for (Customer customer : customers) {
                writer.write(customer.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Customer> readFromFile() {
        ArrayList<Customer> customers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path.customerPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Customer customer = parseCustomer(line);
                if (customer != null) {
                    customers.add(customer);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Customer file not found, creating a new one.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customers;
    }

    private static Customer parseCustomer(String line) {
        String[] parts = line.split(",");
        if (parts.length == 4) {
            return new Customer(parts[0], parts[1], parts[2], parts[3]);
        }
        return null; // or handle the error as needed
    }

    @Override
    public String toString() {
        return getName() + "," + getEmail() + "," + getPhone() + "," + getPassword();
    }
}