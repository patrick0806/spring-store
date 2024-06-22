package tech.patricknicezi.Spring.Store.adapter.datasources;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import tech.patricknicezi.Spring.Store.adapter.datasources.mapper.AdminModelMapper;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.AdminPostgresRepository;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;
import tech.patricknicezi.Spring.Store.internal.repositories.AdminRepository;

import java.util.Optional;

@Component
public class AdminDatasource implements AdminRepository {
    private AdminPostgresRepository adminPostgresRepository;

    public AdminDatasource(AdminPostgresRepository adminPostgresRepository) {
        this.adminPostgresRepository = adminPostgresRepository;
    }

    @Override
    public Admin save(Admin admin) {
        final var adminModel = AdminModelMapper.INSTANCE.toModel(admin);
        final var savedAdminModel = adminPostgresRepository.save(adminModel);
        return AdminModelMapper.INSTANCE.toEntity(savedAdminModel);
    }

    @Override
    public Optional<UserDetails> findByEmail(String email) {
        return adminPostgresRepository.findByEmail(email)
                .map(AdminModelMapper.INSTANCE::toEntity);
    }
}
