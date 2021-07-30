package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.service.IRoomInfoService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class RoomInfoController {
    private final IRoomInfoService roomInfoService;

    public RoomInfoController(IRoomInfoService roomInfoService ) {
        this.roomInfoService = roomInfoService;
    }
    @GetMapping("/room")
    public ResponseEntity<List<RoomInfoBasicDto>> list(){
        try {
            List<RoomInfoBasicDto> rooms = roomInfoService.listAll();
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/room")
    public  ResponseEntity<RoomInfoBasicDto> create(@RequestBody RoomInfoCreateDto newRoomInfo) {
        try {
            RoomInfoBasicDto roomInfoReturn = roomInfoService.createRoomInfo(newRoomInfo);
            return new ResponseEntity<>(roomInfoReturn,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/room/{room_id}")
    public ResponseEntity<RoomInfoBasicDto> get(@PathVariable UUID room_id) {
        try {
            RoomInfoBasicDto room = roomInfoService.getById(room_id);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/room/{room_id}")
    public ResponseEntity<RoomInfoBasicDto> update(@RequestBody RoomInfoBasicDto room, @PathVariable UUID room_id) {
        try {
            RoomInfoBasicDto roomInfoDto = roomInfoService.updateRoomInfo(room,room_id);
            return new ResponseEntity<>(roomInfoDto,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/room/{room_id}")
    public ResponseEntity<RoomInfoBasicDto> delete(@PathVariable UUID room_id) {
        try {
            if(roomInfoService.delete(room_id)){
                return new ResponseEntity<>(HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
}
