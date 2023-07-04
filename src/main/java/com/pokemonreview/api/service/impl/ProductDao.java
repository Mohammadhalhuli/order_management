package com.pokemonreview.api.service.impl;
import com.pokemonreview.api.dto.Productdto;
import com.pokemonreview.api.models.Product;
import com.pokemonreview.api.repository.ProductRepo;
import com.pokemonreview.api.service.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductDao {
    @Autowired
    private ProductRepo productRepo;
    private Productdto mapToDto(Product product){
        Productdto productDto = new Productdto();
        productDto.setPrduct_id(product.getPrduct_id());
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setReference(product.getReference());
        productDto.setSlug(product.getSlug());
        productDto.setStock(product.getStock());
        productDto.setStock(product.getStock());
        productDto.setVat(product.getVat());
        return productDto;
    }

    private Product mapToEntity(Productdto productDto){
        Product product=new Product();
        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStock(productDto.getStock());
        product.setVat(productDto.getVat());
        product.setStock(productDto.getStock());
        return product;
    }
    /*
    public Product add(Product product){
        log.info("product is is " + product.getPrduct_id());
      return this.productRepo.save(product);
    }*/
    public Productdto createProduct(Productdto producttto) {
        Product product = mapToEntity(producttto);
        productRepo.save(product);

        Productdto productttonew = mapToDto(product);
        return productttonew;
    }
/*
    public Product update(Product product){
        log.info("product is is " + product.getPrduct_id());
        return this.productRepo.save(product);
    }*/
    public Productdto update(Integer prduct_id, Productdto productDto) {
        Product product = productRepo.findById(prduct_id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", prduct_id));

        product.setName(productDto.getName());
        product.setPrice(productDto.getPrice());
        product.setReference(productDto.getReference());
        product.setSlug(productDto.getSlug());
        product.setStock(productDto.getStock());
        product.setVat(productDto.getVat());
        product.setStock(productDto.getStock());

        Product productnew = productRepo.save(product);

        return mapToDto(productnew);
    }
    /*
    public boolean deletebyid(int prduct_id){
        productRepo.deleteById(prduct_id);
        return true;
    }
     */
    public void delete(Integer prduct_id) {
        Product product = productRepo.findById(prduct_id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", prduct_id));
        productRepo.delete(product);
    }

    public List<Productdto> get() {
        List<Product> products = productRepo.findAll();
        return products.stream().map(product -> mapToDto(product)).collect(Collectors.toList());
    }


    public Productdto getById(Integer prduct_id) {
        Product product = productRepo.findById(prduct_id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", prduct_id));
        return mapToDto(product);
    }
}
