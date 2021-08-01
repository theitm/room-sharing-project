package tma.interns.roomsharing.dto.user;

import lombok.Data;
import java.util.Date;


@Data
public class UserBasicDto {
    private String name;
    private String email;
    private String address;
    private String phone;
    private Date birthDate;
    private boolean gender;
    private String avatarUrl;
}
