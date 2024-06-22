package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.AdminResponse;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.CreateAdminRequest;

@Tag(name = "Admin")
public interface AdminOpenAPI {

    @Operation(summary = "Create a new admin")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Admin created",
                    content = { @Content(schema = @Schema(implementation = AdminResponse.class), mediaType = "application/json") }
            ),
    })
    public ResponseEntity<AdminResponse> createAdmin(CreateAdminRequest createAdminRequest);

}
