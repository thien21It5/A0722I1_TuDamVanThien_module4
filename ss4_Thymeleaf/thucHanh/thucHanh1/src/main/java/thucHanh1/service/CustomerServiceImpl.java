package thucHanh1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thucHanh1.model.Customer;
import thucHanh1.repository.ICustomerRepo;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{
    @Autowired
    private ICustomerRepo customerRepo;

    @Override
    public List<Customer> show() {
        return customerRepo.display();
    }

    @Override
    public void addCustomer(Customer customer) {
        customerRepo.add(customer);
    }

    @Override
    public void editCustomer(Customer customer) {
        customerRepo.edit(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public Customer showCustomerById(int id) {
        return customerRepo.showCustomerById(id);
    }
}

