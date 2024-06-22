package tech.patricknicezi.Spring.Store.internal.interactors.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class LoginUseCase {
    private final AuthenticationManager authenticationManager;

    public LoginUseCase(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    public Object execute(String email, String password){
        var usernamePassword = new UsernamePasswordAuthenticationToken(email,password);
        var auth = authenticationManager.authenticate(usernamePassword);
        System.out.println(auth);
        return null;
    }
}
