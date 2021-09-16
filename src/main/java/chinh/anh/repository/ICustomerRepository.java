package chinh.anh.repository;

import chinh.anh.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICustomerRepository{
    List<Customer> findAll();
    void save(Customer customer);
    void delete(Long id);
    Customer findById(Long id);
}
