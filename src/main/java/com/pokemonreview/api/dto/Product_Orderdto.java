package com.pokemonreview.api.dto;
import com.pokemonreview.api.models.Product_OrderClass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.math.BigDecimal;

//@Getter
//@Setter
@Data
public class Product_Orderdto {
    //private int product_order_id;
    private Product_OrderClass productOrderClass;
    private int quantity;
    @Column(precision = 10,scale = 2)
    private BigDecimal price;
    @Column(precision = 10,scale = 2)
    private BigDecimal vat;
    //private int prduct_id;
   //private int order_id;
}
