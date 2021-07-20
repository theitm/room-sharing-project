package tma.interns.roomsharing.service;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.mapper.IUserMapper;
import tma.interns.roomsharing.repository.UserRepository;
import tma.interns.roomsharing.service.IUserService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class UserService implements IUserService {
    private final UserRepository userRepo;


    private final IUserMapper userMapper;
    public UserService(UserRepository userRepo, IUserMapper userMapper) {
        this.userRepo = userRepo;
        this.userMapper = userMapper;
    }

    public List <UserBasicDto> listAll() {
        List<UserEntity> users = userRepo.findAll();
        if(users != null && users.size() >0){
            return userMapper.toBasicDtos(users);
        }
        return new ArrayList<>();
    }


    public UserBasicDto createUser (UserCreateDto user) {
        UserEntity userEntity = userMapper.fromCreateToEntity(user);
        UserEntity returnUser = userRepo.save(userEntity);
        return userMapper.toBasicDto(returnUser);
    }
    public UserBasicDto getById(UUID user_id){
        UserEntity userEntity = userRepo.findFirstByUserId(user_id);
        if(userEntity != null) {
            return userMapper.toBasicDto(userEntity);
        }
        return null;
    }
    public void delete(UUID user_id){
        userRepo.deleteById(user_id);
    }
    public UserBasicDto updateUser(UserBasicDto dto, UUID userId) {
        UserEntity userEntity = userMapper.fromBasicToEntity(dto);
        userEntity.setUserId(userId);
        UserEntity returnUser = userRepo.saveAndFlush(userEntity);
        return userMapper.toBasicDto(returnUser);
    }
}
