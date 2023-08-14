package com.csis3275.finalexam.controller;

import com.csis3275.finalexam.model.ItemModel;
import com.csis3275.finalexam.model.SalesModel;
import com.csis3275.finalexam.service.ItemServiceInterface;
import com.csis3275.finalexam.service.SaleServiceInterface;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(path = "/")
public class BusinessController {

    @Resource
    ItemServiceInterface itemServiceInterface;

    @Resource
    SaleServiceInterface saleServiceInterface;

    @GetMapping(path = "index")
    public String showIndex(Model model)
    {
        model.addAttribute("newSale", new SalesModel());

        List<ItemModel> itemModelList = itemServiceInterface.getAllItems();
        model.addAttribute("itemModels", itemModelList);

        List<SalesModel> salesModelList = saleServiceInterface.getAllSales();
        model.addAttribute("saleModels", salesModelList);


        return "index";
    }


    @PostMapping(path = "save")
    public String saveItem(@RequestParam(name = "selectedItem") String Icode, @Valid SalesModel salesModel, HttpSession session)
    {
        salesModel.setIcode(Icode);

        saleServiceInterface.addNewSale(salesModel);

        return "redirect:/index";
    }

    @GetMapping(path = "edit")
    public String showEditPage(SalesModel salesModel, Model model)
    {
        model.addAttribute("salesModel", salesModel);
        return "edit";
    }


    @PostMapping(path = "delete")
    public String deleteRecord(SalesModel salesModel)
    {
        saleServiceInterface.removeRecord(salesModel);
        return "redirect:/index";
    }
}
