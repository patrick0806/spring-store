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

@RestController
@RequestMapping("/admin")
public class AdminController implements AdminOpenAPI {

    @Override
    @PostMapping
    public ResponseEntity<AdminResponse> createAdmin(@RequestBody @Valid CreateAdminRequest createAdminRequest) {
        final var newAdminData = AdminDTOMapper.INSTANCE.toEntity(createAdminRequest);
        System.out.println(newAdminData);
        return null;
    }
}
