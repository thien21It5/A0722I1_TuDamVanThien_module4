package codegym.service;

import codegym.model.Customer;
import codegym.model.Province;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
}
