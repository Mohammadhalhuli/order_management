package com.pokemonreview.api.controllers;
import com.pokemonreview.api.dto.Orderdto;
import com.pokemonreview.api.models.Order;
import com.pokemonreview.api.service.impl.OrderDao;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
//@Api(value = "Order controller Rest api all Order")
@RequestMapping("/api/v1/Order_M")
@RestController
public class OrderController {
    /*
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    */
    @Autowired
    private OrderDao orderDao;
    //@ApiOperation(value = "Order controller REST API to add")
    @PostMapping("/add/customer/{id}")
    public ResponseEntity<Orderdto> createOrder( @RequestBody Orderdto orderDto, @PathVariable(name="id") Integer id){
        if(orderDto.getOrder_id()!=null){
            //log.error("Cannot have an ID {}" , orderDto);
        }
        return new ResponseEntity(orderDao.add(orderDto,id), HttpStatus.CREATED);
    }
    //@ApiOperation(value = "order controller REST API to edit order")
    @PutMapping("update/{order_id}")
    public ResponseEntity<Orderdto> update(@PathVariable(name="order_id") Integer order_id, @RequestBody Orderdto orderDto){
        return new ResponseEntity(orderDao.update(order_id,orderDto),HttpStatus.OK);
    }
    //@ApiOperation(value = "order controller REST API to delete order")
    @DeleteMapping("/delete/{order_id}")
    public ResponseEntity<String> deleteOrder(@PathVariable(name="order_id") Integer order_id){
        orderDao.delete(order_id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
    //@ApiOperation(value = "order controller REST API to get all order")
    @GetMapping("get")
    public ResponseEntity<List<Orderdto>> getAllOrders(){
        return ResponseEntity.ok().body(orderDao.get());
    }
    //@ApiOperation(value = "order controller REST API to get order by id")
    @GetMapping("get/{order_id}")
    public ResponseEntity<Orderdto> getOrderById(@PathVariable(name="order_id") Integer order_id){
        return ResponseEntity.ok().body(orderDao.getById(order_id));
    }
    /*
    public Orderdto add(@RequestBody Orderdto order){
        return this.orderDao.add(order);
    }/*
    @PutMapping("/{order_id}")
    public Order update(@PathVariable int order_id,@RequestBody Order order){
        order.setOrder_id(order_id);
        return this.orderDao.update(order);
    }
    @DeleteMapping("/delete/{order_id}")
    private String delete(@PathVariable int order_id){
        orderDao.deletebyid(order_id);
        return "Success";
    }
    @GetMapping(path = "/get")
    public List<Order> getSales() {
        return this.orderDao.getstock();
    }
    @GetMapping(path = "/{order_id}")
    public Optional<Order> getSaleByOrderId(@PathVariable  Integer order_id) {
        return this.orderDao.getstockByProductId(order_id);
    }*/
}
