package tech.patricknicezi.Spring.Store.internal.interactors.product;

import org.springframework.stereotype.Service;
import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;
import tech.patricknicezi.Spring.Store.internal.repositories.ProductCategoryRepository;

@Service
public class CreateProductCategoryUseCase {

    private final ProductCategoryRepository productCategoryRepository;

    public CreateProductCategoryUseCase(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }

    public ProductCategory createProductCategory(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
}
