package codes.rytis.logindemo.dto.imageitem;

import codes.rytis.logindemo.entity.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageItemDto {
    private Integer id;
    private String image;
}
