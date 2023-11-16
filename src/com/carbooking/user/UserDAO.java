package com.carbooking.user;

public class UserDAO {

    private static User[] users = {UserService.sofia, UserService.akim, UserService.ahmed, UserService.mehdi};

    public static User[] getUsers() {
        return users;
    }

    public static void setUsers(User[] users) {
        UserDAO.users = users;
    }

    @Override
    public String toString() {
        return "UserDAO{}";
    }
}
