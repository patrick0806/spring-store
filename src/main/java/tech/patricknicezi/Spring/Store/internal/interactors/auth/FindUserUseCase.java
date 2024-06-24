package tech.patricknicezi.Spring.Store.internal.interactors.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tech.patricknicezi.Spring.Store.internal.repositories.AdminRepository;
import tech.patricknicezi.Spring.Store.internal.repositories.CustomerRepository;

@Service
public class FindUserUseCase implements UserDetailsService {
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    public FindUserUseCase(AdminRepository adminRepository, CustomerRepository customerRepository) {
        this.adminRepository = adminRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final var adminUser = adminRepository.findByEmail(email);
        final var customerUser = customerRepository.findByEmail(email);

        if(adminUser.isEmpty() && customerUser.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return adminUser.orElseGet(() -> customerUser.get());
    }
}
