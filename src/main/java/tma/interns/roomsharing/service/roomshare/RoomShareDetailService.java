package tma.interns.roomsharing.service.roomshare;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomshare.RoomShareDetailDto;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;
import tma.interns.roomsharing.mapper.IRoomShareDetailMapper;
import tma.interns.roomsharing.repository.RoomShareDetailRepo;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoomShareDetailService implements IRoomShareDetailService{
    private  final RoomShareDetailRepo roomShareDetailRepo;
    private final IRoomShareDetailMapper roomShareDetailMapper;

    public RoomShareDetailService(RoomShareDetailRepo roomShareDetailRepo, IRoomShareDetailMapper roomShareDetailMapper) {
        this.roomShareDetailRepo = roomShareDetailRepo;
        this.roomShareDetailMapper = roomShareDetailMapper;
    }

    public RoomShareDetailDto createShares(RoomShareDetailDto roomShareDetail) {
        RoomShareDetailEntity roomShareDetailEntity = roomShareDetailMapper.fromSharesDtoToSharesEntity(roomShareDetail);
        RoomShareDetailEntity returnShares = roomShareDetailRepo.save(roomShareDetailEntity);
        return roomShareDetailMapper.toSharesDto(returnShares);
    }


    public boolean delete(UUID roomSharesId) {
        RoomShareDetailEntity roomShareDetailEntity =roomShareDetailRepo.findFirstByRoomSharesId(roomSharesId);
        if(roomShareDetailEntity != null){
            roomShareDetailRepo.deleteById(roomSharesId);
            return true;
        }
        return false;
    }

    public List<RoomShareDetailDto> listAll() {
        List<RoomShareDetailEntity> details = roomShareDetailRepo.findAll();
        if( details.size()>0){
            return roomShareDetailMapper.toShareDetailDto(details);
        }
        return new ArrayList<>();
    }
}
