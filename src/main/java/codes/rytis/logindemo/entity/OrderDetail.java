package codes.rytis.logindemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "order_detail")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ORDER_ID",insertable = false,updatable = false)
    private Order orderId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_DETAIL_ID",insertable = false,updatable = false)
    private ItemDetail itemDetailIDI;
    @Column(name = "AMOUNT", nullable = false)
    private int amount;
    @Column(name = "NOTE")
    private String note;
}
