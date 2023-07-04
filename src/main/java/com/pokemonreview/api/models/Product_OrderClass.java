package com.pokemonreview.api.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product_OrderClass implements Serializable {

    private Product prduct_id;
    private Order order_id;
}
