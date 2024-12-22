package gb.example.transaction_logger_app.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* gb.example.transaction_logger_app.service.TransactionService.*(..))")
    public void logBeforeMethodExecution() {
        System.out.println("LoggingAspect: A method is about to execute...");
    }

    @Around("execution(* gb.example.transaction_logger_app.service.TransactionService.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - start;
        System.out.println(joinPoint.getSignature() + " executed in " + executionTime + "ms");
        return proceed;
    }

    @AfterThrowing(pointcut = "execution(* gb.example.transaction_logger_app.service.TransactionService.*(..))", throwing = "error")
    public void logExceptions(Throwable error) {
        System.out.println("Exception caught: " + error.getMessage());
    }
}