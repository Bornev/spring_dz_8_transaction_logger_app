package gb.example.transaction_logger_app.controller;

import gb.example.transaction_logger_app.model.MyEntity;
import gb.example.transaction_logger_app.service.MyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MyController {

    private final MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @PostMapping("/save")
    public String saveEntity(@RequestBody MyEntity entity) {
        try {
            myService.performOperation(entity);
            return "Entity saved successfully!";
        } catch (Exception e) {
            return "Error: " + e.getMessage();
        }
    }
}