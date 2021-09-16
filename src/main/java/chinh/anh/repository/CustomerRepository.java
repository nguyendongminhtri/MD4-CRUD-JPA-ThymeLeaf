package chinh.anh.repository;

import chinh.anh.model.Customer;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepository implements ICustomerRepository {
    @PersistenceContext
    EntityManager entityManager;
    @Override
    public List<Customer> findAll() {
        //Nên viết ngược List gọi class trước để lấy câu truy vấn

        String queryStr = "select  c from Customer as c";
        List<Customer> customerList = entityManager.createQuery(queryStr, Customer.class ).getResultList();
//        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
//        return query.getResultList();
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        if(customer!=null){
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if(customer!=null){
            entityManager.remove(customer);
        }
    }

    @Override
    public Customer findById(Long id) {
        String queryStr = "select c from Customer as c where c.id =:id";
        Customer customer = entityManager.createQuery(queryStr,Customer.class).setParameter("id",id).getSingleResult();
        return customer;
    }
}
