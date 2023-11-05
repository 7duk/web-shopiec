package codes.rytis.logindemo.dto.item;

import codes.rytis.logindemo.dto.imageitem.ImageItemDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ItemSaveDto {
    private String name;
    private Double buyPrice;
    private Double sellPrice;
    private Integer igId;
    private String description;
    private String lastUpdateAt;
}
