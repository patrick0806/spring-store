package tech.patricknicezi.Spring.Store.adapter.datasources;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import tech.patricknicezi.Spring.Store.adapter.datasources.mapper.CustomerModelMapper;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.CustomerPostgresRepository;
import tech.patricknicezi.Spring.Store.internal.entities.Customer;
import tech.patricknicezi.Spring.Store.internal.repositories.CustomerRepository;

import java.util.Optional;

@Component
public class CustomerDatasource implements CustomerRepository {
    private final CustomerPostgresRepository customerPostgresRepository;

    public CustomerDatasource(CustomerPostgresRepository customerPostgresRepository) {
        this.customerPostgresRepository = customerPostgresRepository;
    }

    @Override
    public Customer save(Customer customer) {
        var customerModel = CustomerModelMapper.INSTANCE.toModel(customer);
        var savedCustomerModel = customerPostgresRepository.save(customerModel);
        return CustomerModelMapper.INSTANCE.toEntity(savedCustomerModel);
    }

    @Override
    public Optional<UserDetails> findByEmail(String email) {
        return customerPostgresRepository.findByEmail(email)
                .map(CustomerModelMapper.INSTANCE::toEntity);
    }
}
