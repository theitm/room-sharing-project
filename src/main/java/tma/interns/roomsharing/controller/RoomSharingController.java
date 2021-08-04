package tma.interns.roomsharing.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;
import tma.interns.roomsharing.service.roomshare.IRoomSharingService;

import java.util.NoSuchElementException;

@RestController
public class RoomSharingController {
    private final IRoomSharingService roomSharingService;

    public RoomSharingController(IRoomSharingService roomSharingService) {
        this.roomSharingService = roomSharingService;
    }
    @PostMapping("/sharing")
    public ResponseEntity<RoomSharingDto> newRoomSharing (@RequestBody RoomSharingDto newSharing){
        try {
            RoomSharingDto created = roomSharingService.newRoomSharing(newSharing);
            return new ResponseEntity<>(created, HttpStatus.OK);
        } catch (NoSuchElementException ex) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
