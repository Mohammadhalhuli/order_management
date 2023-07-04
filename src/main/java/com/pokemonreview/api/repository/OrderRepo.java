package com.pokemonreview.api.repository;


import com.pokemonreview.api.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order,Integer> {
}
