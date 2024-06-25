package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product.ProductCategoryRequest;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.product.ProductCategoryResponse;


@Tag(name = "Product")
public interface ProductOpenAPI {
    @Operation(summary = "Create a product category")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Product category created",
                    content = { @Content(schema = @Schema(implementation = ProductCategoryResponse.class), mediaType = "application/json") }
            ),
    })
    ResponseEntity<ProductCategoryResponse> createProductCategory(ProductCategoryRequest productCategory);
}
