import Vehicles.*;
import inventory.VehicleInventory;
import Orders.order;

import java.util.HashMap;
import java.util.Map;

 class VehicleOrderSystem {
    public static void main(String[] args) {
        VehicleInventory inventory = new VehicleInventory();


        Map<String, Object> carFeatures = new HashMap<>();
        carFeatures.put("sunroof", true);
        carFeatures.put("transmission", "Automatic");
        Car carr = new Car("ABC123", "Petrol", carFeatures);
        inventory.addvechicle(carr);
        Map<String, Object> truckFeatures = new HashMap<>();
        truckFeatures.put("cargoCapacity", 1500);
        truck truckk=new truck("XYZ789", "Diesel", truckFeatures);
        inventory.addvechicle(truckk);


        Map<String, Object> desiredCarFeatures = new HashMap<>();
        desiredCarFeatures.put("sunroof", true);
        desiredCarFeatures.put("transmission", "Automatic");

        if (inventory.checkavaliblity("Car", desiredCarFeatures)) {
            vehicle car = inventory.reversevehicle("Car", desiredCarFeatures);
            new order(car).confirmOrder();
        } else {
            System.out.println("No available vehicle matches your criteria.");
        }
        Map<String, Object> desiredTruckFeatures = new HashMap<>();
        desiredTruckFeatures.put("cargoCapacity", 1500);

        if (inventory.checkavaliblity("Truck", desiredTruckFeatures)) {
            vehicle truck = inventory.reversevehicle("Truck", desiredTruckFeatures);
            new order(truck).confirmOrder();
        } else {
            System.out.println("No available vehicle matches your criteria.");
        }
    }
}
