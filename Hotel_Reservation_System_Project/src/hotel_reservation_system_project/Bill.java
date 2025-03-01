package hotel_reservation_system_project;

public class Bill {
    private String[] serviceName;
    private float[] servicePrice;
    private double totalServicePrice;
    private float roomPrice;
    private double totalPrice = roomPrice + totalServicePrice;

    public void setServiceName(String[] serviceName) {
        this.serviceName = serviceName;
    }

    public void setServicePrice(float[] servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String[] getServiceName() {
        return serviceName;
    }

    public float[] getServicePrice() {
        return servicePrice;
    }

    public float getRoomPrice() {
        return roomPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}