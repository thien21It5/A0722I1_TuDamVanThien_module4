package thucHanh1.service;

import thucHanh1.entity.Customer;

import java.util.List;

public interface ICustomerService {
    void create(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();

}
