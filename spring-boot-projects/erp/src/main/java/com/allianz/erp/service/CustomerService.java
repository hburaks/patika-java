package com.allianz.erp.service;

import com.allianz.erp.database.entity.Bill;
import com.allianz.erp.database.entity.Customer;
import com.allianz.erp.database.entity.CustomerOrder;
import com.allianz.erp.database.repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer createCustomer(String name) {
        Customer customer = new Customer();
        customer.setName(name);
        customerRepository.save(customer);
        return customer;
    }


    public Customer getCustomerById(Long id) {
        return customerRepository.getReferenceById(id);
    }

    public Customer updateCustomerName(String name, Customer customer) {
        customer.setName(name);
        customerRepository.save(customer);
        return customer;
    }

    public Customer addCustomerOrderToCustomer(CustomerOrder customerOrder, Customer customer) {
        if (customer.getCustomerOrderList() == null) {
            customer.setCustomerOrderList(new ArrayList<CustomerOrder>() {
            });
        }
        customer.getCustomerOrderList().add(customerOrder);
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public Customer subtractCustomerOrderFromCustomer(CustomerOrder customerOrder, Customer customer) {
        if (customer.getCustomerOrderList() != null) {
            for (int i = 0; i < customer.getCustomerOrderList().size(); i++) {
                if (customer.getCustomerOrderList().get(i).getId().equals(customerOrder.getId())) {
                    customer.getCustomerOrderList().remove(i);
                    break;
                } else {
                    throw new IllegalArgumentException("The customer order does not exist for this customer!");
                }
            }
        } else {
            throw new IllegalArgumentException("There is no customer order in this customer!");
        }
        return customer;
    }


    public Bill findBillFromCustomerWithId(Customer customer, Long billId) {
        Optional<Bill> billOptional = customer.getBillList().stream()
                .filter(bill -> bill.getId().equals(billId))
                .findFirst();

        if (billOptional.isPresent()) {
            return billOptional.get();
        }
        return null;
    }

    public CustomerOrder findCustomerOrderFromCustomerWithId(Customer customer, Long customerId) {
        Optional<CustomerOrder> customerOrderOptional = customer.getCustomerOrderList().stream()
                .filter(customerOrder -> customerOrder.getId().equals(customerId))
                .findFirst();

        if (customerOrderOptional.isPresent()) {
            return customerOrderOptional.get();
        }
        return null;
    }

    public Customer addBillToCustomer(Bill bill, Customer customer) {
        if (customer.getCustomerOrderList() == null) {
            customer.setBillList(new ArrayList<Bill>() {
            });
        }
        customer.getBillList().add(bill);

        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public Customer subtractBillFromCustomer(Bill bill, Customer customer) {
        if (customer.getCustomerOrderList() != null) {
            for (int i = 0; i < customer.getBillList().size(); i++) {
                if (customer.getBillList().get(i).getId().equals(bill.getId())) {
                    customer.getBillList().remove(i);
                    break;
                } else {
                    throw new IllegalArgumentException("Given bill does not exist for this customer!");
                }
            }
        } else {
            throw new IllegalArgumentException("There is no bill in this customer!");
        }
        return customer;
    }

    //TODO customerorderservice
    public Customer turnOrderToBill(CustomerOrder customerOrder, Customer customer) {
        if (customer.getCustomerOrderList() != null) {
            for (int i = 0; i < customerOrder.getOrderItemList().size(); i++) {
                if (customer.getCustomerOrderList().get(i).getId().equals(customerOrder.getId())) {
                    CustomerOrder orderConvertingToBill = customer.getCustomerOrderList().get(i);
                    Bill bill = new Bill();
                    bill.setCustomer(orderConvertingToBill.getCustomer());
                    bill.setOrderItemList(orderConvertingToBill.getOrderItemList());

                    break;
                } else {
                    throw new IllegalArgumentException("The customer order does not exist for this customer!");
                }
            }
        } else {
            throw new IllegalArgumentException("There is no customer order in this customer!");
        }
        return customer;
    }


}
