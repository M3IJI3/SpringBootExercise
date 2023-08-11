package com.jiemei.controller;

import com.jiemei.model.OrderModel;
import com.jiemei.services.OrderBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/orders")
public class OrderRestController {
    //dependency injection
    OrderBusinessServiceInterface service;

    // create a constructor of controller
    @Autowired
    public OrderRestController(OrderBusinessServiceInterface service){
        super();
        this.service = service;
    }

    @GetMapping(path = "/")
    public List<OrderModel> showAllOrders()
    {
        List<OrderModel> orders = service.getOrders();
        return orders;
    }

    @GetMapping(path = "/search/{searchTerm}")
    public List<OrderModel> searchOrder(@PathVariable(name = "searchTerm") String searchTerm)
    {
        List<OrderModel> orders = service.searchOrders(searchTerm);
        return orders;
    }

    @PostMapping(path = "/")
    public long addOne(@RequestBody OrderModel orderModel)
    {
        return service.addOne(orderModel);
    }

    @GetMapping(path = "/id/{id}")
    public OrderModel getById(@PathVariable(name = "id") long id)
    {
        return service.getById(id);
    }

    @GetMapping(path = "/delete/{id}")
    public boolean deleteOne(@PathVariable(name = "id") long id)
    {
        return service.deleteOne(id);
    }

    @PutMapping(path = "/update/{id}")
    public OrderModel updateOne(@RequestBody OrderModel object, @PathVariable(name = "id") long id)
    {
        return service.updateOne(id, object);
    }
}
