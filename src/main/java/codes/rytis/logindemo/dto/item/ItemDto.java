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
public class ItemDto {
    private Integer id;
    private String name;
    private Double buyPrice;
    private Double sellPrice;
    private Integer discount;
    private String description;
    private LocalDateTime lastUpdateAt;
    private List<ImageItemDto> imagesItem;
}
