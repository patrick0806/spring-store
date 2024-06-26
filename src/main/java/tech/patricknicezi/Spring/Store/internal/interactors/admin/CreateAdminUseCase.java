package tech.patricknicezi.Spring.Store.internal.interactors.admin;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import tech.patricknicezi.Spring.Store.bootstrap.exceptions.AlreadyExistsException;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;
import tech.patricknicezi.Spring.Store.internal.repositories.AdminRepository;
import tech.patricknicezi.Spring.Store.util.StringUtils;

import java.time.OffsetDateTime;

@Service
public class CreateAdminUseCase {
    private  final AdminRepository adminRepository;

    public CreateAdminUseCase(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public Admin execute(Admin admin){
        final var adminByEmail = adminRepository.findByEmail(admin.getEmail());

        if(adminByEmail.isPresent()){
            throw new AlreadyExistsException("A user with this email already exists");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(admin.getPassword());
        admin.setPassword(encryptedPassword);
        admin.setPhone(StringUtils.onlyNumbers(admin.getPhone()));
        admin.setIsActive(true);
        return adminRepository.save(admin);
    }
}
