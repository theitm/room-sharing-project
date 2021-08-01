package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tma.interns.roomsharing.dto.roomshare.RoomShareDetailDto;
import tma.interns.roomsharing.service.roomshare.IRoomShareDetailService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@RestController
public class RoomShareDetailController {
    private final IRoomShareDetailService roomShareDetailService;

    public RoomShareDetailController(IRoomShareDetailService roomShareDetailService) {
        this.roomShareDetailService = roomShareDetailService;
    }

    @PostMapping("/sharingdetail")
    public ResponseEntity<RoomShareDetailDto> createDetail(@RequestBody RoomShareDetailDto newShares) {
        try {
            RoomShareDetailDto createdDetail = roomShareDetailService.createShares(newShares);
            return new ResponseEntity<>(createdDetail, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/sharingdetail/{roomSharesId}")
    public ResponseEntity<HttpStatus> delete(@PathVariable UUID roomSharesId) {
        try {
            roomShareDetailService.delete(roomSharesId);
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
