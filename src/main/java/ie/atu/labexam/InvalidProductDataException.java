package ie.atu.labexam;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class InvalidProductDataException extends RuntimeException{
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidProductDataException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getFieldErrors()){
            errors.put("error", "InvalidProductDataException");
            errors.put("message", error.getDefaultMessage());
            errors.put("Timestamp", String.valueOf(LocalDateTime.now()));
            errors.put("status", "400");
        }


        return ResponseEntity.status(400).body(errors);
    }
}
