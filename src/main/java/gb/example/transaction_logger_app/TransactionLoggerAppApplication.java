package gb.example.transaction_logger_app;

import gb.example.transaction_logger_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TransactionLoggerAppApplication implements CommandLineRunner {

	@Autowired
	private TransactionService transactionService;

	public static void main(String[] args) {
		SpringApplication.run(TransactionLoggerAppApplication.class, args);
	}

	@Override
	public void run(String... args) {
		transactionService.validateTransaction();
		transactionService.processTransaction();
	}
}
