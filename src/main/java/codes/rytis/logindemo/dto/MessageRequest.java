package codes.rytis.logindemo.dto;

import lombok.Data;

@Data
public class MessageRequest {
    private Integer senderId;
    private String message;
    private String time;
    private Integer chatId;
}
