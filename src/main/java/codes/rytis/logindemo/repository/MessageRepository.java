package codes.rytis.logindemo.repository;

import codes.rytis.logindemo.entity.Chat;
import codes.rytis.logindemo.entity.Message;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MessageRepository extends JpaRepository<Message,Integer> {
}
