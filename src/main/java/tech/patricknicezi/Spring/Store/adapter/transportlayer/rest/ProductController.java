package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product.ProductCategoryRequest;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.mapper.ProductCategoryDTOMapper;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi.ProductOpenAPI;
import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;
import tech.patricknicezi.Spring.Store.internal.interactors.product.CreateProductCategoryUseCase;

@RestController
@RequestMapping("/products")
public class ProductController implements ProductOpenAPI {

    private final CreateProductCategoryUseCase createProductCategoryUseCase;

    public ProductController(CreateProductCategoryUseCase createProductCategoryUseCase) {
        this.createProductCategoryUseCase = createProductCategoryUseCase;
    }

    @Override
    @PostMapping //TODO - config swagger for enable authentication for routes
    public ResponseEntity<ProductCategory> createProductCategory(@RequestBody @Valid ProductCategoryRequest productCategoryRequest) {
        final var productCategory = ProductCategoryDTOMapper.INSTANCE.toEntity(productCategoryRequest);
        final var savedCategory = createProductCategoryUseCase.createProductCategory(productCategory);
        return ResponseEntity.status(201).body(savedCategory);
    }
}
