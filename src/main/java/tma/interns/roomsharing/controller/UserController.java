package tma.interns.roomsharing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.authentication.AuthenticationRequestDto;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.dto.user.UserCreateDto;
import tma.interns.roomsharing.dto.user.UserInfoDto;
import tma.interns.roomsharing.service.user.IUserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserBasicDto>> list() {
        try {
            List<UserBasicDto> users = userService.listAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
       catch (NoSuchElementException ex) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    public  ResponseEntity<UserCreateDto> create(@RequestBody UserCreateDto newUser) {
        try {
            UserCreateDto userReturn = userService.createUser(newUser);
            return new ResponseEntity<>(userReturn,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/user/{user_id}")
    public ResponseEntity<UserBasicDto> update(@RequestBody UserCreateDto user, @PathVariable UUID user_id) {
        try {
            UserBasicDto userDto = userService.updateUser(user,user_id);
            return new ResponseEntity<>(userDto,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{user_id}")
    public ResponseEntity<UserBasicDto> delete(@PathVariable UUID user_id) {
        try {
            if(userService.delete(user_id)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }


    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequestDto) throws Exception {
        UserInfoDto userInfoDto = userService.login(authenticationRequestDto);
        return new ResponseEntity<>(userInfoDto, HttpStatus.OK);
    }
}
