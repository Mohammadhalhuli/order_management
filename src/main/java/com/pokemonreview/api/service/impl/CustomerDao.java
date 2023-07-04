package com.pokemonreview.api.service.impl;

import com.pokemonreview.api.dto.Customerdto;
import com.pokemonreview.api.models.Customer;
import com.pokemonreview.api.repository.CustomerRepo;
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
public class CustomerDao {
    @Autowired
    private final CustomerRepo customerRepo;
    Customer mapToEntity(Customerdto customerdto){
        Customer customer = new Customer();
        customer.setFirstName(customerdto.getFirstName());
        customer.setLastName(customerdto.getLastName());
        customer.setBornAt(customerdto.getBornAt());
        customer.setOrders(customerdto.getOrder());
        return customer;
    }
    Customerdto mapToDto (Customer customer){
        Customerdto customerDto = new Customerdto();
        customerDto.setCustomer_id(customer.getCustomer_id());
        customerDto.setFirstName(customer.getFirstName());
        customerDto.setLastName(customer.getLastName());
        customerDto.setBornAt(customer.getBornAt());
        customerDto.setOrder(customer.getOrders());
        return customerDto;
    }
    public Customerdto add(Customerdto customer){
        Customer customer1 = mapToEntity(customer);
        customerRepo.save(customer1);
        Customerdto customerdto =mapToDto(customer1);
        return customerdto;
       // log.info("customer is is " + customer.getCustomer_id());
       // return this.customerRepo.save(customer);
    }
/*
    public Customer update(Customer customer){
        customer.setBornAt(customer.getBornAt());
        log.info("customer is is " + customer.getCustomer_id());
        return this.customerRepo.save(customer);
    }
*/
    public Customerdto update(Integer id, Customerdto customerDto) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setBornAt(customerDto.getBornAt());
        customer.setOrders(customerDto.getOrder());

        Customer customer1 = customerRepo.save(customer);
        return mapToDto(customer1);
    }
    public List<Customerdto> get() {
        List<Customer> customers = customerRepo.findAll();
        return customers.stream().map(customer -> mapToDto(customer)).collect(Collectors.toList());
    }

    public void delete(Integer id) {
        Customer customer=customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        customerRepo.delete(customer);
    }
    /*
    public boolean deletebyid(int customer_id){
        customerRepo.deleteById(customer_id);
        return true;
    }
    public List<Customer> get(){
        return this.customerRepo.findAll();
    }*/
    public Customerdto getById(Integer id) {
        Customer customer = customerRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
        return mapToDto(customer);
    }

    /*
    public Optional<Customer> getbyId(Integer customer_id){
        return this.customerRepo.findById(customer_id);
    }*/

}
