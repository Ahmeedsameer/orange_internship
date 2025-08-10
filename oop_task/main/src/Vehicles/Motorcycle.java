package Vehicles;

import java.util.Map;

public class Motorcycle extends vehicle{
    public Motorcycle (String registrationNumber, String fuelType, Map<String, Object> features) {
        super("Motorcycle", fuelType, registrationNumber, true, features);

    }


    @Override
    public double calculatePrice() {
        return 30 ;
    }

    @Override
    public String gettype() {
        return " motorcycle";
    }
}
