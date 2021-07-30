package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoomInfoMapper {

    RoomInfoEntity fromCreateToEntity(RoomInfoCreateDto dto);
    RoomInfoBasicDto toBasicDto(RoomInfoEntity returnRoom);
    RoomInfoEntity fromBasicToEntity(RoomInfoBasicDto dto);
    List<RoomInfoBasicDto> toRoomDtos(List<RoomInfoEntity> roomInfo);
}
