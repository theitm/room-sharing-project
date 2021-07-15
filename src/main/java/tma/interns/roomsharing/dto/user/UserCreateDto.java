package tma.interns.roomsharing.dto.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserCreateDto {
    private String user_name;
    private String password;
    public String name;
    public String email;
    public String address;
    public String number_phone;
    public Date date_of_birth;
    public boolean gender;
    public String avatar_url;
}
