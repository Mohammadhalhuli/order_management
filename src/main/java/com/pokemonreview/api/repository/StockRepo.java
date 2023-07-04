package com.pokemonreview.api.repository;
import com.pokemonreview.api.models.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StockRepo extends JpaRepository<Stock,Integer> {
   // List<Stock> findallByproductId(Integer prduct_id);
}
