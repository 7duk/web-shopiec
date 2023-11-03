package codes.rytis.logindemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
@Data
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private Integer gender;
    private String phone;
    private String address;
    private String email;
    private String password;
}
