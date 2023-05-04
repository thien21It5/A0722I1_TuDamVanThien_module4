package thucHanh1.service;

import thucHanh1.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> show();

    void addCustomer(Customer customer);

    void editCustomer(Customer customer);

    void deleteCustomer(Customer customer);

    Customer showCustomerById(int id);
}
