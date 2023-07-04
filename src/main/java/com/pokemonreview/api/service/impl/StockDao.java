package com.pokemonreview.api.service.impl;
import com.pokemonreview.api.dto.Stockdto;
import com.pokemonreview.api.models.Product;
import com.pokemonreview.api.models.Stock;
import com.pokemonreview.api.repository.ProductRepo;
import com.pokemonreview.api.repository.StockRepo;
import com.pokemonreview.api.service.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StockDao {
    @Autowired
    private StockRepo stockRepo;
    @Autowired
    private ProductRepo productRepo;

    private Stockdto mapToDto(Stock stock){
        Stockdto stockDto = new Stockdto();
        stockDto.setStock_id(stock.getStock_id());
        stockDto.setQuantity(stock.getQuantity());
        stockDto.setUpdatedAt(stock.getUpdatedAt());
        return stockDto;
    }

    private Stock mapToEntity(Stockdto stockdto){
        Stock stock = new Stock();
        stock.setQuantity(stockdto.getQuantity());
        stock.setUpdatedAt(stockdto.getUpdatedAt());
        return stock;
    }
    public Stockdto add(Stockdto stockDto, Integer prduct_id) {
        Stock stock = mapToEntity(stockDto);
        Product product = productRepo.findById(prduct_id).orElseThrow();
        stock.setPrduct_id(product);

        Stock stocknew = stockRepo.save(stock);
        return mapToDto(stocknew);
    }
    public void delete(Integer stock_id) {
        Stock stock = stockRepo.findById(stock_id).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stock_id));
        stockRepo.delete(stock);
    }
    public Stockdto update(Integer stock_id, Stockdto stockDto) {
        Stock stock = stockRepo.findById(stock_id).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stock_id));
        stock.setQuantity(stockDto.getQuantity());
        stock.setUpdatedAt(stockDto.getUpdatedAt());

        Stock stocknew = stockRepo.save(stock);
        return mapToDto(stocknew);
    }
    public List<Stockdto> getAllStock() {
        List<Stock> stocks = stockRepo.findAll();
        return stocks.stream().map(stock -> mapToDto(stock)).collect(Collectors.toList());
    }


    public Stockdto getStockById(Integer stock_id) {
        Stock stock = stockRepo.findById(stock_id).orElseThrow(() -> new ResourceNotFoundException("Stock", "id", stock_id));
        return mapToDto(stock);
    }
/*
    public StockDao(StockRepo stockRepo) {
        this.stockRepo = stockRepo;
    }*/

    //public Stock add(Stock stock){log.info("stock is is " + stock.getStock_id());return this.stockRepo.save(stock);}
    //public Stock update(Stock stock){log.info("stock is is " + stock.getStock_id());return this.stockRepo.save(stock);}
    //public boolean deletebyid(int stock_id){stockRepo.deleteById(stock_id);return true;}
    //public List<Stock> getstock(){return this.stockRepo.findAll();}
    //public Optional<Stock> getstockByProductId(Integer prduct_id){return this.stockRepo.findById(prduct_id);}
}
