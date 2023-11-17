package codes.rytis.logindemo.dto.itemdetail;

import codes.rytis.logindemo.dto.orderdetail.OrderDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemDetailDto {
    private Integer itemId;
    private Integer colorId;
    private Integer amount;
    private List<OrderDetailDto> orderDetailDtos;
}
