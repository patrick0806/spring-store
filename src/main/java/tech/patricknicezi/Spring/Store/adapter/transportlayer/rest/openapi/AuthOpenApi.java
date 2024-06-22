package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.AdminResponse;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.auth.LoginRequest;

@Tag(name = "Auth")
public interface AuthOpenApi {
    @Operation(summary = "Authenticate a user")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "User authenticated",
                    content = { @Content(schema = @Schema(implementation = AdminResponse.class), mediaType = "application/json") }
            ),
    })
    public ResponseEntity authenticate(LoginRequest loginRequest);
}
