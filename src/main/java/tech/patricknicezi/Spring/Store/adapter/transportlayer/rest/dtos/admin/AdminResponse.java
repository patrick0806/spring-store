package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin;

public record AdminResponse(
        Long id,
        String name,
        String email,
        String phone,
        String password,
        Boolean isActive,
        String createdAt,
        String updatedAt
) {
}
