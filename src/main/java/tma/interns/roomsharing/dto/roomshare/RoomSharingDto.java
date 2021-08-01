package tma.interns.roomsharing.dto.roomshare;

import lombok.Data;

import java.util.UUID;
@Data
public class RoomSharingDto {
    private UUID roomSharingId;
    private UUID roomId;
}
