package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.AdminResponse;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.CreateAdminRequest;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.mapper.AdminDTOMapper;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.openapi.AdminOpenAPI;
import tech.patricknicezi.Spring.Store.internal.interactors.admin.CreateAdminUseCase;

@RestController
@RequestMapping("/admin")
public class AdminController implements AdminOpenAPI {

    private final CreateAdminUseCase createAdminUseCase;

    public AdminController(CreateAdminUseCase createAdminUseCase) {
        this.createAdminUseCase = createAdminUseCase;
    }

    @Override
    @PostMapping
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
        final var newAdmin = AdminDTOMapper.INSTANCE.toEntity(createAdminRequest);
        final var savedAdmin = createAdminUseCase.execute(newAdmin);
        return ResponseEntity.status(201).body(AdminDTOMapper.INSTANCE.toResponse(savedAdmin));
    }
}
