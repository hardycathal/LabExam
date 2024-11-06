package ie.atu.labexam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ProductNotFoundException extends RuntimeException{
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>> handleProductNotFoundException(NoSuchElementException ex){
        Map<String, String> errors = new HashMap<>();
        errors.put("error", "ProductNotFoundException");
        errors.put("message", ex.getLocalizedMessage());
        errors.put("Timestamp", String.valueOf(LocalDateTime.now()));
        errors.put("status", String.valueOf(HttpStatus.NOT_FOUND));
        return ResponseEntity.status(404).body(errors);
    }
}
