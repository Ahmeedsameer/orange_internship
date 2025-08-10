package inventory;

import Vehicles.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class VehicleInventory {
private List<vehicle> vehicles=new ArrayList<>();
public void addvechicle(vehicle vehicle){
    vehicles.add(vehicle);
}
public Boolean checkavaliblity(String type , Map<String,Object>desired_feature){
    for (vehicle vehicle:vehicles){
        if (vehicle.gettype().equalsIgnoreCase(type) &&vehicle.isIs_Available()){
            boolean matches=true;

            for (String key:desired_feature.keySet()){
                if (!vehicle.getFeatures().containsKey(key)||!vehicle.getFeatures().get(key).equals(desired_feature.get(key))){
                     matches=false;
                     break;
                }
            }
            if (matches){
                return true;
            }
        }
    }
//    System.out.println("Looking for type: " + type);
//    System.out.println("Desired features: " + desired_feature);
//    for (vehicle v : vehicles) {
//        System.out.println("Checking vehicle: " + v.getVechiltype() + " | " + v.getRegisterationn_number());
//        System.out.println("Vehicle features: " + v.getFeatures());
//    }

    return false;
}
   public vehicle reversevehicle(String type,Map<String,Object>desiredFeatures) {
       for (vehicle vehicle : vehicles) {
           if (vehicle.gettype().equalsIgnoreCase(type) && vehicle.isIs_Available()) {
               boolean matches = true;
               for (String key : desiredFeatures.keySet()) {
                   if (!vehicle.getFeatures().containsKey(key) || !vehicle.getFeatures().get(key).equals(desiredFeatures.get(key))) {
                       matches = false;
                       break;
                   }
               }
               if (matches) {
                   vehicle.setIs_Available(false);
                   return vehicle;
               }
           }

       }
       return null;
   }
}