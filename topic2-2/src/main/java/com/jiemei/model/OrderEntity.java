package com.jiemei.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("ORDERS")
public class OrderEntity {
    @Id
    @Column("ID")
    Long id;

    @Column("ORDER_NUMBER")
    String orderNo;

    @Column("PRODUCT_NAME")
    String productName;

    @Column("PRICE")
    float price;

    @Column("QTY")
    int quantity;
}
