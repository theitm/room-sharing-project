package tma.interns.roomsharing.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name ="rooms")
public class RoomInfoEntity {
    @Id
    @GeneratedValue(generator = "uuid2", strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name= "room_id", columnDefinition = "CHAR(36)")
    @Type(type="uuid-char")
    private UUID roomId;
    @Column(name="user_id")
    private UUID userId;
    @Column(name="province_id")
    private UUID provinceId;
    @Column(name="district_id")
    private UUID districtId;
    @Column(name= "ward_id")
    private UUID wardId;
    private String address;
    private Float acreage;
    @Column(name= "room_price")
    private Integer roomPrice;
    private String describe;

}
