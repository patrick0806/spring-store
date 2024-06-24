package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product;

import jakarta.validation.constraints.NotBlank;

public record ProductCategoryRequest(@NotBlank String description) {
}
