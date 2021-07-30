package tma.interns.roomsharing.service;

import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;

import java.util.List;
import java.util.UUID;

public interface IRoomInfoService {

    RoomInfoBasicDto createRoomInfo(RoomInfoCreateDto user);
    RoomInfoBasicDto getById(UUID room_id);
    boolean delete(UUID room_id);
    RoomInfoBasicDto updateRoomInfo (RoomInfoBasicDto dto, UUID roomId);
    List<RoomInfoBasicDto> listAll();
}
