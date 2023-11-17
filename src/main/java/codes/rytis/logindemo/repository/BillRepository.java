package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Bill;
import codes.rytis.logindemo.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill,Integer> {
    String INSERT_BILL = "INSERT INTO `bill`(CREATE_AT, ORDER_ID, VAT, Fee)" +
            "VALUES (:#{#bill.getCreateAt()}, :#{#bill.getOrderId()},:#{#bill.getVat()}, :#{#bill.getFee()})";
    @Modifying
    @Query(value = INSERT_BILL, nativeQuery = true)
    void saveBill(@Param("bill") Bill bill);
    @Query(value = "SELECT * FROM `bill`", nativeQuery = true)
    List<Bill> getAllBill();


}
