package codes.rytis.logindemo.dto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatRequest {
    private Integer participant_1;
    private Integer participant_2;
}
