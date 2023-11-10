package codes.rytis.logindemo.dto.comment;

import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.dto.item.ItemUpdateDto;
import codes.rytis.logindemo.dto.participant.ParticipantDto;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private Integer id;
    private String content;
    private String time;
    private Integer rating;
    private Integer userId;
    private ParticipantDto participantDto;
    private Integer itemId;
    private ItemUpdateDto itemUpdateDto;
}
