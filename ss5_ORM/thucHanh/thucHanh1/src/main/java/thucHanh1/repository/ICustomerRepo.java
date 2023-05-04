package thucHanh1.repository;

import thucHanh1.entity.Customer;

import java.util.List;


public interface ICustomerRepo {
    void create(Customer customer);
    void delete(Customer customer);
    void update(Customer customer);
    Customer findById(String id);
    List<Customer> findAll();
}
