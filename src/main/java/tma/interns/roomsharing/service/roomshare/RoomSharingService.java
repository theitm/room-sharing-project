package tma.interns.roomsharing.service.roomshare;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDto;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;
import tma.interns.roomsharing.entity.RoomSharingEntity;
import tma.interns.roomsharing.enumration.ShareRole;
import tma.interns.roomsharing.mapper.IRoomSharingMapper;
import tma.interns.roomsharing.repository.RoomSharingRepo;
import tma.interns.roomsharing.service.roomShareDetail.IRoomShareDetailService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class RoomSharingService implements IRoomSharingService{
    private final RoomSharingRepo roomSharingRepo;
    private final IRoomSharingMapper roomSharingMapper;
    private final IRoomShareDetailService roomShareDetailService;

    public RoomSharingService(RoomSharingRepo roomSharingRepo, IRoomSharingMapper roomSharingMapper, IRoomShareDetailService roomShareDetailService) {
        this.roomSharingRepo = roomSharingRepo;
        this.roomSharingMapper = roomSharingMapper;
        this.roomShareDetailService = roomShareDetailService;
    }

    public RoomSharingDto newRoomSharing(RoomSharingDto roomSharing) {
        RoomSharingEntity roomSharingEntity = roomSharingMapper.fromSharingDtoToEntity(roomSharing);
        roomSharingEntity = roomSharingRepo.save(roomSharingEntity);
        roomShareDetailService.createDetail(RoomShareCreateDto.builder().
                roomSharingId(roomSharingEntity.getRoomSharingId()).role(ShareRole.Key).build());
        return roomSharingMapper.toRoomSharingDto(roomSharingEntity);
    }

    @Override
    public List<RoomSharingDto> listAll() {
        List<RoomSharingEntity> roomSharingList = roomSharingRepo.findAll();
        if( roomSharingList.size()>0){
            return roomSharingMapper.toRoomSharingDtos(roomSharingList);
        }
        return new ArrayList<>();
    }

}
