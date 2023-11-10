package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.dto.imageitem.ImageItemDto;
import codes.rytis.logindemo.dto.imageitem.ImageSaveDto;
import codes.rytis.logindemo.entity.ImageItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class ImageItemRepository  {
    @Autowired
    private JdbcTemplate template;
    String INSERT_IMAGE = "INSERT INTO image_item(IMAGE,ITEM_ID) VALUES(?,?)";
    public void saveImages(List<ImageSaveDto> images) {
        template.batchUpdate(INSERT_IMAGE, images, 100, (PreparedStatement ps, ImageSaveDto it) -> {
            ps.setString(1, it.getImage());
            ps.setInt(2, it.getItemId());
        });
    }
}
