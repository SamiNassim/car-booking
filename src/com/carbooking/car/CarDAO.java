package com.carbooking.car;

public class CarDAO {
   private static Car[] availableCars = {CarService.citroen, CarService.tesla, CarService.bmw};
   private static Car[] bookedCars = new Car[availableCars.length];
   private static Car[] availableElectricCars = {CarService.tesla};
   private static int count = 0;

   public static Car[] getAvailableCars() {
      return availableCars;
   }

   public static void setAvailableCars(Car[] availableCars) {
      CarDAO.availableCars = availableCars;
   }

   public static Car[] getBookedCars() {
      return bookedCars;
   }

   public static void setBookedCars(Car[] bookedCars) {
      CarDAO.bookedCars = bookedCars;
   }

   @Override
   public String toString() {
      return "CarDAO{}";
   }

   public static Car[] isElectric() {
      for (Car car : availableCars) {
      if (car.isElectric()) {
         availableElectricCars[count] = car;
         count++;
      }
      }

      return availableElectricCars;
   }



   public static Car[] getAvailableElectricCars() {
      return availableElectricCars;
   }

   public static void setAvailableElectricCars(Car[] availableElectricCars) {
      CarDAO.availableElectricCars = availableElectricCars;
   }
}
