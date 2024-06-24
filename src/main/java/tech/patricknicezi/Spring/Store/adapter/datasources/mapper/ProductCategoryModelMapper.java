package tech.patricknicezi.Spring.Store.adapter.datasources.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.ProductCategoryModel;
import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;

@Mapper
public interface ProductCategoryModelMapper {
    ProductCategoryModelMapper INSTANCE = Mappers.getMapper(ProductCategoryModelMapper.class);

    ProductCategoryModel toModel(ProductCategory productCategoryModel);
    ProductCategory toEntity(ProductCategoryModel productCategoryModel);
}
