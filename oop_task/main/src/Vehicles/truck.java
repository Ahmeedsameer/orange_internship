package Vehicles;

import java.util.Map;

public class truck extends vehicle{
    public truck(String registrationNumber, String fuelType, Map<String, Object> features) {
        super("Truck", fuelType, registrationNumber, true, features);
    }


    @Override
    public double calculatePrice() {
        double base_price =80 ;
        if (getFeatures().containsKey("cargoCapacity")){
            base_price+=((int) getFeatures().get("cargoCapacity")*0.5);
        }
        return base_price;
    }

    @Override
    public String gettype() {
        return "Truck";
    }
}
