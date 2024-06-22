package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateAdminRequest(
        @NotBlank String name,
        @NotBlank @Email String email,
        @NotBlank @Min(8) String password,
        @NotBlank String phone) {
}
