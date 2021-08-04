package tma.interns.roomsharing.service.roomShareDetail;

import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;

import java.util.List;
import java.util.UUID;

public interface IRoomShareDetailService {
    boolean delete (UUID roomShareDetailId);
    List<RoomShareDetailDto> listAll();
    RoomShareDetailDto createDetail(RoomShareCreateDto roomShareCreateDto);
}
