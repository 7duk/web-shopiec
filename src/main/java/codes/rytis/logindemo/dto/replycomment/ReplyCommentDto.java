package codes.rytis.logindemo.dto.replycomment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyCommentDto {
    private Integer id;
    private String content;
    private String time;
    private Integer userId;
    private Integer commentId;
}
