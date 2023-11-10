package codes.rytis.logindemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "item_detail")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "AMOUNT")
    private Integer amount;
    @Column(name = "ITEM_ID")
    private Integer itemId;
    @Column(name = "COLOR_ID")
    private Integer colorId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID",insertable = false,updatable = false)
    @JsonIgnore
    private Item items;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "COLOR_ID",insertable = false,updatable = false)
    @JsonIgnore
    private Color color;

}
