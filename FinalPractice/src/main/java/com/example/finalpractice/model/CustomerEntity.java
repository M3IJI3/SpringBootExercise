package com.example.finalpractice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "savingstable")
public class CustomerEntity {
    @Id
    @Column(name = "custno")
    private String custno;
    @Column(name = "custname")
    private String custname;
    @Column(name = "cdep")
    private double custdep;
    @Column(name = "nyears")
    private int nyears;
    @Column(name = "savtype")
    private String savtype;
}
