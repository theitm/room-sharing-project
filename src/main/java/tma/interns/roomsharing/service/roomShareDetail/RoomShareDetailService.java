package tma.interns.roomsharing.service.roomShareDetail;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareCreateDto;
import tma.interns.roomsharing.dto.roomShareDetail.RoomShareDetailDto;
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
//Thuy devTeam DG5
    public RoomShareDetailDto createDetail(RoomShareCreateDto roomShareCreateDto) {
        RoomShareDetailEntity roomShareDetailEntity = roomShareDetailMapper.fromCreateDtoToEntity(roomShareCreateDto);
        RoomShareDetailEntity returnShareDetail = roomShareDetailRepo.save(roomShareDetailEntity);
        return roomShareDetailMapper.toDetailDto(returnShareDetail);
    }

    public boolean delete(UUID roomSharesId) {
        RoomShareDetailEntity roomShareDetailEntity =roomShareDetailRepo.findFirstByRoomShareDetailId(roomSharesId);
        if(roomShareDetailEntity != null){
            roomShareDetailRepo.deleteById(roomSharesId);
            return true;
        }
        return false;
    }

    public List<RoomShareDetailDto> listAll() {
        List<RoomShareDetailEntity> details = roomShareDetailRepo.findAll();
        if( details.size()>0){
            return roomShareDetailMapper.toDetailDtos(details);
        }
        return new ArrayList<>();
    }
}
