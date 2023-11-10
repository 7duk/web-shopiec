package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
    String INSERT_ITEM = "INSERT INTO item(NAME, ITEM_GROUP_ID, BUY_PRICE, SELL_PRICE, DESCRIPTION, LAST_UPDATE_AT) " +
            "VALUES (:#{#item.getName()}, :#{#item.getIgId()}, :#{#item.getBuyPrice()}, :#{#item.getSellPrice()}, :#{#item.getDescription()}, :#{#item.getLastUpdateAt()})";

    @Query(value = "SELECT * FROM item WHERE item.ITEM_GROUP_ID = :igId AND item.IS_DELETE = :isDel", nativeQuery = true)
    List<Item> getItemsByIgIdAndIsDelete(@Param("igId") Integer igId, @Param("isDel") Integer isDel);

    @Modifying
    @Query(value = INSERT_ITEM, nativeQuery = true)
    void saveItem(@Param("item") Item item);

    @Modifying
    @Query(value = "UPDATE item  SET item.IS_DELETE = 1 WHERE item.ID =:id",nativeQuery = true)
    int deleteItem(@Param("id") Integer itemId);

    @Modifying
    @Query(value = "UPDATE item  SET item.DISCOUNT = :discount,item.LAST_UPDATE_AT= :lastUpAt WHERE item.ID =:id",nativeQuery = true)
    int updateDiscountItem(@Param("id") Integer itemId, @Param("discount")Integer discount,@Param("lastUpAt") LocalDateTime lastUpAt);

    @Modifying
    @Query(value = "UPDATE item  SET item.NAME = :name,item.LAST_UPDATE_AT= :lastUpAt WHERE item.ID =:id",nativeQuery = true)
    int updateNameItem(@Param("id") Integer itemId, @Param("name")String name,@Param("lastUpAt")LocalDateTime lastUpAt);

    @Modifying
    @Query(value = "UPDATE item  SET item.DESCRIPTION = :description,item.LAST_UPDATE_AT= :lastUpAt WHERE item.ID =:id",nativeQuery = true)
    int updateDescriptionItem(@Param("id") Integer itemId, @Param("description")String name,@Param("lastUpAt")LocalDateTime lastUpAt);

    @Query(value = "SELECT ID FROM item WHERE item.NAME = :name",nativeQuery = true)
    Integer getIdByName(@Param("name") String name);
}
