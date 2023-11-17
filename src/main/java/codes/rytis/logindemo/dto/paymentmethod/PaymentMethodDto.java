package codes.rytis.logindemo.dto.paymentmethod;

import codes.rytis.logindemo.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentMethodDto {
    private Integer id;
    private String desc;
}
