package tma.interns.roomsharing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "user_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID userId;

    private String user_name;
    private String password;
    public String name;
    public String email;
    public String address;
    public String number_phone;
    public Date date_of_birth;
    public boolean gender;
    public String avatar_url;
    public Enum role;
}
