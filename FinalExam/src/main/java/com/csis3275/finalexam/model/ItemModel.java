package com.csis3275.finalexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemModel {
    private String catecode;
    private String Icode;
    private String Idesc;
    private float price;
}
