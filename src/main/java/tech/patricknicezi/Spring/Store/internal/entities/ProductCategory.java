package tech.patricknicezi.Spring.Store.internal.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ProductCategory {
    private String id;
    private String description;
}
