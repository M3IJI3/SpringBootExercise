package com.csis3275.finalexam.service;

import com.csis3275.finalexam.model.SalesModel;
import com.csis3275.finalexam.repository.Item.Sale.SaleDAOInterface;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements SaleServiceInterface {

    @Resource
    SaleDAOInterface<SalesModel> salesModelSaleDAOInterface;

    @Override
    public List<SalesModel> getAllSales() {
        return salesModelSaleDAOInterface.getAllSales();
    }

    @Override
    public void addNewSale(SalesModel sale) {
        salesModelSaleDAOInterface.addNewSale(sale);
    }

    @Override
    public void removeRecord(SalesModel sale) {
        salesModelSaleDAOInterface.removeRecord(sale);
    }

    @Override
    public boolean receiptNumberCheck(SalesModel salesModel) {
        List<SalesModel> salesModels = salesModelSaleDAOInterface.getAllSales();
        for(int i = 0 ; i < salesModels.size() ; i++)
        {
            if(salesModels.get(i).getRecno() == salesModel.getRecno())
            {
                return false;
            }
        }
        return true;
    }
}
