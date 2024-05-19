package Transport;

import java.util.ArrayList;
import java.util.List;

public class FleetManagement {
    private static List<Vehicle> vehicles = new ArrayList<>() ;
    public FleetManagement(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }
    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);
    }
    public void removeVehicle(String licensePlate){
        for(Vehicle vehicle: vehicles){
           if(vehicle.getLicensePlate() == "licensePlate"){
               vehicles.remove(vehicle);
           }
        }
    }
    public Vehicle findVehicleByLicensePlate(String licensePlate) {
        Vehicle a = null;
        try {
            for (Vehicle vehicle : vehicles) {
                if (vehicle.getLicensePlate() == licensePlate) {
                    a = vehicle;
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return a;
    }
    public int getTotalMileage(){
        int totalDistance = 0;
        for(Vehicle vehicle: vehicles){
            totalDistance += vehicle.getMileage();
        }
        return totalDistance;
    }
    public double calculateTotalMaintenanceCost(int distance){
            double totalMaintenanceCost = 0;
            for(Vehicle vehicle: vehicles){
                totalMaintenanceCost += vehicle.calculateMaintenanceCost(distance);
            }
            return totalMaintenanceCost;
        }
        public List<Vehicle> sortVehiclesByMileage(){
            quickSort(0, vehicles.size());
            return vehicles;
        }
        public Vehicle findVehicleWithMaxMileage(){
            List<Vehicle> sortedVehicles = sortVehiclesByMileage();
            return sortedVehicles.get(0);
        }
        public void sort2(){
            List<Vehicle> vehicles2 = new ArrayList<>();
            vehicles2 = sortVehiclesByMileage();
            for(int i = 0; i < vehicles2.size() - 1; i++){
                if(check(vehicles2.get(i), vehicles2.get(i + 1))){
                    swap(i, i + 1);
                }
            }
        }
        private boolean checkString(String a, String b) {
            if(a == b) return true;
            for (int i = 0; i < a.length(); i++) {
                if (a.charAt(i) > b.charAt(i)) {
                    return true;
                }
            }
            return false;
        }
        private boolean check(Vehicle a, Vehicle b){
        return a.getMileage() > b.getMileage() && (checkString(a.getBrand(), b.getBrand()));
        }
    private static void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private static int partition(int low, int high) {
        double pivot = vehicles.get(high).getMileage();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (vehicles.get(j).getMileage() > pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, high);
        return i + 1;
    }

    private static void swap(int i, int j) {
        int temp = vehicles.get(i).getMileage();
        vehicles.get(i).setMileage(vehicles.get(j).getMileage());
        vehicles.get(j).setMileage(temp);
    }


}
