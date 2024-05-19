package Transport;
import java.util.ArrayList;
import java.util.List;
public class Test {
    public static void main(String[] args){
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle car = new Car("01234", "BMW", 2);
        Vehicle motor = new Motorcycle("12345", "Toyota", true);
        Vehicle car2 = new Car("02002", "wc", 4);
        Vehicle motor2 = new Motorcycle("0400", "BMW", true);
        car.setMileage(300);
        car2.setMileage(200);
        motor.setMileage(100);
        motor2.setMileage(400);
        vehicles.add(car);
        vehicles.add(motor);
        vehicles.add(car2);
        vehicles.add(motor2);
        System.out.println(car.getType());
    }
}
