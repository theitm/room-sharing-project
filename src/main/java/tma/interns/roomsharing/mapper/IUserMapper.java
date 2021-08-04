package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.dto.user.UserInfoDto;
import tma.interns.roomsharing.entity.UserEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IUserMapper {
    UserEntity fromCreateToEntity(UserCreateDto dto);
    UserBasicDto toBasicDto(UserEntity userEntity);
    UserCreateDto toCreateDto(UserEntity userEntity);
    UserInfoDto toInfoDto(UserEntity userEntity);
    List<UserBasicDto> toBasicDtos(List<UserEntity> users);
}
