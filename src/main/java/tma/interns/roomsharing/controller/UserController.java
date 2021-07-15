package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.service.UserService;


import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<UserEntity> list(){
       try{
            return  userService.listAll();
       }
       catch ( Exception ex){
            throw  ex;
       }
    }

    @GetMapping ("/user/{user_id}")
    public ResponseEntity<UserEntity> get(@PathVariable String user_id){
        try {
            UserEntity user = userService.getById(user_id);
            return new ResponseEntity<UserEntity>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException ex){
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }
    }
}
