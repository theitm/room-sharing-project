package tma.interns.roomsharing.service.roomshare;

import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;

import java.util.UUID;

public interface IRoomSharingService {
    RoomSharingDto newRoomSharing (RoomSharingDto roomSharing);
   // RoomSharingDto getById (RoomSharingDto room, UUID roomSharingId);
}
