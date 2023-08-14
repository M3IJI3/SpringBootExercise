package com.csis3275.finalexam.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "sales")
public class SalesEntity {
    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "recno")
    private int recno;

    @Column(name = "icode")
    private String icode;

    @Column(name = "qty")
    private double qty;

    @Column(name = "dot")
    private Date date;
}
