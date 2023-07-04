package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.Product_Orderdto;
import com.pokemonreview.api.models.Product_Order;
import com.pokemonreview.api.service.impl.Product_OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@Tag(name = "product_order controller Rest api all product_order")
@RequestMapping( "/api/v1/product_order")
@RestController
public class Product_OrderController {
    /*
    public Product_OrderController(Product_OrderDao product_orderDao) {
        this.product_orderDao = product_orderDao;
    }
*/
    @Autowired

    private Product_OrderDao product_orderDao;
    //@Operation (description = "product_order controller REST API to add")
    @PostMapping("product/{prduct_id}/order/{order_id}")
    public ResponseEntity<Product_Orderdto> add(@PathVariable(name="prduct_id")Integer prduct_id
            , @PathVariable(name="order_id")Integer order_id, @RequestBody Product_Orderdto Product_Orderdto){
        return new ResponseEntity(product_orderDao.add(Product_Orderdto,prduct_id,order_id), HttpStatus.CREATED);
    }
    //@Operation(description = "product_order controller REST API to edit product_order")
    @PutMapping("update/product/{prduct_id}/order/{oid}")
    public ResponseEntity<Product_Orderdto> update(@PathVariable(name="product_order_id") Integer product_order_id
            ,  @RequestBody Product_Orderdto Product_Orderdto){
        return new ResponseEntity(product_orderDao.update(product_order_id,Product_Orderdto),HttpStatus.OK);
    }

   // @Operation(description = "product_order controller REST API to product_order customer")
    @DeleteMapping("delete/{product_order_id}")
    public ResponseEntity<String> delete(@PathVariable(name="product_order_id")Integer product_order_id){
        product_orderDao.delete(product_order_id);
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
   // @Operation(description = "product_order controller REST API to get all product_order")
    @GetMapping("get")
    public ResponseEntity<List<Product_Orderdto>> getAllProduct_orders(){
        return ResponseEntity.ok().body(product_orderDao.get());
    }

    //@Operation(description = "product_order controller REST API to get product_order by id")
    @GetMapping("get/{product_order_id}")
    public ResponseEntity<Product_Orderdto> getProduct_orderById(@PathVariable(name="Integer product_order_id")Integer  product_order_id){
        return  ResponseEntity.ok().body(product_orderDao.getById(product_order_id));
    }

/*
        @PostMapping(value = "/add",produces = { MediaType.APPLICATION_JSON_VALUE })
        public Product_Order add(@RequestBody Product_Order productOrder){

            return this.product_orderDao.add(productOrder);
        }
        @PutMapping("/{product_order_id}")
        public Product_Order update(@PathVariable int product_order_id,@RequestBody Product_Order productOrder){
            //productOrder.setProduct_order_id(product_order_id);
            return this.product_orderDao.update(productOrder);
        }

        @DeleteMapping("/delete/{product_order_id}")
        private String delete(@PathVariable int product_order_id){
            product_orderDao.deletebyid(product_order_id);
            return "Success";
        }

        @GetMapping(path = "/get")
        public List<Product_Order> getSales() {
            return this.product_orderDao.get();
        }
        @GetMapping(path = "/{product_order_id}")
        public Optional<Product_Order> getSaleByOrderId(@PathVariable  Integer product_order_id) {
            return this.product_orderDao.getId(product_order_id);
        }*/
}
