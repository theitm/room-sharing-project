package tma.interns.roomsharing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;
import tma.interns.roomsharing.mapper.IRoomInfoMapper;
import tma.interns.roomsharing.repository.RoomInfoRepository;
import tma.interns.roomsharing.util.JwtUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class RoomInfoService implements IRoomInfoService {
    private final  RoomInfoRepository roomRepo;

    @Autowired
    private JwtUtil jwtTokenUtil;

    private final IRoomInfoMapper roomMapper;
    public RoomInfoService(RoomInfoRepository roomRepo, IRoomInfoMapper roomMapper){
        this.roomRepo = roomRepo;
        this.roomMapper = roomMapper;
    }
    public List<RoomInfoBasicDto> listAll() {
        List<RoomInfoEntity> roomInfo = roomRepo.findAll();
        if(roomInfo.size() > 0){
            return roomMapper.toRoomDtos(roomInfo);
        }
        return new ArrayList<>();
    }
    public RoomInfoBasicDto getById(UUID room_id){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(room_id);
        if(roomInfoEntity != null) {
            return roomMapper.toBasicDto(roomInfoEntity);
        }
        return null;
    }

    public RoomInfoBasicDto createRoomInfo (RoomInfoCreateDto room){
        room.setDate((new Date()));
        RoomInfoEntity roomEntity = roomMapper.fromCreateToEntity(room);
        RoomInfoEntity returnRoom = roomRepo.save(roomEntity);
        return roomMapper.toBasicDto(returnRoom);
    }
    public boolean delete(UUID room_id){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(room_id);
        if(roomInfoEntity != null){
            roomRepo.deleteByRoomId(room_id);
            return true;
        }
        return false;
    }
    public RoomInfoBasicDto updateRoomInfo (RoomInfoBasicDto dto, UUID roomId){
        RoomInfoEntity roomInfoEntity = roomMapper.fromBasicToEntity(dto);
        roomInfoEntity.setRoomId(roomId);
        RoomInfoEntity returnRoom = roomRepo.saveAndFlush(roomInfoEntity);
        return roomMapper.toBasicDto(returnRoom);
    }

}
