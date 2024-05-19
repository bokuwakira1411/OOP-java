package Transport;

public abstract class MotorVehicle implements Vehicle{
    private String licensePlate, brand;
    private int mileage;
    public void start(){
        System.out.println("Vehicle " + brand + " is starting.");
    }
    public void stop(){
        System.out.println("Vehicle " + brand + " is stopping.");
    }
    public abstract double getFuelComsumption();
    public void drive(int distance){
        distance++;
    }
    @Override
    public String getLicensePlate(){
        return licensePlate;
    }
    @Override
    public String getBrand(){
        return brand;
    }
    @Override
    public int getMileage(){
        return mileage;
    }
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
}
