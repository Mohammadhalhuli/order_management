package com.pokemonreview.api.dto;
import com.pokemonreview.api.models.Product_Order;
import com.pokemonreview.api.models.Stock;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class Productdto {
    private int prduct_id;
    private String slug;
    private String name;
    private String reference;
    //private BigDecimal price;
    //private BigDecimal vat;
    private Long price;
    private Long vat;
    private boolean stockable;
    private List<Stock> stock;
    private List<Product_Order> product_order;
}
