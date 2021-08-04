package tma.interns.roomsharing.service.roomshare;

import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;

import java.util.List;

public interface IRoomSharingService {
    RoomSharingDto newRoomSharing (RoomSharingDto roomSharing);
    List<RoomSharingDto> listAll();

}
