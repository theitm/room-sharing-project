package tma.interns.roomsharing.dto.room;

import lombok.Data;
import tma.interns.roomsharing.dto.user.UserBasicDto;
import tma.interns.roomsharing.enumration.RoomType;
import tma.interns.roomsharing.enumration.StatusType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;

@Data
public class RoomInfoBasicDto {
    private UUID roomId;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private UUID userId;
    private UUID provinceId;
    private UUID districtId;
    private UUID wardId;
    private String address;
    private Float acreage;
    private Integer roomPrice;
    private String roomDescribe;
    @Enumerated(EnumType.STRING)
    private StatusType statusHired;
    private Date date;
    private UserBasicDto user;
}
