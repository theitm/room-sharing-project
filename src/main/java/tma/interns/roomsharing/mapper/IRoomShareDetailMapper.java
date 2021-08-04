package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoomShareDetailMapper {
    RoomShareDetailEntity fromCreateDtoToEntity (RoomShareCreateDto roomShareCreateDto);
    RoomShareDetailDto toDetailDto (RoomShareDetailEntity roomShareDetailEntity);
    List<RoomShareDetailDto> toDetailDtos(List<RoomShareDetailEntity> roomShareDetailEntities);
}
