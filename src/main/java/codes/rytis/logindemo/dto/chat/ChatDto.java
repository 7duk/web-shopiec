package codes.rytis.logindemo.dto.chat;

import codes.rytis.logindemo.dto.message.MessageDto;
import codes.rytis.logindemo.dto.participant.ParticipantDto;
import lombok.*;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatDto {
    private Integer id;
    private Integer participantId1;
    private Integer participantId2;
    private ParticipantDto participant;
    private MessageDto messages;
}
