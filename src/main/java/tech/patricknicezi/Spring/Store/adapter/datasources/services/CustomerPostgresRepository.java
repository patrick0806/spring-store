package tech.patricknicezi.Spring.Store.adapter.datasources.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.CustomerModel;

import java.util.Optional;
import java.util.UUID;

public interface CustomerPostgresRepository extends JpaRepository<CustomerModel, UUID> {
    Optional<CustomerModel> findByEmail(String email);
}
