package codes.rytis.logindemo.controller;

import codes.rytis.logindemo.dto.user.UserRegisterDto;
import codes.rytis.logindemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody @Validated UserRegisterDto request){
        System.out.println(request.toString());
         return  userService.registerUser(request);
    }
    //change password
    //

}
