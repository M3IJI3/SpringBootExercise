package com.jiemei.controllers;

import com.jiemei.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloWorldController {
    // return a string from a specific url, for example,
    // /test1
    @GetMapping("/test1")
    @ResponseBody
    public String printHello()
    {
        return "Hello World!";
    }

    @GetMapping("/test2")
    public String showHelloPage(Model model)
    {
        model.addAttribute("message", "Have a great day!");
        model.addAttribute("rating", 99);
        model.addAttribute("report", "Some great news from the station.");
        return "helloPage";
    }

    @GetMapping(path = "/test3")
    public ModelAndView printHelloAgain()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("message", "Have a super day!");
        modelAndView.addObject("rating", 55);
        modelAndView.setViewName("helloPage");
        return modelAndView;
    }

    @GetMapping("/test4")
    public String showHelloPage4(@RequestParam("message") String message, Model model)
    {
//        model.addAttribute("message", "Have a great day!");
        model.addAttribute("message", message);
        model.addAttribute("rating", 99);
        model.addAttribute("report", "Some great news from the station.");
        return "helloPage";
    }

    @GetMapping("/people")
    public String showFriends(Model model)
    {
        List<Person> friends = new ArrayList<>();

        friends.add(new Person(0, "Allan", 23, 140.2f));
        friends.add(new Person(1, "George", 21, 139.3f));
        friends.add(new Person(2, "Aiden", 25, 120.1f));
        friends.add(new Person(3, "Oscar", 26, 136.5f));
        friends.add(new Person(4, "Major", 30, 148.2f));
        friends.add(new Person(5, "Shawn", 18, 151.7f));

        System.out.println(friends);
        model.addAttribute("people", friends);
        return "index.html";
    }

    @GetMapping("/peopleJSON")
    @ResponseBody
    public List<Person> showFriendsJSON(Model model)
    {
        List<Person> friends = new ArrayList<>();

        friends.add(new Person(0, "Allan", 23, 140.2f));
        friends.add(new Person(1, "George", 21, 139.3f));
        friends.add(new Person(2, "Aiden", 25, 120.1f));
        friends.add(new Person(3, "Oscar", 26, 136.5f));
        friends.add(new Person(4, "Major", 30, 148.2f));
        friends.add(new Person(5, "Shawn", 18, 151.7f));

//        System.out.println(friends);
        model.addAttribute("people", friends);
        return friends;
    }
}
