package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.dto.RegisterRequest;
import codes.rytis.logindemo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
     String INSERT_USER = "INSERT INTO  user(FIRST_NAME,LAST_NAME,DATE_OF_BIRTH,ADDRESS,PHONE,GENDER,EMAIL,PASSWORD,ROLE_ID)\n " +
            "\tVALUES(:FIRST_NAME,:LAST_NAME,:DATE_OF_BIRTH,:ADDRESS,:PHONE,:GENDER,:EMAIL,:PASSWORD,:ROLE_ID) ";
    @Modifying
    @Query(value = INSERT_USER,nativeQuery = true)
    void saveUser(@Param("FIRST_NAME") String firstName,
                    @Param("LAST_NAME") String lastName,
                    @Param("DATE_OF_BIRTH")LocalDate dateOfBirth,
                    @Param("ADDRESS") String address,
                    @Param("PHONE") String phone,
                    @Param("GENDER") Integer gender,
                    @Param("EMAIL") String email,
                    @Param("PASSWORD") String password,
                    @Param("ROLE_ID") Integer roleId);
    @Query(value = "SELECT * FROM user WHERE user.EMAIL=:EMAIL",nativeQuery = true)
    Optional<User> findUserByEmail(@Param("EMAIL") String mail);
}
