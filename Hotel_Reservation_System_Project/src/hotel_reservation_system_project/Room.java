package hotel_reservation_system_project;

import java.io.*;
import java.util.ArrayList;

public class Room {
    private int room_no;
    private String room_type;
    private boolean room_status;
    private int room_price;
    private String room_service;

    public Room(int roomNo, String roomType, boolean roomStatus, int roomPrice, String roomService) {
        this.room_no = roomNo;
        this.room_type = roomType;
        this.room_status = roomStatus;
        this.room_price = roomPrice;
        this.room_service = roomService;
    }

    public Room() {}

    public int getRoom_no() {
        return room_no;
    }

    public String getRoom_type() {
        return room_type;
    }

    public boolean isRoom_status() {
        return room_status;
    }

    public int getRoom_price() {
        return room_price;
    }

    public String getRoom_service() {
        return room_service;
    }

    public void setRoom_no(int room_no) {
        this.room_no = room_no;
    }

    public void setRoom_type(String room_type) {
        this.room_type = room_type;
    }

    public void setRoom_status(boolean room_status) {
        this.room_status = room_status;
    }

    public void setRoom_price(int room_price) {
        this.room_price = room_price;
    }

    public void setRoom_service(String room_service) {
        this.room_service = room_service;
    }

    // Method to write Room data to a file
    public static void writeToFile(ArrayList<Room> rooms) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.roomPath))) {
        for (Room room : rooms) {
            writer.write(room.getRoom_no() + "," + room.getRoom_type() + "," + room.isRoom_status() + "," + room.getRoom_price() + "," + room.getRoom_service());
            writer.newLine();
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static ArrayList<Room> readFromFile() {
    ArrayList<Room> rooms = new ArrayList<>();
    try (BufferedReader reader = new BufferedReader(new FileReader(path.roomPath))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                Room room = new Room(Integer.parseInt(parts[0]), parts[1], Boolean.parseBoolean(parts[2]), Integer.parseInt(parts[3]), parts[4]);
                rooms.add(room);
            }
        }
    } catch (FileNotFoundException e) {
        System.out.println("Room file not found, creating a new one.");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return rooms;
}
}