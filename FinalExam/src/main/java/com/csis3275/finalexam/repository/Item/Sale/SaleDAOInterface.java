package com.csis3275.finalexam.repository.Item.Sale;

import java.util.List;

public interface SaleDAOInterface<T> {
    List<T> getAllSales();
    void addNewSale(T sale);
    void removeRecord(T sale);
}
