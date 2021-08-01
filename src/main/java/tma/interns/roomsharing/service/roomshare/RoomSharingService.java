package tma.interns.roomsharing.service.roomshare;

import org.springframework.stereotype.Service;
import tma.interns.roomsharing.dto.roomshare.RoomSharingDto;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
@Transactional
public class RoomSharingService implements IRoomSharingService{
    @Override
    public RoomSharingDto newRoomSharing(RoomSharingDto roomSharing) {
        return null;
    }

    @Override
    public RoomSharingDto getById(RoomSharingDto room, UUID roomSharingId) {
        return null;
    }

    @Override
    public boolean delete(UUID roomSharingId) {
        return false;
    }
}
