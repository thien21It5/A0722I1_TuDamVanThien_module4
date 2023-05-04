package demo.service;

import demo.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> listAll();

    void create(Employee employee);
}
