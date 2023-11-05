package codes.rytis.logindemo.dto.login;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginDto {
    private final String email;
    private final String password;
}
