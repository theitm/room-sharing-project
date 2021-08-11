package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tma.interns.roomsharing.dto.room.RoomInfoCreateDto;
import tma.interns.roomsharing.entity.RoomInfoEntity;

import java.util.UUID;

@Repository
public interface RoomInfoRepository extends JpaRepository<RoomInfoEntity, UUID> {
    RoomInfoEntity findFirstByRoomId(UUID roomId);
//    RoomInfoEntity findFirstByRoomId(UUID rooms);
    void deleteByRoomId(UUID rooms);
}
