package com.jiemei.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderModel {
    Long id;
    String orderNo;
    String productName;
    float price;
    int quantity;
}
