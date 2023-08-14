package com.csis3275.finalexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "items")
public class ItemEntity {
    @Id
    @Column(name = "Catcode")
    private String catecode;

    @Column(name = "Icode")
    private String Icode;

    @Column(name = "Idesc")
    private String Idesc;

    @Column(name = "Price")
    private float price;
}