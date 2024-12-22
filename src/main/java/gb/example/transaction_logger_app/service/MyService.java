package gb.example.transaction_logger_app.service;

import gb.example.transaction_logger_app.model.MyEntity;
import gb.example.transaction_logger_app.repository.MyRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyService {

    private final MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    @Transactional
    public void performOperation(MyEntity entity) {
        myRepository.save(entity);
        // Другие операции, которые должны быть в одной транзакции
        if (entity.getName().equals("Error")) {
            throw new RuntimeException("Intentional error to test rollback");
        }
    }
}