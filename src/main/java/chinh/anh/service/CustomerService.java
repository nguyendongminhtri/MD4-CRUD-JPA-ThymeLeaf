package chinh.anh.service;

import chinh.anh.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import chinh.anh.repository.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.delete(id);
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }
}
