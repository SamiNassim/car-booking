package com.carbooking.car;

public class CarDAO {
   private static Car[] availableCars = {CarService.citroen, CarService.tesla, CarService.bmw};
   public static Car[] getAvailableCars() {
      return availableCars;
   }
   public static void setAvailableCars(Car[] availableCars) {
      CarDAO.availableCars = availableCars;
   }
   @Override
   public String toString() {
      return "CarDAO{}";
   }

}
