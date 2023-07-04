package com.pokemonreview.api.dto;

import com.pokemonreview.api.models.Product_Order;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Orderdto {
    private Integer order_id;
    @CreationTimestamp
    private LocalDateTime orderedAt;
    private List<Product_Order> product_order;
}
