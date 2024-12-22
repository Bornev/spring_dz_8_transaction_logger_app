package gb.example.transaction_logger_app.service;

import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    public void processTransaction() {
        System.out.println("Processing transaction...");
    }

    public void validateTransaction() {
        System.out.println("Validating transaction...");
    }
}