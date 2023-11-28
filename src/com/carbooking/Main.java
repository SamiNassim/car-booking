package com.carbooking;

import com.carbooking.booking.Booking;
import com.carbooking.booking.BookingDAO;
import com.carbooking.booking.BookingService;
import com.carbooking.car.*;
import com.carbooking.user.User;
import com.carbooking.user.UserDAO;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    private static void terminalMenu() {
        System.out.println("1 - Book Car");
        System.out.println("2 - View All User Booked Cars");
        System.out.println("3 - View All Bookings");
        System.out.println("4 - View Available Cars");
        System.out.println("5 - View Available Electric Cars");
        System.out.println("6 - View All Users");
        System.out.println("7 - Exit");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        switch (input) {
            default:
                System.out.println("NOT A VALID OPTION !");
                System.out.println();
                terminalMenu();
                return;
            case 1:
                boolean foundCar = false;
                for (Car car : CarDAO.getAvailableCars()) {
                    System.out.println(car);
                }
                System.out.println("Select car reg number");
                int regInput = scanner.nextInt();
                for (int i = 0; i < CarDAO.getAvailableCars().length; i++) {
                    if (CarDAO.getAvailableCars()[i].getRegNumber() == regInput) {
                        foundCar = true;
                        for (User user : UserDAO.getUsers()) {
                            System.out.println(user);
                        }
                        System.out.println("Select UserID");
                        UUID userIdInput = UUID.fromString(scanner.next());
                        Booking booking = new Booking(UUID.randomUUID(), BookingService.getUserById(userIdInput), BookingService.getCarByRegNumber(regInput), LocalDateTime.now(), false);
                        BookingDAO.addBooking(booking);
                        System.out.println("Successfully booked car with reg number " + regInput + " for user " + userIdInput);
                        System.out.println("Booking ref: " + booking.getBookingId());

                    }
                }
                if (!foundCar) {
                    System.out.println("Car not found");
                }
                System.out.println();
                    terminalMenu();
                    return;
            case 2:
                for (User user : UserDAO.getUsers()) {
                    System.out.println(user);
                }
                System.out.println("Select userId");
                UUID userIdInputBookedCars = UUID.fromString(scanner.next());
                User userFound = BookingService.getUserById(userIdInputBookedCars);
                if(BookingDAO.getUserBookedCars(userFound) != null) {
                    System.out.println("This user " + userFound + " has booked cars.");
                } else {
                    System.out.println("This user " + userFound + " has no booked cars.");
                }
                System.out.println();
                terminalMenu();
                return;
            case 3:
                if(BookingDAO.getBookings().length == 0) {
                    System.out.println("No bookings available.");
                } else {
                    for (Booking bookingFound : BookingDAO.getBookings()) {
                        System.out.println(bookingFound);
                    }
                }
                System.out.println();
                terminalMenu();
                return;
            case 4:
                if(CarDAO.getAvailableCars().length == 0) {
                    System.out.println("No cars currently available.");
                } else {
                    for (Car car : CarDAO.getAvailableCars()) {
                    System.out.println(car);
                }
                }
                System.out.println();
                terminalMenu();
                return;
            case 5:
                boolean foundElectric = false;
                for (Car car : CarDAO.getAvailableCars()) {
                    if (car.isElectric()) {
                        System.out.println(car);
                        foundElectric = true;
                    }
                }
                if(!foundElectric) {
                    System.out.println("No electric cars available.");
                }
                System.out.println();
                terminalMenu();
                return;
            case 6:
                for (User user : UserDAO.getUsers()) {
                    System.out.println(user);
                }
                System.out.println();
                terminalMenu();
                return;
            case 7:
                break;
        }
    }

    public static void main(String[] args) {
        terminalMenu();
    }
}