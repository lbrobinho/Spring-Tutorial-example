package com.bo.springdemo.rest;

import com.bo.springdemo.entity.Customer;
import com.bo.springdemo.exception.CustomerNotFoundException;
import com.bo.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    @Autowired
    private CustomerService customerService;

    // add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {

        return customerService.getCustomers();

    }

    // add mapping for GET /customers
    @GetMapping("/customers/{customerId}")
    public Customer getCustomer(@PathVariable int customerId) {

         Customer customer = customerService.getCustomer(customerId);

         if (customer == null) {
             throw new CustomerNotFoundException("Customer id not found -" + customerId);
         }
        return customer;
    }

    // add mapping for POST /customers - add new customer
    @PostMapping("/customers")
    public Customer addCustomer(@RequestBody Customer customer) {

        //also just in case that pass an ind in JSON ... set id to 0
        //this is force a save od new item ... instead of update
        customer.setId(0);

        customerService.saveCustomer(customer);

        return customer;
    }

    // add mapping for POST /customers - add new customer
    @PutMapping("/customers")
    public Customer updateCustomer(@RequestBody Customer customer) {

        customerService.saveCustomer(customer);

        return customer;
    }

    @DeleteMapping("/customers/{customerId}")
    public String deleteCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomer(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer id not found -" + customerId);
        }

        customerService.deleteCustomer(customerId);

        return "Deleted customer id -" + customerId;
    }
}
