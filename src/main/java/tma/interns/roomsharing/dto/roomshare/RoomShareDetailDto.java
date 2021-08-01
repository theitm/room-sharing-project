package tma.interns.roomsharing.dto.roomshare;

import lombok.Data;
import tma.interns.roomsharing.enumration.ShareRole;

import java.util.UUID;
@Data
public class RoomShareDetailDto {
    private UUID roomSharingId;
    private UUID userId;
    private ShareRole role;
}
