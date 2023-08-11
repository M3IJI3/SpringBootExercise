package com.example.finalpractice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {
    private String custno;
    private String custname;
    private double custdep;
    private int nyears;
    private String savtype;
}
