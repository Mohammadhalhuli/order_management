package com.pokemonreview.api.repository;
import com.pokemonreview.api.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
