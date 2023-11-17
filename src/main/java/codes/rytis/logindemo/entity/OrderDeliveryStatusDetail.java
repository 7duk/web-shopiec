package codes.rytis.logindemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "order_delivery_status_detail")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDeliveryStatusDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DELIVERY_STATUS_ID",insertable = false,updatable = false)
    private DeliveryStatus deliveryStatus;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID",insertable = false,updatable = false)
    private Order order;
    @Column(name = "LAST_UPDATE_AT")
    private LocalDateTime lastUpdateAt;
    @Column(name = "DESC")
    private  String desc;

}
