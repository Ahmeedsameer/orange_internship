package Orders;

import Vehicles.vehicle;

public class order {
    private vehicle vehicle;

    public order(vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void confirmOrder() {
        System.out.println("Vehicle reserved: " + vehicle.getRegisterationn_number());
        System.out.println("Total price: $" + vehicle.calculatePrice());
    }
}
