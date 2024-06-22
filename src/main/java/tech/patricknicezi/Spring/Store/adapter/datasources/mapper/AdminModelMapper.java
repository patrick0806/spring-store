package tech.patricknicezi.Spring.Store.adapter.datasources.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.AdminModel;
import tech.patricknicezi.Spring.Store.internal.entities.Admin;
import tech.patricknicezi.Spring.Store.util.DateUtils;

import java.time.OffsetDateTime;
import java.util.Objects;

@Mapper
public interface AdminModelMapper {
    AdminModelMapper INSTANCE = Mappers.getMapper(AdminModelMapper.class);

    AdminModel toModel(Admin admin);
    Admin toEntity(AdminModel adminModel);

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
