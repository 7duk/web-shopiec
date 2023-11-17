//package codes.rytis.logindemo.security;
//
//import codes.rytis.logindemo.service.UserService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//    private final UserService userService;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        System.out.println("111");
//        var user = userService.findUserByEmail(username).orElseThrow();
//        System.out.println(user.toString());
//        return UserPrincipal.builder()
//                .userId(user.getId())
//                .email(user.getEmail())
//                .password(user.getPassword())
//                .authorities(List.of(new SimpleGrantedAuthority(user.getRole().getName())))
//                .build();
//    }
//}
