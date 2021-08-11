package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoDetailDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.service.room.IRoomInfoService;

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
    public  ResponseEntity<RoomInfoDetailDto> create(@RequestBody RoomInfoCreateDto newRoomInfo) {
        try {
            RoomInfoDetailDto roomInfoReturn = roomInfoService.createRoomInfo(newRoomInfo);
            return new ResponseEntity<>(roomInfoReturn,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/room/{roomId}")
    public ResponseEntity<RoomInfoDetailDto> get(@PathVariable UUID roomId) {
        try {
            RoomInfoDetailDto room = roomInfoService.getById(roomId);
            return new ResponseEntity<>(room, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/room/{roomId}")
    public ResponseEntity<RoomInfoDetailDto> update(@RequestBody RoomInfoDetailDto room, @PathVariable UUID roomId) {
        try {
            RoomInfoDetailDto roomInfoDto = roomInfoService.updateRoomInfo(room,roomId);
            return new ResponseEntity<>(roomInfoDto,HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/room/{roomId}")
    public ResponseEntity<RoomInfoBasicDto> delete(@PathVariable UUID roomId) {
        try {
            if(roomInfoService.delete(roomId)){
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
