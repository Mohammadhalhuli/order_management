package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.Stockdto;
import com.pokemonreview.api.models.Stock;
import com.pokemonreview.api.service.impl.StockDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@Tag(name = "stock controller Rest api all stock")
@RequestMapping( "/api/v1/stock")
@RestController
public class StockController {
    @Autowired
    private StockDao stockDao;
    //@Operation(description = "stock controller REST API to add")
    @PostMapping("/add/product/{prduct_id}")
    public ResponseEntity<Stockdto> createStock(@PathVariable(name="prduct_id") Integer prduct_id,
                                                @RequestBody Stockdto stockDto){

        return new ResponseEntity(stockDao.add(stockDto,prduct_id), HttpStatus.CREATED);
    }
   // public Stock add(@RequestBody Stock stock){return this.stockDao.add(stock);}
   //@Operation(description = "Stock controller REST API to edit stock")
    @PutMapping("update/{stock_id}")
    public ResponseEntity<Stockdto> updateStock(@PathVariable(name="stock_id") Integer stock_id, Stockdto stockdto){
        return new ResponseEntity(stockDao.update(stock_id,stockdto),HttpStatus.OK);
    }
    //public Stock update(@PathVariable int stock_id,@RequestBody Stock stock){stock.setStock_id(stock_id);return this.stockDao.update(stock);}
    //@Operation(description = "stock controller REST API to delete stock")
    @DeleteMapping("/delete/{stock_id}")
    public ResponseEntity<String> deleteStock(@PathVariable(name="stock_id")Integer stock_id){
        stockDao.delete(stock_id);
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
    //private String delete(@PathVariable int stock_id){stockDao.deletebyid(stock_id);return "Success";}
    //@Operation(description = "stock controller REST API to get all stock")
    @GetMapping(path = "/get")
    public ResponseEntity<List<Stockdto>> getAllStocks(){
        return ResponseEntity.ok().body(stockDao.getAllStock());
    }
    //public List<Stock> getSales() {return this.stockDao.getstock();}
    //@Operation(description = "stock controller REST API to get stock by id")
    @GetMapping(path = "get/{stock_id}")
    public ResponseEntity<Stockdto> getStockById(@PathVariable(name="stock_id") Integer stock_id){

        return ResponseEntity.ok().body(stockDao.getStockById(stock_id));
    }
    //public Optional<Stock> getSaleByOrderId(@PathVariable  Integer stock_id) {return this.stockDao.getstockByProductId(stock_id);}
}
