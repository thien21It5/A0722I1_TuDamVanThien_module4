package thucHanh1.repository;

import thucHanh1.model.Customer;

import java.util.List;

public interface ICustomerRepo {

    List<Customer> display();

    void add(Customer customer);

    void edit(Customer customer);

    void delete(Customer customer);

    Customer showCustomerById(int id);
}
