package codes.rytis.logindemo.dto.itemdetail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailDto {
    private Integer itemId;
    private Integer colorId;
    private Integer amount;
}
