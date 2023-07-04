package com.pokemonreview.api.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

//@Table(name = "Product_Order")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@IdClass(
        Product_OrderClass.class
)
public class Product_Order  {
/*
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "product_order_id")
   private int product_order_id;*/
    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="prduct_id" , referencedColumnName = "prduct_id")
    private Product prduct_id;

    @Id
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id" , referencedColumnName = "order_id")
    private Order order_id;

    @Column(name = "quantity")
    private int quantity;
    @Column(name = "price",precision = 10,scale = 2)
    private BigDecimal price;
    //private long price;
    @Column(name = "vat",precision = 10,scale = 2)
    private BigDecimal vat;
    //private long vat;

    /*@Column(name = "prduct_id")
    private int prduct_id;
    @Column(name = "order_id")
    private int order_id;*/
    /*
    //id product

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "prduct_id", insertable = false, updatable = false)
    private Product product;
    //id order

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private Order Order;*/




}
