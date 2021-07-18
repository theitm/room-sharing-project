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
    public ResponseEntity<List<UserBasicDto>> list() {
        try {
            List<UserBasicDto> users = userService.listAll();
            return new ResponseEntity<>(users, HttpStatus.OK);

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
    public  ResponseEntity<UserBasicDto> create(@RequestBody UserCreateDto newUser) {
        try {
            UserBasicDto userReturn = userService.createUser(newUser);
            return new ResponseEntity<>(userReturn,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<UserBasicDto> update(@RequestBody UserBasicDto user, @PathVariable UUID user_id) {
        try {
            UserBasicDto userDto = userService.updateUser(user,user_id);
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping ("/user/{user_id}")
    public void delete (@RequestParam (name = "user_id") UUID user_id) throws Exception{

        // TODO: fix
        try {
            userService.delete(user_id);
        }
        catch (Exception ex){
            throw ex;
        }
    }
}
