package com.carbooking.booking;

import com.carbooking.car.Car;
import com.carbooking.car.CarDAO;
import com.carbooking.user.User;
import com.carbooking.user.UserDAO;

import java.util.UUID;

public class BookingService {

    public static User getUserById(UUID userId) {
        for (User user : UserDAO.getUsers()) {
            if (user.getId().equals(userId)) {
                return user;
            }
        }
        return null;
    }

    public static Car getCarByRegNumber(int carRegNumber) {
        for (Car car : CarDAO.getAvailableCars()) {
            if (car.getRegNumber() == carRegNumber && !car.isElectric()) {
                int index = -1;
                for (int i = 0; i < CarDAO.getAvailableCars().length; i++) {
                    if (CarDAO.getAvailableCars()[i].equals(car)) {
                        index = i;
                        break;
                    }
                }


                if (index != -1) {
                    // Shift elements to the left
                    for (int i = index; i < CarDAO.getAvailableCars().length - 1; i++) {
                        CarDAO.getAvailableCars()[i] = CarDAO.getAvailableCars()[i + 1];
                    }
                    Car[] newArray = new Car[CarDAO.getAvailableCars().length - 1];
                    System.arraycopy(CarDAO.getAvailableCars(), 0, newArray, 0, newArray.length);
                    CarDAO.setAvailableCars(newArray);

                }
                return car;
            }

            if(car.getRegNumber() == carRegNumber && car.isElectric()) {
                // Find the index of the element to remove
                int indexToRemove = -1;
                for (int i = 0; i < CarDAO.getAvailableElectricCars().length; i++) {
                    if (CarDAO.getAvailableElectricCars()[i] == car) {
                        indexToRemove = i;
                        break;
                    }
                }
                // If the element is found, remove it
                if (indexToRemove != -1) {
                    // Create a new array with a size one less than the original array
                    Car[] newArray = new Car[CarDAO.getAvailableElectricCars().length - 1];

                    // Copy elements from the original array to the new array, excluding the element to remove
                    for (int i = 0, j = 0; i < CarDAO.getAvailableElectricCars().length; i++) {
                        if (i != indexToRemove) {
                            newArray[j++] = CarDAO.getAvailableElectricCars()[i];
                        }
                    }

                    // Update any references to the original array with the new array
                    CarDAO.setAvailableElectricCars(newArray);
            }
            return car;
        }
    }
        return null;
    }
}
