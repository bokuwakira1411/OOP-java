package Transport;

public interface Vehicle {
    void start();
    void stop();
    String getType();
    double calculateMaintenanceCost(int distance);
    public String getLicensePlate();
    public String getBrand();
    public int getMileage();
    public void setMileage(int mileage);
}
