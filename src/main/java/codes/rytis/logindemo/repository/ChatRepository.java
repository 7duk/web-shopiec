package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Optional;

@Repository
public interface ChatRepository extends JpaRepository<Chat,Long> {
    @Modifying
    @Query(value = "INSERT INTO chat (PARTICIPANTL_1,PARTICIPANTL_2) VALUES(:param1,:param2) ",nativeQuery = true)
    int saveChat(@Param("param1")Integer PARTICIPANTL_1, @Param("param2") Integer PARTICIPANTL_2);
    @Query(value = "SELECT * FROM chat WHERE chat.PARTICIPANTL_2 = :param2  AND  chat.PARTICIPANTL_1 =:param1",nativeQuery = true)
    Optional<Chat> findChatByPARTICIPANT(@Param("param1") Integer PARTICIPANTL_1,@Param("param2") Integer PARTICIPANTL_2);

}
