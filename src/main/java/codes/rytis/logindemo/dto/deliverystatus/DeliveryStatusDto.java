package codes.rytis.logindemo.dto.deliverystatus;

import codes.rytis.logindemo.dto.orderdeliverystatusdetail.OrderDeliveryStatusDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryStatusDto {
    private Long id;
    private String description;
    List<OrderDeliveryStatusDetailDto> orderDeliveryStatusDetails;
}
