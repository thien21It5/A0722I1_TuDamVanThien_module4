package thucHanh1.repository;

import org.springframework.stereotype.Repository;
import thucHanh1.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class CustomerRepo implements ICustomerRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void create(Customer customer) {
        entityManager.persist(customer);
    }

    @Override
    public void delete(Customer customer) {
        entityManager.remove(customer);
    }

    @Override
    public void update(Customer customer) {
        entityManager.merge(customer);
    }

    @Override
    public Customer findById(String id) {
        return entityManager.find(Customer.class, id);
    }

    @Override
    public List<Customer> findAll() {
        return entityManager.createQuery("select c from Customer c").getResultList();
    }
}
