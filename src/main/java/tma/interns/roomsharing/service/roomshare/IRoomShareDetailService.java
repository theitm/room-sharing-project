package tma.interns.roomsharing.service.roomshare;

import tma.interns.roomsharing.dto.roomshare.RoomShareDetailDto;

import java.util.List;
import java.util.UUID;

public interface IRoomShareDetailService {
    RoomShareDetailDto createShares (RoomShareDetailDto roomShareDetail);
    boolean delete (UUID roomSharesId);
    List<RoomShareDetailDto> listAll();
}
