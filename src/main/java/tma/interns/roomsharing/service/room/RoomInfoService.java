package tma.interns.roomsharing.service.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.file.FileDto;
import tma.interns.roomsharing.dto.room.RoomInfoBasicDto;
import tma.interns.roomsharing.dto.room.RoomInfoDetailDto;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;
import tma.interns.roomsharing.enumration.FileType;
import tma.interns.roomsharing.enumration.FileParentType;
import tma.interns.roomsharing.mapper.IRoomInfoMapper;
import tma.interns.roomsharing.repository.RoomInfoRepository;
import tma.interns.roomsharing.service.file.FileService;
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
    private final FileService fileService;
    @Autowired
    private JwtUtil jwtTokenUtil;

    private final IRoomInfoMapper roomMapper;
    public RoomInfoService(RoomInfoRepository roomRepo, IRoomInfoMapper roomMapper,
                           FileService fileService){
        this.roomRepo = roomRepo;
        this.roomMapper = roomMapper;
        this.fileService = fileService;
    }
    public List<RoomInfoBasicDto> listAll() {
        List<RoomInfoEntity> roomInfo = roomRepo.findAll();
        if(roomInfo.size() > 0){
            return roomMapper.toBasicDtos(roomInfo);
        }
        return new ArrayList<>();
    }
    public RoomInfoDetailDto getById(UUID roomId){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(roomId);
        if(roomInfoEntity != null) {
            RoomInfoDetailDto result = roomMapper.toDetailDto(roomInfoEntity);
            //Get list file of this room
            List<FileDto> listFiles = fileService.getByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
            result.setFiles(listFiles);
            return result;
        } else {
            return null;
        }
    }

    public boolean delete(UUID roomId){
        RoomInfoEntity roomInfoEntity = roomRepo.findFirstByRoomId(roomId);
        if(roomInfoEntity != null){
            roomRepo.deleteByRoomId(roomId);
            //Get list file of this room
            fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
            return true;
        }
        return false;
    }
    public RoomInfoDetailDto updateRoomInfo (RoomInfoDetailDto dto, UUID roomId){
        RoomInfoEntity roomInfoEntity = roomMapper.fromBasicToEntity(dto);
        roomInfoEntity.setRoomId(roomId);
        RoomInfoEntity returnRoom = roomRepo.saveAndFlush(roomInfoEntity);
        //Update files
        fileService.deleteByParentTypeAndParentId(FileParentType.Room.getValue(), roomId);
        dto.getFiles().forEach((file) -> {
            file.setParentType(FileParentType.Room.getValue());
            file.setParentId(returnRoom.getRoomId());
            file.setType(FileType.Image);
            fileService.createFile(file);
        });
        return roomMapper.toDetailDto(returnRoom);
    }
    @Override
    public RoomInfoDetailDto createRoomInfo(RoomInfoCreateDto rooms) {
        rooms.setDate((new Date()));
        RoomInfoEntity roomInfoEntity = roomMapper.fromCreateToEntity(rooms);
        RoomInfoEntity returnRoom = roomRepo.save(roomInfoEntity);
        rooms.getFiles().forEach((file) -> {
            file.setParentType(FileParentType.Room.getValue());
            file.setParentId(returnRoom.getRoomId());
            file.setType(FileType.Image);
            fileService.createFile(file);
        });
        return roomMapper.toDetailDto(returnRoom);
    }
}
