package com.major.selftest11.service;

import com.major.selftest11.data.UsersDataAccessInterface;
import com.major.selftest11.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBusinessService implements UserBusinessServiceInterface{

    @Autowired
    UsersDataAccessInterface userDAO;

    @Override
    public List<User> getAllEmployees() {
        return userDAO.getAllEmployees();
    }

    @Override
    public User getByEmployeeID(long id) {
        return null;
    }

    @Override
    public List<User> searchUser(String searchTerm) {
        return null;
    }

    @Override
    public long addNewUser(User newUser) {
        return 0;
    }

    @Override
    public boolean deleteUser(long id) {
        return false;
    }

    @Override
    public User update(long id, User user) {
        return null;
    }
}
