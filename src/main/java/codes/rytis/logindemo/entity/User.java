package codes.rytis.logindemo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Blob;
import java.time.LocalDate;

/**
 * This would be JPA managed entity or Mongo document, but for this example it's just a POJO
 */

@Table(name = "user")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Column(name="ADDRESS")
    private String address;
    @Column(name = "PHONE")
    private String phone;
    @Column(name = "GENDER")
    private Integer gender;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ROLE_ID")
    private Integer roleId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ROLE_ID",insertable=false, updatable=false)
    private Role role;
    @Column(name = "IS_DELETE")
    private Boolean isDelete;
    @Column(name = "IMAGE")
    private byte[] image;
    public User(String firstName,String lastName,Integer gender,Integer roleId,byte[] image){
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.roleId = roleId;
        this.image = image;
    }

}
