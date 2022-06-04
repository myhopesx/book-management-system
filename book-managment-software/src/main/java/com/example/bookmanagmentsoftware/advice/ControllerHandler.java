package com.example.bookmanagmentsoftware.advice;
import com.example.bookmanagmentsoftware.exeption.InvalidIdException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class ControllerHandler {
        @ExceptionHandler(value = MethodArgumentNotValidException.class)
        public ResponseEntity handleMethodArgument(MethodArgumentNotValidException methodArgumentNotValidException){
            String message=methodArgumentNotValidException.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }

        @ExceptionHandler(value = DataIntegrityViolationException.class)
        public ResponseEntity handleDataIntegrity(DataIntegrityViolationException dataIntegrityViolationException){
            String message=dataIntegrityViolationException.getRootCause().getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
    @ExceptionHandler(value = InvalidIdException.class)
    public ResponseEntity invalidIdException(InvalidIdException invalidIDException){
        String message=invalidIDException.getMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity handleException(Exception exception){
        System.out.println(exception.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server error!!!!!!");
    }
}
