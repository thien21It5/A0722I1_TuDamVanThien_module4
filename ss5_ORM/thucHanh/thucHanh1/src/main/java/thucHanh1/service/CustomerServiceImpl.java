package thucHanh1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import thucHanh1.entity.Customer;
import thucHanh1.repository.CustomerRepo;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    public CustomerRepo getCustomerRepo() {
        return customerRepo;
    }
    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }


    @Override
    public void create(Customer customer) {
        customerRepo.create(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRepo.delete(customer);
    }

    @Override
    public void update(Customer customer) {
        customerRepo.update(customer);
    }

    @Override
    public Customer findById(String id) {
        return customerRepo.findById(id);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepo.findAll();
    }

}
