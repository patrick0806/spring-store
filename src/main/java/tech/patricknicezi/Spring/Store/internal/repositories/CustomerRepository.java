package tech.patricknicezi.Spring.Store.internal.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import tech.patricknicezi.Spring.Store.internal.entities.Customer;

import java.util.Optional;

public interface CustomerRepository {
    Customer save(Customer customer);
    Optional<UserDetails> findByEmail(String email);
}
