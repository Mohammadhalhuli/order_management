package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.Productdto;
import com.pokemonreview.api.service.impl.ProductDao;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//@Api(value = "product controller Rest api all product")
@RequestMapping("/api/v1/product")
@RestController
public class ProductController {
    @Autowired
    private ProductDao productDao;
   // @ApiOperation(value = "product controller REST API to add")
    @PostMapping("/add")
    //public Product add(@RequestBody Product product){return this.productDao.add(product);}
    public Productdto add( @RequestBody Productdto productdto){
        return  this.productDao.createProduct(productdto);
    }
    //@ApiOperation(value = "product controller REST API to edit product")
    @PutMapping("update/{prduct_id}")
    public ResponseEntity<Productdto> update(@RequestBody Productdto productDto, @PathVariable(name="prduct_id") Integer prduct_id){
        return new ResponseEntity(productDao.update(prduct_id,productDto), HttpStatus.OK);
    }
   /* public Product update(@PathVariable int prduct_id, @RequestBody Product product){
        product.setPrduct_id(prduct_id);
        return this.productDao.update(product);
    }*/
   //@ApiOperation(value = "product controller REST API to delete product")
    @DeleteMapping("delete/{prduct_id}")
    public ResponseEntity<String> delete(@PathVariable(name="prduct_id") Integer prduct_id){
        return new ResponseEntity("Deleted successfully",HttpStatus.OK);
    }
    /*private String delete(@PathVariable int prduct_id){
        productDao.deletebyid(prduct_id);
        return "Success";
    }*/
    //@ApiOperation(value = "product controller REST API to get all product")
    @GetMapping("get")
    public ResponseEntity<List<Productdto>> getAll(){
        return ResponseEntity.ok().body(productDao.get());
    }
    //@ApiOperation(value = "product controller REST API to get product by id")
    @GetMapping("get/{prduct_id}")
    public ResponseEntity<Productdto> getProductById(@PathVariable(name="prduct_id") Integer prduct_id){
        return ResponseEntity.ok().body(productDao.getById(prduct_id));
    }
}
