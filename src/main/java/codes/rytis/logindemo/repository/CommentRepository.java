package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Comment;
import codes.rytis.logindemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Integer> {
    String INSERT_CMT = "INSERT INTO comment(CONTENT_CMT, CREATE_AT, RATING, USER_ID, ITEM_ID) " +
            "VALUES (:#{#cmt.getContent()}, :#{#cmt.getTime()}, :#{#cmt.getRating()}, :#{#cmt.getUserId()}, :#{#cmt.getItemId()})";
    String CHECK_CMT = "UPDATE comment SET IS_CHECK = :isCheck WHERE ID = :cmId";
    String SELECT_CMT="SELECT * FROM comment WHERE IS_CHECK = :isCheck AND ITEM_ID = :itemId";
    String SELECT_CMT_NOCHECK="SELECT * FROM comment WHERE IS_CHECK = :isCheck ";

    @Modifying
    @Query(value = INSERT_CMT, nativeQuery = true)
    int saveComment(@Param("cmt") Comment comment);
    @Modifying
    @Query(value = CHECK_CMT, nativeQuery = true)
    int checkComment(@Param("isCheck")Integer isCheck,@Param("cmId") Integer cmId);
    @Query(value = SELECT_CMT, nativeQuery = true)
    List<Comment> selectCMT(@Param("isCheck") Integer isCheck, @Param("itemId") Integer cmId);

    @Query(value = SELECT_CMT_NOCHECK, nativeQuery = true)
    List<Comment> selectCMTNoCheck(@Param("isCheck") Integer isCheck);
}
