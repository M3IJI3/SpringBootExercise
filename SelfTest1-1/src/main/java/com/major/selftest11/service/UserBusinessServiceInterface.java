package com.major.selftest11.service;

import com.major.selftest11.model.User;

import java.util.List;

public interface UserBusinessServiceInterface {
    List<User> getAllEmployees();
    User getByEmployeeID(long id);
    List<User> searchUser(String searchTerm);
    long addNewUser(User newUser);
    boolean deleteUser(long id);
    User update(long id, User user);
}
