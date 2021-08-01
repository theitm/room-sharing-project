package tma.interns.roomsharing.mapper;

import org.mapstruct.Mapper;
import tma.interns.roomsharing.dto.roomshare.RoomShareDetailDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IRoomShareDetailMapper {
    RoomShareDetailEntity fromSharesDtoToSharesEntity (RoomShareDetailDto dto);
    RoomShareDetailDto toSharesDto(RoomShareDetailEntity roomShareDetailEntity);
    List<RoomShareDetailDto> toShareDetailDto(List<RoomShareDetailEntity> details);
}
