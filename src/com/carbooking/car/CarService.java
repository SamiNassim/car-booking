package com.carbooking.car;

public class CarService {
    public static Car bmw = new Car(504, 75, "BMW", false);
    public static Car tesla = new Car(320, 55, "Tesla", true);
    public static Car citroen = new Car(809, 40, "Peugeot", false);

    public static Car getBmw() {
        return bmw;
    }

    public static void setBmw(Car bmw) {
        CarService.bmw = bmw;
    }

    public static Car getTesla() {
        return tesla;
    }

    public static void setTesla(Car tesla) {
        CarService.tesla = tesla;
    }

    public static Car getCitroen() {
        return citroen;
    }

    public static void setCitroen(Car citroen) {
        CarService.citroen = citroen;
    }
}
