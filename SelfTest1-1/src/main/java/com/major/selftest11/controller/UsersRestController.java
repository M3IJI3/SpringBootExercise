package com.major.selftest11.controller;

import com.major.selftest11.model.User;
import com.major.selftest11.service.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersRestController {

    @Autowired
    UserBusinessServiceInterface userBusinessServiceInterface;

    @GetMapping(path = "/")
    public List<User> showAllUsers()
    {
        List<User> user = userBusinessServiceInterface.getAllEmployees();
        return user;
    }

    @GetMapping(path = "/id/{id}")
    public User getByEmployeeID(@PathVariable(name = "id") long id)
    {
        return userBusinessServiceInterface.getByEmployeeID(id);
    }

    @PostMapping("/")
    public long addNewUser(@RequestBody User user){
        return userBusinessServiceInterface.addNewUser(user);
    }

    @GetMapping(path = "/delete/{id}")
    public boolean deleteUser(@PathVariable(name = "id") long id)
    {
        return userBusinessServiceInterface.deleteUser(id);
    }

    @PutMapping(path = "/update/{id}")
    public User updateUser(@PathVariable(name = "id") long id, @RequestBody User user)
    {
        return userBusinessServiceInterface.update(id, user);
    }
}
