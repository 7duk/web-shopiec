package codes.rytis.logindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "comment")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Comment  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CONTENT_CMT")
    private String content;
    @Column(name = "CREATE_AT")
    private LocalDateTime time;
    @Column(name = "RATING")
    private Integer rating;
    @Column(name = "IS_DELETE")
    private Integer isDelete;
    @Column(name = "USER_ID")
    private Integer userId;
    @Column(name = "ITEM_ID")
    private Integer itemId;
}
