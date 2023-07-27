package com.major.selftest11.controller;

import com.major.selftest11.model.User;
import com.major.selftest11.service.UserBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/users")
public class UsersController {

    @Autowired
    UserBusinessServiceInterface userBusinessServiceInterface;

    @GetMapping(path = "/")
    public String showAllUsers(Model model)
    {
        List<User> user = userBusinessServiceInterface.getAllEmployees();
        model.addAttribute("title","GGWP Employee Information");
        model.addAttribute("users", user);
        
        return "index";
    }
}
