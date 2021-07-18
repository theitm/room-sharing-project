package tma.interns.roomsharing.dto.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserBasicDto {
    public String name;
    public String email;
    public String address;
    public String phone;
}
