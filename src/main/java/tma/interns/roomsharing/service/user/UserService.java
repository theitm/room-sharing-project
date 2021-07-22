package tma.interns.roomsharing.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.authentication.AuthenticationRequestDto;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.dto.user.UserInfoDto;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.mapper.IUserMapper;
import tma.interns.roomsharing.repository.UserRepository;
import tma.interns.roomsharing.dto.user.UserLoginDto;
import tma.interns.roomsharing.util.JwtUtil;

import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class UserService implements IUserService{
    private final UserRepository userRepo;
    @Autowired
    private JwtUtil jwtTokenUtil;


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
//hieu
    @Override
    public UserInfoDto login(AuthenticationRequestDto authenticationRequestDto) {
        UserEntity userEntity = userRepo.findFirstByUserNameAndPassword(authenticationRequestDto.getUsername(),
                authenticationRequestDto.getPassword());
        if (userEntity != null) {
            //Generate token
            UserDetails userDetails = this.loadUserByUsername(authenticationRequestDto.getUsername());
            final String token = jwtTokenUtil.generateToken(userDetails);

            UserInfoDto userInfoDto = userMapper.toInfoDto(userEntity);
            userInfoDto.setToken(token);
            return userInfoDto;
        }
        return null;
    }

    public UserBasicDto createUser (UserCreateDto user) {
        UserEntity userEntity = userMapper.fromCreateToEntity(user);
        userEntity.setPassword(Base64.getEncoder().encodeToString((user.getUserName() + ":" + user.getPassword()).getBytes()));
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
    public boolean delete(UUID user_id){
        UserEntity userEntity = userRepo.findFirstByUserId(user_id);
        if(userEntity != null) {
            userRepo.deleteByUserId(user_id);
            return true;
        }
        return false;
    }
    public UserBasicDto updateUser(UserBasicDto dto, UUID userId) {
        UserEntity userEntity = userMapper.fromBasicToEntity(dto);
        userEntity.setUserId(userId);
        UserEntity returnUser = userRepo.saveAndFlush(userEntity);
        return userMapper.toBasicDto(returnUser);
    }
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepo.findByUserName(userName);
        user.orElseThrow(()-> new UsernameNotFoundException("Not found"+userName));
        return user.map(UserLoginDto::new).get();
    }
}
