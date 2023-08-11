package com.jiemei.controller;

import com.jiemei.model.OrderModel;
import com.jiemei.model.SearchModel;
import com.jiemei.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    @GetMapping(path = "/showNewOrderForm")
    public String showNewOrderForm(Model model)
    {
        model.addAttribute("order", new OrderModel());
        return "addNewOrderForm";
    }

    @PostMapping(path = "/addNew")
    public String addNew(@Valid OrderModel newOrder, BindingResult bindingResult, Model model)
    {
        // processing here

        newOrder.setId(null);
        // 1. add to the database
        service.addOne(newOrder);
        // 2. get all orders from database
        List<OrderModel> orderModels = service.getOrders();
        // 3. show all orders page
        model.addAttribute("orders", orderModels);

        return "orders";
    }


    @GetMapping(path = "/showSearchForm")
    public String showSearchForm(Model model)
    {
        model.addAttribute("searchModel", new SearchModel());
        return "searchForm";
    }

    @PostMapping(path = "/search")
    public String search(@Valid SearchModel searchModel, BindingResult bindingResult, Model model)
    {
        String searchTerm = searchModel.getSearchTerm();
        List<OrderModel> orders = service.searchOrders(searchTerm);
        model.addAttribute("orders", orders);
        return "orders";
    }
}
