package codes.rytis.logindemo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Table(name = "bill")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "CREATE_AT")
    private LocalDateTime createAt;
    @Column(name = "ORDER_ID")
    private Integer orderId;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID",insertable = false,updatable = false)
    private Order order;
    @Column(name = "VAT")
    private Integer vat;
    @Column(name = "Fee")
    private Double fee;

}
