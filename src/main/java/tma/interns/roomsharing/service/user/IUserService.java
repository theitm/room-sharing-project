package tma.interns.roomsharing.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import tma.interns.roomsharing.dto.authentication.AuthenticationRequestDto;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.dto.user.UserInfoDto;

import java.util.List;
import java.util.UUID;

public interface IUserService {

    UserCreateDto createUser(UserCreateDto user);
    UserBasicDto getById(UUID user_id);
    boolean delete(UUID user_id);
    UserBasicDto updateUser(UserCreateDto dto, UUID userId);
    List<UserBasicDto> listAll();
    UserInfoDto login(AuthenticationRequestDto authenticationRequestDto);
    UserDetails loadUserByUsername(String userName);
}
