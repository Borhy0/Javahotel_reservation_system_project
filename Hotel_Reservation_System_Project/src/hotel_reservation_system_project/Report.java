package hotel_reservation_system_project;

import java.util.List;
import java.util.Date;

public class Report {

    public String generateRoomReport(List<Room> rooms) {
        StringBuilder report = new StringBuilder();
        int totalRooms = rooms.size();
        int availableRooms = 0;
        int occupiedRooms = 0;

        for (Room room : rooms) {
            if (room.isRoom_status()) {
                availableRooms++;
            } else {
                occupiedRooms++;
            }
        }

        report.append("Room Report:\n");
        report.append("Total Rooms: ").append(totalRooms).append("\n");
        report.append("Available Rooms: ").append(availableRooms).append("\n");
        report.append("Occupied Rooms: ").append(occupiedRooms).append("\n");

        report.append("\nRoom Details:\n");
        for (Room room : rooms) {
            report.append("Room No: ").append(room.getRoom_no()).append(", ");
            report.append("Type: ").append(room.getRoom_type()).append(", ");
            report.append("Status: ").append(room.isRoom_status() ? "Available" : "Occupied").append(", ");
            report.append("Service: ").append(room.getRoom_service()).append(", ");
            report.append("Price: ").append(room.getRoom_price()).append("\n");
        }
        return report.toString();
    }

    public String generateNearCheckoutReport(List<Customer> customers) {
        StringBuilder report = new StringBuilder();
        report.append("Near Checkout Report:\n");
        Date today = new Date();
        for (Customer customer : customers) {
            Date checkoutDate = customer.getCheckOutDate();
            long diffInMillies = checkoutDate.getTime() - today.getTime();
            long diffDays = diffInMillies / (1000 * 60 * 60 * 24);
            if (diffDays <= 2 && diffDays >= 0) {
                report.append("Customer: ").append(customer.getName()).append(", Checkout in: ").append(diffDays).append(" days\n");
            }
        }
        return report.toString();
    }
}
