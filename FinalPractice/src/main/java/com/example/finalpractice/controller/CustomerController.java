package com.example.finalpractice.controller;

import com.example.finalpractice.model.CustomerModel;
import com.example.finalpractice.service.CustomerBusinessService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Controller
@RequestMapping(path = "/index")
public class CustomerController {

    @Resource
    CustomerBusinessService customerBusinessService;

    @GetMapping(path = "/customer")
    public String showIndexPage(Model model){
        List<CustomerModel> customerModels = customerBusinessService.getAllCustomers();
        System.out.println(customerModels);
        model.addAttribute("customerModels", customerModels);
        return "index";
    }

    @GetMapping(path = "/form")
    public String showAddNewCustomerPage(Model model)
    {
        model.addAttribute("newCustomer", new CustomerModel());
        return "addNewCustomer";
    }

    @PostMapping(path = "/add")
    public String addNewCustomer(@Valid CustomerModel customerModel)
    {
        customerBusinessService.addCustomer(customerModel);
        return "redirect:/index/customer";
    }

    @GetMapping(path = "/editform")
    public String showEditPage(CustomerModel customerModel, Model model)
    {
        model.addAttribute("customerModel", customerModel);
        return "editCustomer";
    }

    @PostMapping(path = "/edit")
    public String editCustomer(CustomerModel customerModel)
    {
        customerBusinessService.updateCustomer(customerModel.getCustno(), customerModel);
        return "redirect:/index/customer";
    }

    @PostMapping(path = "/delete")
    public String deleteCustomer(CustomerModel customerModel)
    {
        customerBusinessService.deleteCustomer(customerModel);
        return "redirect:/index/customer";
    }

    @GetMapping(path = "/search")
    public String searchCustomer(Model model, @RequestParam(name = "keyword") String keyword)
    {
        List<CustomerModel> customerModels = customerBusinessService.getCustomerByName(keyword);
        model.addAttribute("customerModels", customerModels);
        return "index";
    }
}
