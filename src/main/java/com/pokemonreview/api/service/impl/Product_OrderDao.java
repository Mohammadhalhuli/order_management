package com.pokemonreview.api.service.impl;


import com.pokemonreview.api.dto.Product_Orderdto;
import com.pokemonreview.api.models.*;
import com.pokemonreview.api.repository.CustomerRepo;
import com.pokemonreview.api.repository.OrderRepo;
import com.pokemonreview.api.repository.ProductRepo;
import com.pokemonreview.api.repository.Product_OrderRepo;
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
public class Product_OrderDao {
    @Autowired
    private Product_OrderRepo productOrderRepo;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CustomerRepo customerRepo;

    private Product_Orderdto mapToDto(Product_Order product_order){
        Product_Orderdto product_orderDto  =  new Product_Orderdto();
        /* Product_OrderClass product_orderclass = new Product_OrderClass(product_order.getPrduct_id(),
                product_order.getOrder_id());*/
        product_orderDto.setProduct_order_id(product_order.getProduct_order_id());
        product_orderDto.setPrice(product_order.getPrice());
        product_orderDto.setVat(product_order.getVat());
        product_orderDto.setQuantity(product_order.getQuantity());
        return product_orderDto;
    }

    private Product_Order mapToEntity(Product_Orderdto product_orderDto){
        Product_Order product_order = new Product_Order();
        product_order.setPrice(product_orderDto.getPrice());
        product_order.setQuantity(product_orderDto.getQuantity());
        product_order.setVat(product_orderDto.getVat());
        return product_order;
    }
    public Product_Orderdto add(Product_Orderdto product_orderDto, Integer prduct_id, Integer order_id) {
        Product_Order product_order = mapToEntity(product_orderDto);
        Product product=productRepo.findById(prduct_id).orElseThrow(()
                -> new ResourceNotFoundException("Product", "prduct_id", prduct_id));
        Order order=orderRepo.findById(order_id).orElseThrow(()
                -> new ResourceNotFoundException("Order", "order_id", order_id));
        product_order.setPrduct_id(product);
        product_order.setOrder_id(order);

        /*Product product = productRepo.findById(prduct_id).orElseThrow(() -> new ResourceNotFoundException("Product", "prduct_id", prduct_id));
        Order order = orderRepo.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order", "order_id", order_id));
        product_order.setPrduct_id(product);
        product_order.setOrder_id(order);*/

        Product_Order product_ordernew = productOrderRepo.save(product_order);
        return mapToDto(product_ordernew);

    }
    public Product_Orderdto update(Integer product_order_id, Product_Orderdto Product_Orderdto) {
      /*  Product product=productRepo.findById(prduct_id).orElseThrow(()
                -> new ResourceNotFoundException("Product", "prduct_id", prduct_id));
        Order order=orderRepo.findById(order_id).orElseThrow(()
                -> new ResourceNotFoundException("Order", "order_id", order_id));
*/
        Product_Order product_order = productOrderRepo.findById(product_order_id).orElseThrow(()
                -> new ResourceNotFoundException("product_order", "product_order_id", product_order_id));
        product_order.setVat(Product_Orderdto.getVat());
        product_order.setPrice(Product_Orderdto.getPrice());
        product_order.setQuantity(Product_Orderdto.getQuantity());

        return mapToDto(product_order);
    }


    public void delete(Integer product_order_id) {
        Product_Order product_order = productOrderRepo.findById(product_order_id).orElseThrow(()
                -> new ResourceNotFoundException("product_order", "product_order_id", product_order_id));
        productOrderRepo.delete(product_order);
    }
    public List<Product_Orderdto> get() {
        List<Product_Order> product_orders = productOrderRepo.findAll();
        return product_orders.stream().map(product_order -> mapToDto(product_order)).collect(Collectors.toList());
    }


    public Product_Orderdto getById(Integer product_order_id) {
        //Product product = productRepo.findById(prduct_id).orElseThrow(() -> new ResourceNotFoundException("Product", "prduct_id", prduct_id));
        //Order order = orderRepo.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order", "order_id", order_id));
        Product_Order product_order = productOrderRepo.findById(product_order_id).orElseThrow(()
                -> new ResourceNotFoundException("product_order", "product_order_id", product_order_id));
        return mapToDto(product_order);
    }
    /*
    public Product_Order add(Product_Order productOrder){
        //log.info("productOrder is is " + productOrder.getProduct_order_id());
        return this.productOrderRepo.save(productOrder);
    }
    public Product_Order update(Product_Order productOrder){
        //log.info("productOrder is is " + productOrder.getProduct_order_id());
        return this.productOrderRepo.save(productOrder);
    }

    public boolean deletebyid(int productOrder_id){
        productOrderRepo.deleteById(productOrder_id);
        return true;
    }
    public List<Product_Order> get(){
        return this.productOrderRepo.findAll();
    }
    public Optional<Product_Order> getId(Integer prduct_id){
        return this.productOrderRepo.findById(prduct_id);
    }*/

}
