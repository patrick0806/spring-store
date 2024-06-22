package tech.patricknicezi.Spring.Store.adapter.datasources.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.AdminModel;

import java.util.Optional;

public interface AdminPostgresRepository extends JpaRepository<AdminModel, Long>{
    Optional<AdminModel> findByEmail(String email);
}
