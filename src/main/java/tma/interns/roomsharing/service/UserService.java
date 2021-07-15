package tma.interns.roomsharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepo;
    public List <UserEntity> listAll(){return userRepo.findAll();    }
    public void save (UserEntity user) {
        userRepo.save(user);
    }
    public UserEntity getById(String user_id){
        return userRepo.findById(user_id).get();
    }
    public void delete(String user_id){
        userRepo.deleteById(user_id);
    }
}
