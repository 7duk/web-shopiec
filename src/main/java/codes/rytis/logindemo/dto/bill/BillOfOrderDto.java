package codes.rytis.logindemo.dto.bill;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BillOfOrderDto {
    private LocalDateTime createAt;
    private Integer vat;
    private Double fee;
}
