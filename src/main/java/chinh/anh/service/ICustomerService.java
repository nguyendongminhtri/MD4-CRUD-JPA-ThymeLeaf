package chinh.anh.service;

import chinh.anh.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
}
