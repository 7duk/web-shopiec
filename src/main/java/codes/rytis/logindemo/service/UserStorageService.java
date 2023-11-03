//package codes.rytis.logindemo.service;
//
//import codes.rytis.logindemo.entity.User;
//import codes.rytis.logindemo.repository.UserRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//@Service
//public class UserStorageService {
//    private  UserRepository repository;
//    private Set<User> listUser;
//    private static UserStorageService instance;
//    public UserStorageService(){
//        listUser = new HashSet<>();
//    }
//    public static synchronized UserStorageService getInstance(){
//        if(UserStorageService.instance == null){
//            instance = new UserStorageService();
//        }
//        return  instance;
//    }
//    public Set<User> getUsers(){
//        List<User> users = repository.findAll();
//        users.stream().map(e->listUser.add(e));
//        return listUser;
//    }
//    public Set<User> setUserToUsers(User user) throws Exception {
//        if(listUser.contains(user)){
//            throw  new Exception("User already exits !");
//        }
//        return listUser;
//    }
//}
