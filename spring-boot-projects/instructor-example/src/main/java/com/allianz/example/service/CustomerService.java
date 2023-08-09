package com.allianz.example.service;

import com.allianz.example.database.entity.BillEntity;
import com.allianz.example.database.entity.CustomerEntity;
import com.allianz.example.database.entity.OrderEntity;
import com.allianz.example.database.repository.CustomerRepository;
import com.allianz.example.util.BaseService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends BaseService<CustomerEntity> {
    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    OrderService orderService;

    @Autowired
    BillService billService;

    public List<CustomerEntity> getAllCustomers() {
        return customerRepository.findAll();
    }

    public CustomerEntity createCustomer(String name) {
        CustomerEntity customer = new CustomerEntity();
        customer.setCompanyName(name);
        customerRepository.save(customer);
        return customer;
    }


    public CustomerEntity updateCustomerName(String name, CustomerEntity customer) {
        customer.setCompanyName(name);
        customerRepository.save(customer);
        return customer;
    }

    public CustomerEntity addCustomerOrderToCustomer(OrderEntity customerOrder, CustomerEntity customer) {
        if (customer.getOrderList() == null) {
            customer.setOrderList(new ArrayList<OrderEntity>() {
            });
        }
        customer.getOrderList().add(customerOrder);
        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public CustomerEntity subtractCustomerOrderFromCustomer(OrderEntity customerOrder, CustomerEntity customer) {
        if (customer.getOrderList() != null) {
            for (int i = 0; i < customer.getOrderList().size(); i++) {
                if (customer.getOrderList().get(i).getId().equals(customerOrder.getId())) {
                    customer.getOrderList().remove(i);
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


    public BillEntity findBillFromCustomerWithId(CustomerEntity customer, Long billId) {
        Optional<BillEntity> billOptional = customer.getBillEntityList().stream()
                .filter(bill -> bill.getId().equals(billId))
                .findFirst();

        if (billOptional.isPresent()) {
            return billOptional.get();
        }
        return null;
    }

    public OrderEntity findCustomerOrderFromCustomerWithId(CustomerEntity customer, Long customerId) {
        Optional<OrderEntity> customerOrderOptional = customer.getOrderList().stream()
                .filter(customerOrder -> customerOrder.getId().equals(customerId))
                .findFirst();

        if (customerOrderOptional.isPresent()) {
            return customerOrderOptional.get();
        } else {
            throw new IllegalArgumentException("The customer order does not exist for this customer!");
        }
    }

    public CustomerEntity addBillToCustomer(BillEntity bill, CustomerEntity customer) {
        if (customer.getOrderList() == null) {
            customer.setBillEntityList(new ArrayList<BillEntity>() {
            });
        }
        customer.getBillEntityList().add(bill);

        customerRepository.save(customer);
        return customer;
    }

    @Transactional
    public CustomerEntity subtractBillFromCustomer(BillEntity bill, CustomerEntity customer) {
        if (customer.getOrderList() != null) {
            for (int i = 0; i < customer.getBillEntityList().size(); i++) {
                if (customer.getBillEntityList().get(i).getId().equals(bill.getId())) {
                    customer.getBillEntityList().remove(i);
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



    public CustomerEntity turnCustomerOrderToBill(Long customerOrderId, Long customerId) throws Exception {
        Optional<CustomerEntity> customerOptional = findById(customerId);

        if (customerOptional.isPresent()) {
            CustomerEntity customer = customerOptional.get();

            if (customer.getOrderList() != null) {
                // Find the specific customer order with the given customerOrderId
                OrderEntity customerOrder = findCustomerOrderFromCustomerWithId(customer, customerOrderId);

                if (customerOrder != null) {
                    orderService.approveOrdersStatusIfPossible(customerOrder);

                    // Create a new bill with the approved order items
                    BillEntity bill = billService.createBillWithApprovedOrderItems(customerOrder);

                    // Check if the customer already has a billEntityList
                    if (customer.getBillEntityList() == null) {
                        // If not, create a new ArrayList to store the bill
                        customer.setBillEntityList(new ArrayList<>());
                    }

                    customer.getBillEntityList().add(bill);

                    return save(customer);
                } else {
                    throw new IllegalArgumentException("Customer order with ID " + customerOrderId + " not found!");
                }
            } else {
                throw new IllegalArgumentException("There is no customer order in this customer!");
            }
        } else {
            throw new IllegalArgumentException("Customer with ID " + customerId + " not found!");
        }
    }


}


