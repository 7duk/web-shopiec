package codes.rytis.logindemo.dto.itemgroup;

import codes.rytis.logindemo.dto.item.ItemDto;
import codes.rytis.logindemo.entity.Item;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
public class ItemGroupDto {
    private Integer id;
    private String name;
    private String image;
    private List<ItemDto> items;
}
