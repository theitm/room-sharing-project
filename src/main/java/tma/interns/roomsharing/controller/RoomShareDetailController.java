package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.service.roomShareDetail.IRoomShareDetailService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class RoomShareDetailController {
    private final IRoomShareDetailService roomShareDetailService;

    public RoomShareDetailController(IRoomShareDetailService roomShareDetailService) {
        this.roomShareDetailService = roomShareDetailService;
    }

//Thuy devTeam DG5
    @PostMapping("/sharingdetail")
    public ResponseEntity<RoomShareDetailDto> createDetail(@RequestBody RoomShareCreateDto newShareDetail) {
        try {
            RoomShareDetailDto createdDetail = roomShareDetailService.createDetail(newShareDetail);
            return new ResponseEntity<>(createdDetail, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/sharingdetail/{roomShareDetailId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID roomShareDetailId) {
        try {
            roomShareDetailService.delete(roomShareDetailId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/sharingdetail")
    public ResponseEntity<List<RoomShareDetailDto>> list(){
        try {
            List<RoomShareDetailDto> shareDetails = roomShareDetailService.listAll();
            return new ResponseEntity<>(shareDetails, HttpStatus.OK);
        }
        catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
