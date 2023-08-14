package com.csis3275.finalexam.service;

import com.csis3275.finalexam.model.SalesModel;

import java.util.List;

public interface SaleServiceInterface {
    List<SalesModel> getAllSales();
    void addNewSale(SalesModel sale);

    void removeRecord(SalesModel sale);

    boolean receiptNumberCheck(SalesModel salesModel);
}
