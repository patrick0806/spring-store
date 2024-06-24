package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product.ProductCategoryRequest;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product.ProductCategoryResponse;
import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;

@Mapper
public interface ProductCategoryDTOMapper {

    ProductCategoryDTOMapper INSTANCE = Mappers.getMapper(ProductCategoryDTOMapper.class);

    ProductCategory toEntity(ProductCategoryRequest request);
    ProductCategoryResponse toResponse(ProductCategory entity);
}