/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author handler
 */
public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equals("Bus")) {
            return new Bus();
        } else if (type.equals("Truck")) {
            return new Truck();
        }
        return null;
    }
}
