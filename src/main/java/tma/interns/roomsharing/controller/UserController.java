package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.entity.UserEntity;
import tma.interns.roomsharing.service.IUserService;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


    @GetMapping("/user")
    public List<UserEntity> list() {
        try {
            return userService.listAll();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @GetMapping("/user/{user_id}")
    public ResponseEntity<UserBasicDto> get(@PathVariable UUID user_id) {
        try {
            UserBasicDto user = userService.getById(user_id);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/user")
    public void create(@RequestBody UserCreateDto newUser) {
        try {
            userService.createUser(newUser);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<UserEntity> update(@RequestBody UserBasicDto user, @PathVariable UUID user_id) {
        try {
//            UserEntity editUser = userService.getById(user_id);
            userService.updateUser(user, user_id);
            return new ResponseEntity<UserEntity>(HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/user/{user_id}")
    public void delete (@RequestParam (name = "user_id") UUID user_id) throws Exception{
        try {
            userService.delete(user_id);
        }
        catch (Exception ex){
            throw ex;
        }
    }
}
