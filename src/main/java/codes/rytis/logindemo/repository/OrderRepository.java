package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Item;
import codes.rytis.logindemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    String INSERT_ORDER = "INSERT INTO `order`(DELIVERY_ADDRESS, TOTAL_FEE, DELIVERY_DATE, CREATE_AT, CUSTOMER_ID, PAYMENT_METHOD_ID)" +
            "VALUES (:#{#order.getDeliveryAddress()}, :#{#order.getTotalFee()},:#{#order.getDeliveryDate()}, :#{#order.getCreateAt()}, :#{#order.getCustomerId()},  :#{#order.getPayMethodId()})";
    @Modifying
    @Query(value = INSERT_ORDER, nativeQuery = true)
    void saveOrder(@Param("order") Order order);

    @Query(value = "SELECT * FROM `order`", nativeQuery = true)
    List<Order> getAllOrder();

    @Query(value = "SELECT * FROM `order` WHERE `order`.ID = :orderId", nativeQuery = true)
    Order getOrderById(@Param("orderId") Integer orderId);

    @Query(value = "SELECT * FROM `order` WHERE `order`.CUSTOMER_ID = :customerId", nativeQuery = true)
    List<Order> getOrderByCustomerId(@Param("customerId") Integer customerId);
}
