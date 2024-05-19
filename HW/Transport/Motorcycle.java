package Transport;

public class Motorcycle extends MotorVehicle{
    private String licensePlate, brand;
    private boolean hasSideCar;
    public Motorcycle(String licensePlate, String brand, boolean hasSideCar){
        super();
        this.hasSideCar = hasSideCar;
    }
    @Override
    public double getFuelComsumption() {
        return 3.5/100;
    }

    @Override
    public String getType() {
        return "Motorcycle";
    }

    @Override
    public double calculateMaintenanceCost(int distance) {
        return 0.03 * distance;
    }

}
