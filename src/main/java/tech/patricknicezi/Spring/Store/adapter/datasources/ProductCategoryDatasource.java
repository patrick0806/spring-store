package tech.patricknicezi.Spring.Store.adapter.datasources;

import org.springframework.stereotype.Component;
import tech.patricknicezi.Spring.Store.adapter.datasources.mapper.ProductCategoryModelMapper;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.ProductCategoryPostgresRepository;
import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;
import tech.patricknicezi.Spring.Store.internal.repositories.ProductCategoryRepository;

@Component
public class ProductCategoryDatasource implements ProductCategoryRepository {
    private final ProductCategoryPostgresRepository productCategoryPostgresRepository;

    public ProductCategoryDatasource(ProductCategoryPostgresRepository productCategoryPostgresRepository) {
        this.productCategoryPostgresRepository = productCategoryPostgresRepository;
    }

    @Override
    public ProductCategory save(ProductCategory productCategory) {
       final var productCategoryModel = ProductCategoryModelMapper.INSTANCE.toModel(productCategory);
       final var savedProductCategoryModel = productCategoryPostgresRepository.save(productCategoryModel);
       return ProductCategoryModelMapper.INSTANCE.toEntity(savedProductCategoryModel);
    }
}
