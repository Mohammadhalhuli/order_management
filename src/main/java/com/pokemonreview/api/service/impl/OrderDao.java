package com.pokemonreview.api.service.impl;


import com.pokemonreview.api.dto.Orderdto;
import com.pokemonreview.api.models.Customer;
import com.pokemonreview.api.models.Order;
import com.pokemonreview.api.repository.CustomerRepo;
import com.pokemonreview.api.repository.OrderRepo;
import com.pokemonreview.api.service.OrderServers;
import com.pokemonreview.api.service.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderDao implements OrderServers {
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private CustomerRepo customerRepo;
    private Orderdto mapToDto(Order order){
        Orderdto orderDto = new Orderdto();
        orderDto.setOrder_id(order.getOrder_id());
        //orderDto.setProduct_order(order.getProduct_order());
        orderDto.setOrderedAt(order.getOrderedAt());
        return orderDto;
    }

    private Order mapToEntity(Orderdto orderDto){
        Order order = new Order();
        // order.setProduct_order(orderDto.getProduct_order());
        order.setOrderedAt(orderDto.getOrderedAt());
        return order;
    }
/*
    public Order add(Order order){
        log.info("order is is " + order.getOrder_id());
        return this.orderRepo.save(order);
    }*/

    @Override
    public Orderdto add(Orderdto orderDto, Integer customerId) {
        Order order = mapToEntity(orderDto);
        Customer customer = customerRepo.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", customerId));
        order.setCustomer_id(customer);

        Order order1 =  orderRepo.save(order);
        return mapToDto(order1);
    }
    public Orderdto getById(Integer order_id) {
        Order order = orderRepo.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", order_id));
        return mapToDto(order);
    }
    public void delete(Integer order_id) {
        Order order = orderRepo.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", order_id));
        orderRepo.delete(order);
    }
    public List<Orderdto> get() {
        List<Order> orderDto = orderRepo.findAll();
        return orderDto.stream().map(order -> mapToDto(order)).collect(Collectors.toList());
    }
    public Orderdto update(Integer order_id, Orderdto orderDto) {
        Order order = orderRepo.findById(order_id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", order_id));
        order.setOrderedAt(orderDto.getOrderedAt());
        //order.setProduct_order(orderDto.getProduct_order());

        Order order1 = orderRepo.save(order);
        return mapToDto(order1);
    }
/*
    public Order update(Order order  ){
        log.info("order is is " + order.getOrder_id());
        return this.orderRepo.save(order);
    }

    public boolean deletebyid(int order_id){
        orderRepo.deleteById(order_id);
        return true;
    }
    public List<Order> getstock(){
        return this.orderRepo.findAll();
    }
    public Optional<Order> getstockByProductId(Integer order_id){
        return this.orderRepo.findById(order_id);
    }
*/

}
