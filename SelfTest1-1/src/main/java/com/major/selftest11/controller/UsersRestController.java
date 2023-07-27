package com.major.selftest11.controller;

import com.major.selftest11.model.User;
import com.major.selftest11.service.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/users")
public class UsersRestController {

    @Autowired
    UserBusinessServiceInterface userBusinessServiceInterface;

    @GetMapping(path = "/")
    public List<User> showAllUsers(Model model)
    {
        List<User> user = userBusinessServiceInterface.getAllEmployees();
        return user;
    }
}
