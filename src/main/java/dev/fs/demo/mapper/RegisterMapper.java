package dev.fs.demo.mapper;

import dev.fs.demo.dto.RegisterDTO;
import dev.fs.demo.model.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RegisterMapper {
    User toEntity(RegisterDTO registerDTO);

    RegisterDTO toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(RegisterDTO registerDTO, @MappingTarget User user);
}