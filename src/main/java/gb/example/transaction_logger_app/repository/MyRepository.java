package gb.example.transaction_logger_app.repository;

import gb.example.transaction_logger_app.model.MyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepository extends JpaRepository<MyEntity, Long> {
}