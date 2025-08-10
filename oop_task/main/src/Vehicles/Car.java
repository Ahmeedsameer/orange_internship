package Vehicles;

import java.util.Map;

public class Car extends vehicle{

    public Car(String registrationNumber, String fuelType, Map<String, Object> features) {
        super("Car", fuelType, registrationNumber, true, features);
    }


    @Override
    public double calculatePrice() {
        double base_price=50;
        if (getFeatures().containsKey("sunroof") && (Boolean) getFeatures().get("sunroof")) {
            base_price += 10;
        }
        return base_price;
    }

    @Override
    public String gettype() {
        return "car";
    }
}
