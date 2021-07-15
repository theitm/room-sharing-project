package tma.interns.roomsharing.service;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.mapper.IUserMapper;
import tma.interns.roomsharing.repository.UserRepository;

import javax.transaction.Transactional;
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

    public List <UserEntity> listAll() {
        return userRepo.findAll();
    }

    public void createUser (UserCreateDto user) {
        UserEntity userEntity = userMapper.fromCreateToEntity(user);
        userRepo.save(userEntity);
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
}
