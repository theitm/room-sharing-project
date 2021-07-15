package tma.interns.roomsharing.service;

import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    List<UserEntity> listAll();
    void createUser(UserCreateDto user);
    UserBasicDto getById(UUID user_id);
    void delete(UUID user_id);
}
