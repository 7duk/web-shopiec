package codes.rytis.logindemo.service;

import codes.rytis.logindemo.dto.response.Response;
import codes.rytis.logindemo.entity.User;
import codes.rytis.logindemo.dto.user.UserRegisterDto;
import codes.rytis.logindemo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    @Transactional
    public Optional<User> findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
    @Transactional
    public ResponseEntity<?> registerUser(UserRegisterDto request) {
        Optional<User> users   = findUserByEmail(request.getEmail());
        if(!users.isEmpty()){
            return ResponseEntity.ok().body(Response.builder().message("EMAIL IS ALREADY EXIST").build());
        }
        LocalDate dateUser = LocalDate.parse(request.getDateOfBirth(),DateTimeFormatter.ofPattern("yyyy-MM-dd")) ;
        System.out.println(dateUser.toString());
        repository.saveUser(request.getFirstName(),
                request.getLastName(),
                dateUser,
                request.getAddress(),
                request.getPhone(),
                request.getGender(),
                request.getEmail(),
                request.getPassword(),
                1);
        return ResponseEntity.ok().body(Response.builder().message("REGISTER USER SUCCESS").build());
    }
}
