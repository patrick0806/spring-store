package tech.patricknicezi.Spring.Store.internal.interactors.auth;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ActiveProfiles;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;
import tech.patricknicezi.Spring.Store.internal.entities.Customer;
import tech.patricknicezi.Spring.Store.internal.repositories.AdminRepository;
import tech.patricknicezi.Spring.Store.internal.repositories.CustomerRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@DataJpaTest
@ActiveProfiles("test")
class FindUserUseCaseTest {

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private FindUserUseCase findUserUseCase;

    @Test
    @DisplayName("Should return a user if exists in the database")
    public void shouldReturnUserIfExistsInDatabase() {
        UserDetails mockUser = Admin.builder()
                .name("Test User")
                .email("testUser")
                .password("testPassword")
                .phone("99999999999")
                .build();

        when(adminRepository.findByEmail(any(String.class))).thenReturn(Optional.of(mockUser));

        var user = findUserUseCase.loadUserByUsername("testUser");
        assertNotNull(user);
    }

    @Test
    @DisplayName("Should throw exception if user does not exist in the database")
    public void shouldThrowExceptionIfUserDoesNotExistInDatabase() {
        when(adminRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());

        assertThrows(UsernameNotFoundException.class, () -> findUserUseCase.loadUserByUsername("testUser"));
    }

    @Test
    @DisplayName("Should return a customer if exists in the database")
    public void shouldReturnCustomerIfExistsInDatabase() {
        UserDetails mockUser = Customer.builder()
                .name("Test User")
                .email("testUser")
                .password("testPassword")
                .phone("99999999999")
                .build();

        when(adminRepository.findByEmail(any(String.class))).thenReturn(Optional.empty());
        when(customerRepository.findByEmail(any(String.class))).thenReturn(Optional.of(mockUser));

        var user = findUserUseCase.loadUserByUsername("testUser");
        assertNotNull(user);
    }
}