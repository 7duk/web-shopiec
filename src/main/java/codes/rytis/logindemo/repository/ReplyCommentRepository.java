package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Comment;
import codes.rytis.logindemo.entity.Item;
import codes.rytis.logindemo.entity.ReplyComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReplyCommentRepository extends JpaRepository<ReplyComment,Integer> {
    String INSERT_RP_CMT = "INSERT INTO reply_comment(CONTENT_CMT, CREATE_AT, USER_ID, COMMENT_ID) " +
            "VALUES (:#{#repCmt.getContent()}, :#{#repCmt.getTime()}, :#{#repCmt.getUserId()}, :#{#repCmt.getCommentId()})";
    String CHECK_CMT = "UPDATE reply_comment SET IS_CHECK = :isCheck WHERE ID = :repcmtId";
    String SELECT_REP_CMT="SELECT * FROM reply_comment WHERE IS_CHECK = :isCheck AND COMMENT_ID = :cmtID";
    String SELECT_NO_CHECK_REP_CMT="SELECT * FROM reply_comment WHERE IS_CHECK = :isCheck";

    @Modifying
    @Query(value = INSERT_RP_CMT, nativeQuery = true)
    int saveComment(@Param("repCmt") ReplyComment replyComment);
    @Modifying
    @Query(value = CHECK_CMT, nativeQuery = true)
    int checkReplyComment(@Param("repcmtId") Integer repcmtId,@Param("isCheck") Integer isCheck);
    @Query(value = SELECT_REP_CMT, nativeQuery = true)
    List<ReplyComment> selectReplyCMT(@Param("cmtID") Integer cmId,@Param("isCheck") Integer isCheck);

    @Query(value = SELECT_NO_CHECK_REP_CMT, nativeQuery = true)
    List<ReplyComment> selectNoCheckReplyCMT(@Param("isCheck") Integer isCheck);
}
