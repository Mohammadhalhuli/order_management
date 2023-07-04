package com.pokemonreview.api.models;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Table(name = "Product")
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prduct_id")
    private Integer prduct_id;
    @Column(name = "slug")
    private String slug;
    @Column(name = "name")
    private String name;
    @Column(name = "reference")
    private String reference;
    @Column(name = "price")
    //private BigDecimal price;
    private Long price;
    @Column(name = "vat")
    //private BigDecimal vat;
    private Long vat;
    @Column(name = "stockable")
    private boolean stockable;
/*
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<Stock> stocks;
    @JsonBackReference
    @OneToMany(mappedBy = "product")
    private List<Product_Order> productOrders;*/
    @OneToMany(mappedBy = "prduct_id")
    private List<Product_Order> productId;
    @OneToMany(mappedBy = "prduct_id")
    private List<Stock> stock;
}
