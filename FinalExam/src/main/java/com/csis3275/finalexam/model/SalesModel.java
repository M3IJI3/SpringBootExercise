package com.csis3275.finalexam.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalesModel {
    private long id;
    private int recno;
    private String icode;
    private double qty;
    private Date date;
}
