package com.allianz.erp.controller;

import com.allianz.erp.entity.Bill;
import com.allianz.erp.entity.Customer;
import com.allianz.erp.entity.CustomerOrder;
import com.allianz.erp.service.CustomerOrderService;
import com.allianz.erp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @Autowired
    CustomerOrderService customerOrderService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomerList() {
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
        return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);
    }

    @GetMapping("bill-list/{customerId}")
    public ResponseEntity<List<Bill>> getCustomerBillListByCustomerId(@PathVariable Long customerId) {
        return new ResponseEntity<>(customerService.getCustomerById(customerId).getBillList(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.createCustomer(customer.getName()), HttpStatus.OK);
    }

    @PutMapping("update/name/{id}")
    public ResponseEntity<Customer> updateCustomerName(@RequestBody String name, @PathVariable Long id) {
        ResponseEntity<Customer> response = getCustomerById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Customer customer = response.getBody();
            customerService.updateCustomerName(name, customer);

            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("add/order/id/{id}")
    public ResponseEntity<Customer> addCustomerOrderToCustomer(@RequestBody CustomerOrder customerOrder, @PathVariable Long id) {
        ResponseEntity<Customer> response = getCustomerById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Customer customer = response.getBody();
            customerService.addCustomerOrderToCustomer(customerOrder, customer);

            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("subtract/customer-order/{customerId}/id/{id}")
    public ResponseEntity<Customer> subtractCustomerOrderFromCustomer(@PathVariable Long customerId, @PathVariable Long id) {
        ResponseEntity<Customer> response = getCustomerById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Customer customer = response.getBody();
            CustomerOrder customerOrder = customerService.findCustomerOrderFromCustomerWithId(customer, customerId);
            customerService.subtractCustomerOrderFromCustomer(customerOrder, customer);
            customerOrderService.removeCustomerOrderWithId(customerOrder.getId());
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("add/bill/id/{id}")
    public ResponseEntity<Customer> addBillToCustomer(@RequestBody Bill bill, @PathVariable Long id) {
        ResponseEntity<Customer> response = getCustomerById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Customer customer = response.getBody();
            customerService.addBillToCustomer(bill, customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("subtract/bill/{billId}/id/{id}")
    public ResponseEntity<Customer> subtractBillFromCustomer(@PathVariable Long billId, @PathVariable Long id) {
        ResponseEntity<Customer> response = getCustomerById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            Customer customer = response.getBody();
            Bill bill = customerService.findBillFromCustomerWithId(customer, billId);
            customerService.subtractBillFromCustomer(bill, customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("turn-to-bill/{customerOrderId}/id/{id}")
    public ResponseEntity<Customer> turnCustomerOrderToBill(@PathVariable Long customerOrderId, @PathVariable Long id) {
        Customer customer = customerService.turnCustomerOrderToBill(customerOrderId, id);
        return new ResponseEntity<>(customer, HttpStatus.OK);
    }

}
