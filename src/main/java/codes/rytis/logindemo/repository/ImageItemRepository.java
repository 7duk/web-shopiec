package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.ImageItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageItemRepository extends JpaRepository<ImageItem,Integer> {
}
