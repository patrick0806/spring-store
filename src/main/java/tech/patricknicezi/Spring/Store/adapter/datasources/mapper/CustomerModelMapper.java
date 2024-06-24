package tech.patricknicezi.Spring.Store.adapter.datasources.mapper;

import org.apache.commons.lang3.StringUtils;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tech.patricknicezi.Spring.Store.adapter.datasources.services.model.CustomerModel;
import tech.patricknicezi.Spring.Store.internal.entities.Customer;
import tech.patricknicezi.Spring.Store.util.DateUtils;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Mapper
public interface CustomerModelMapper {

    CustomerModelMapper INSTANCE = Mappers.getMapper(CustomerModelMapper.class);

    CustomerModel toModel(Customer customer);
    Customer toEntity(CustomerModel customerModel);

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

    default String parseUUIDToString(UUID uuid){
        if(Objects.isNull(uuid)){
            return null;
        }

        return uuid.toString();
    }
}
