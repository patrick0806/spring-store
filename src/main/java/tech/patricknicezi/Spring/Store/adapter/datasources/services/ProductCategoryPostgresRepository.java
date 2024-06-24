package tech.patricknicezi.Spring.Store.adapter.datasources.services;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.ProductCategoryModel;

public interface ProductCategoryPostgresRepository extends JpaRepository<ProductCategoryModel, String> {
}
