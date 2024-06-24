package tech.patricknicezi.Spring.Store.internal.repositories;

import tech.patricknicezi.Spring.Store.internal.entities.ProductCategory;

public interface ProductCategoryRepository{
    ProductCategory save(ProductCategory productCategory);
}
