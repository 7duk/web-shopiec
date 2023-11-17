package codes.rytis.logindemo.dto.order;

import codes.rytis.logindemo.dto.bill.BillDto;
import codes.rytis.logindemo.dto.bill.BillOfOrderDto;
import codes.rytis.logindemo.dto.orderdeliverystatusdetail.OrderDeliveryStatusDetailDto;
import codes.rytis.logindemo.dto.orderdetail.OrderDetailDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Integer id;
    private String deliveryAddress;
    private Double totalFee;
    private LocalDate deliveryDate;
    private LocalDateTime createAt;
    private Integer customerId;
    private Integer paymentMethodId;
    private BillOfOrderDto bill;
    private List<OrderDetailDto> orderDetails;
    private List<OrderDeliveryStatusDetailDto> orderDeliveryStatusDetails;
}
