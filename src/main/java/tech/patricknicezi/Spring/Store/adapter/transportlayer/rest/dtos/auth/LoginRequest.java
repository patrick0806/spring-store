package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequest (
        @NotBlank @Email String email,
        @NotBlank String password
){}
