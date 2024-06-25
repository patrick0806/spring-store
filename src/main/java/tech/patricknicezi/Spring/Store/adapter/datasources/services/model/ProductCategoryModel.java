package tech.patricknicezi.Spring.Store.adapter.datasources.services.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "product_categories")
@Entity(name = "ProductCategoryPostgres")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class ProductCategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String description;
}
