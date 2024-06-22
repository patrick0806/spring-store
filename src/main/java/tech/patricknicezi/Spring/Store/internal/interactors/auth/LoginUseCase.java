package tech.patricknicezi.Spring.Store.internal.interactors.auth;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class LoginUseCase {
    @Value("${spring-store.jwt.secret}")
    private String secret;

    @Value("${spring-store.jwt.expiration}")
    private long expiration;


    private final AuthenticationManager authenticationManager;
    private final FindUserUseCase findUserUseCase;

    public LoginUseCase(AuthenticationManager authenticationManager, FindUserUseCase findUserUseCase) {
        this.authenticationManager = authenticationManager;
        this.findUserUseCase = findUserUseCase;
    }

    public String execute(String email, String password){
        var usernamePassword = new UsernamePasswordAuthenticationToken(email,password);

        authenticationManager.authenticate(usernamePassword);

        final var user = findUserUseCase.loadUserByUsername(email);
        return generateToken(user);
    }

    private String generateToken(UserDetails user){
        try{
            return JWT.create().withIssuer("Spring Store")
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationTime())
                    .sign(Algorithm.HMAC256(secret));
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error creating token", exception);//TODO create custom exception
        }
    }

    private Instant generateExpirationTime() {
        return Instant.now().plusSeconds(expiration);
    }
}
