package thucHanh1.repository;

import org.springframework.stereotype.Repository;
import thucHanh1.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CustomerRepo implements ICustomerRepo {
    private static Map<Integer, Customer> customers;

    static {
        customers = new HashMap<>();
        customers.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customers.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customers.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customers.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customers.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customers.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> display() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public void add(Customer customer) {
        customers.put(customer.getId(),customer);
    }

    @Override
    public void edit(Customer customer) {
       if(customers.containsKey(customer.getId())){
           customers.put(customer.getId(),customer);
       }
    }

    @Override
    public void delete(Customer customer) {
        if (customers.containsKey(customer.getId())) {
            customers.remove(customer.getId(), customer);
        }
    }

    @Override
    public Customer showCustomerById(int id) {
        return customers.get(id);
    }
}
