package dev.fs.demo.mapper;

import dev.fs.demo.dto.LoginDTO;
import dev.fs.demo.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface LoginMapper {
    User toEntity(LoginDTO loginDTO);

    LoginDTO toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(LoginDTO loginDTO, @MappingTarget User user);
}