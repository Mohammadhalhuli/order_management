package com.pokemonreview.api.controllers;

import com.pokemonreview.api.dto.Customerdto;
import com.pokemonreview.api.models.Customer;
import com.pokemonreview.api.service.impl.CustomerDao;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@Api(value = "Customar controller Rest api all Customar")
@RequestMapping(path = "/api/v1/customer")
@RestController
public class CustomerController {
    @Autowired
    private CustomerDao customerDao;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }
    //@ApiOperation(value = "customer controller REST API to add")
    @PostMapping("/add")
    public ResponseEntity<Customerdto> add(@RequestBody Customerdto customer){
        //return new ResponseEntity<Customer> (customerDao.add(customer) , HttpStatus.OK);
        //return new ResponseEntity<> (customerDao.add(customer) , HttpStatus.OK);
        //return this.customerDao.add(customer);
        return new ResponseEntity(customerDao.add(customer), HttpStatus.CREATED);
    }
    /*public ResponseEntity<Customer> add(@RequestBody Customer customer){
        //return new ResponseEntity<Customer> (customerDao.add(customer) , HttpStatus.OK);
        return new ResponseEntity<> (customerDao.add(customer) , HttpStatus.OK);
        //return this.customerDao.add(customer);
    }*/
    //@ApiOperation(value = "customer controller REST API to edit customer")
    @PutMapping("update/{customer_id}")
    public ResponseEntity<Customerdto> update(@PathVariable(name="customer_id") int customer_id,
                                              @RequestBody Customerdto customer){
        return new ResponseEntity(customerDao.update(customer_id,customer),HttpStatus.OK);
    }
    /*
    public ResponseEntity<Customer> update(@PathVariable int customer_id,@RequestBody Customer customer){
        customer.setCustomer_id(customer_id);
        return new ResponseEntity<Customer> (customerDao.update(customer) , HttpStatus.OK);
        //return this.customerDao.update(customer);
    }
*/
    //@ApiOperation(value = "customer controller REST API to delete customer")
    @DeleteMapping("/delete/{customer_id}")
    public ResponseEntity<String> delete(@PathVariable(name="customer_id") Integer customer_id){
        customerDao.delete(customer_id);
        return new ResponseEntity<>("Deleted successfully",HttpStatus.OK);
    }
    /*
    private String delete(@PathVariable int customer_id){
        customerDao.deletebyid(customer_id);
        return "Success";
    }*/
    //@ApiOperation(value = "customer controller REST API to get all customer")
    @GetMapping(path = "/get")
    public ResponseEntity<List<Customerdto>> getAllCustomers(){
        return ResponseEntity.ok().body(customerDao.get());
    }
    /*
    public ResponseEntity<List<Customer>> get() {
        return new ResponseEntity<List<Customer>>(customerDao.get() , HttpStatus.OK )  ;
        //return this.customerDao.get();
    }*/

    //@ApiOperation(value = "customer controller REST API to get customer by id")
    @GetMapping(path = "get/{customer_id}")
    public ResponseEntity<Customerdto> getCustomerById(@PathVariable(name="customer_id") Integer customer_id){
        return ResponseEntity.ok().body(customerDao.getById(customer_id));
    }
    /*
    public Optional<Customer> getSaleByOrderId(@PathVariable  Integer customer_id) {
        return this.customerDao.getbyId(customer_id);
    }*/
}
