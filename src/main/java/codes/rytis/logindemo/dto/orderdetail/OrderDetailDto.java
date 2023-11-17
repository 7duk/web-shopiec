package codes.rytis.logindemo.dto.orderdetail;

import codes.rytis.logindemo.entity.ItemDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetailDto {
    private Integer id;
    private Integer orderId;
    private ItemDetail itemDetailId;
    private Integer amount;
    private String note;
}
