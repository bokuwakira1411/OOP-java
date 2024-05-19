package Transport;

public class Car extends MotorVehicle{
    private int numDoors;
    private String licensePlate, brand;
    public Car(String licensePlate, String brand, int numDoors){
        super();
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.numDoors = numDoors;
    }
    @Override
    public double getFuelComsumption() {
        return 8.5 / 100;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public double calculateMaintenanceCost(int distance) {
        return 0.05 * distance;
    }
}
