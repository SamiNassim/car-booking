package com.carbooking.booking;

import com.carbooking.user.User;

public class BookingDAO {
    private static Booking[] bookings = new Booking[0];
    public static void addBooking(Booking booking) {
        Booking[] newBookings = new Booking[bookings.length + 1];
        System.arraycopy(bookings, 0, newBookings, 0, bookings.length);
        newBookings[newBookings.length - 1] = booking;
        setBookings(newBookings);
    }

    public static User getUserBookedCars(User user) {
        for (Booking booking : bookings) {
            if(user.equals(booking.getUser())) {
                return user;
            }
        }
        return null;
    }

    public static Booking[] getBookings() {
        if(bookings == null) {
            System.out.println("No bookings available");
        }
        return bookings;
    }

    public static void setBookings(Booking[] bookings) {
        BookingDAO.bookings = bookings;
    }
}
