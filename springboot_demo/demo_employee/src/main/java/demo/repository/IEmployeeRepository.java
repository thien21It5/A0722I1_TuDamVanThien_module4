package demo.repository;

import demo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IEmployeeRepository extends JpaRepository<Employee, String> {
    List<Employee> findAllByNameContainingOrPhoneNumberContainingOrEmailContaining(String name, String phoneNumber, String email);
    void deleteAllByIdIn(String[] ids);
}
