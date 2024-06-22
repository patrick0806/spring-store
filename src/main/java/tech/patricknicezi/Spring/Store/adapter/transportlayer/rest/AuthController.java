package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.auth.LoginRequest;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi.AuthOpenApi;
import tech.patricknicezi.Spring.Store.internal.interactors.auth.LoginUseCase;

@RestController
@RequestMapping("/auth")
public class AuthController implements AuthOpenApi {

    private final LoginUseCase loginUseCase;

    public AuthController(LoginUseCase loginUseCase) {
        this.loginUseCase = loginUseCase;
    }

    @Override
    @PostMapping("/login")
    public ResponseEntity<String> authenticate(@RequestBody @Valid LoginRequest loginRequest) {
        var result = loginUseCase.execute(loginRequest.email(), loginRequest.password());
        System.out.println(result);
        return ResponseEntity.ok().build();
    }

}
