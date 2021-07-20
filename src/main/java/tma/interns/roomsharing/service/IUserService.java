package tma.interns.roomsharing.service;

import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserBasicDto createUser(UserCreateDto user);
    UserBasicDto getById(UUID user_id);
    void delete(UUID user_id);
    UserBasicDto updateUser(UserBasicDto dto, UUID userId);

    List<UserBasicDto> listAll();
}
