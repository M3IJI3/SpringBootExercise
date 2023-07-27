package com.jiemei.controller;

import com.jiemei.model.OrderModel;
import com.jiemei.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    //dependency injection
    OrderBusinessServiceInterface service;

    // create a constructor of controller
    @Autowired
    public OrdersController(OrderBusinessServiceInterface service){
        super();
        this.service = service;
    }

    @GetMapping(path = "/")
    public String showAllOrders(Model model)
    {
        // generate some orders
        // this version of the app will send a hard-coded list of orders

        // we don't suggest using this way to invoke method
        // DEPENDENCY INJECTION IS HIGHLY RECOMMENDED
/**  OrderBusinessService orderBusinessService = new OrderBusinessService(); **/
        List<OrderModel> orders = service.getOrders();

        model.addAttribute("title", "Here is what i want to do this summer");
        model.addAttribute("orders", orders);

        return "orders";
    }
}
