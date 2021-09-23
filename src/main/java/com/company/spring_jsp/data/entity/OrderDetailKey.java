package com.company.spring_jsp.data.entity;

//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrderDetailKey implements Serializable {

    @Column(name = "order_id")
    private Integer orderIdKey;

    @Column(name = "product_id")
    private Integer productIdKey;

    public OrderDetailKey() {
    }

    @Override
    public String toString() {
        return "OrderDetailKey{" +
                "orderIdKey=" + orderIdKey +
                ", productIdKey=" + productIdKey +
                '}';
    }

}
