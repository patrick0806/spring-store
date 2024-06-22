package tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.AdminResponse;
import tech.patricknicezi.Spring.Store.adapter.transportlayer.rest.dtos.admin.CreateAdminRequest;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;
import tech.patricknicezi.Spring.Store.util.DateUtils;

import java.time.OffsetDateTime;
import java.util.Objects;

@Mapper
public interface AdminDTOMapper {
    AdminDTOMapper INSTANCE = Mappers.getMapper(AdminDTOMapper.class);

    Admin toEntity(CreateAdminRequest createAdminRequest);

    AdminResponse toResponse(Admin admin);

    default String parseOffsetDateTimeToString(OffsetDateTime date){
       if(Objects.isNull(date)){
           return null;
       }

       return DateUtils.parseOffsetDateTimeToString(date);
    }

    default OffsetDateTime parseStringDateTimeToOffsetDateTime(String string){
       if(StringUtils.isBlank(string)){
           return null;
       }

       return DateUtils.parseStringDateTimeToOffsetDateTime(string);
    }
}
