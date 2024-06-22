package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin;

public record AdminResponse(
        String id,
        String name,
        String email,
        String phone,
        Boolean isActive,
        String createdAt,
        String updatedAt
) {
}
