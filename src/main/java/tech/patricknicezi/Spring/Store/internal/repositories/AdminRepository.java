package tech.patricknicezi.Spring.Store.internal.repositories;

import org.springframework.security.core.userdetails.UserDetails;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;

import java.util.Optional;

public interface AdminRepository {
    Admin save(Admin admin);
    Optional<UserDetails> findByEmail(String email);
}
