package group.service.customer;

import group.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Optional<Customer> findById(long id);

    void update(long id, Customer customer);

    void remove(long id);
}
