package com.pokemonreview.api.repository;

import com.pokemonreview.api.models.Product_Order;
import com.pokemonreview.api.models.Product_OrderClass;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Product_OrderRepo extends JpaRepository<Product_Order, Product_OrderClass> {

}
