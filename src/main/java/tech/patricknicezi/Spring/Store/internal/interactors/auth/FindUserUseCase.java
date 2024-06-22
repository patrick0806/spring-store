package tech.patricknicezi.Spring.Store.internal.interactors.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.patricknicezi.Spring.Store.internal.repositories.AdminRepository;

@Service
public class FindUserUseCase implements UserDetailsService {
    private final AdminRepository adminRepository;

    public FindUserUseCase(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final var adminUser = adminRepository.findByEmail(email);

        if(adminUser.isPresent()){
            return adminUser.get();
        }
        //TODO add customer login
        throw new UsernameNotFoundException("User not found");

    }
}
