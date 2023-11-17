package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatus,Integer> {

    @Query(value = "SELECT * FROM `delivery_status` WHERE `delivery_status`.ID = :DeStatusId", nativeQuery = true)
    DeliveryStatus getDelivetyStausById(@Param("DeStatusId") Integer DeStatusId);
}
