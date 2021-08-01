package tma.interns.roomsharing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tma.interns.roomsharing.entity.RoomShareDetailEntity;

import java.util.UUID;

public interface RoomShareDetailRepo extends JpaRepository <RoomShareDetailEntity, UUID> {
    RoomShareDetailEntity findFirstByRoomSharesId (UUID roomSharesId);
    void  deleteById (UUID roomSharesId);
}
